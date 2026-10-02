public class Arquero extends Personaje {
    private int precision;
    private String tipoFlecha;
    private int cantidadFlechas; // Atributo necesario para el Escenario 3

    public Arquero(String nombre, int nivel, int puntosVida, String tipoFlecha, int cantidadFlechas, int precision){
        super(nombre, nivel, puntosVida); // Orden correcto: nombre, nivel, puntosVida
        this.tipoFlecha = tipoFlecha;
        this.cantidadFlechas = cantidadFlechas;
        this.precision = precision;
    }

    public int getPrecision(){
        return precision;
    }
    
    public String getTipoFlecha(){
        return tipoFlecha;
    }

    public int getCantidadFlechas(){
        return cantidadFlechas;
    }


    public int calcularDanio(){
        return nivel * precision;
    }

    @Override
    public void atacar() throws RpgException {
        // 1. Verifica que esté vivo
        if (!estaVivo()) {
            throw new PersonajeDerrotadoException("El personaje está derrotado y no puede atacar.");
        }
        
        // 2. Verifica que tenga al menos 1 flecha
        if (cantidadFlechas < 1) {
            throw new RecursoInsuficienteException("flechas", cantidadFlechas);
        }
        
        // 3. Descuenta la flecha y ejecuta el ataque
        cantidadFlechas--;
        System.out.println("¡" + getNombre() + " dispara una flecha de tipo " + getTipoFlecha() + " con una precisión de " + getPrecision() + "% causando " + calcularDanio() + " de daño! Flechas restantes: " + cantidadFlechas);
    }

    public void defender(){
        System.out.println("¡" + getNombre() + " esquiva el ataque enemigo!");
    }
}