public class Druida extends Personaje {
    private int mana;
    private int poderCuracion;
    private String formaAnimal;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String formaAnimal){
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaAnimal = formaAnimal;
    }

   @Override
    public void atacar() throws RpgException {
        // Verifica que esté vivo (pasándole un mensaje si el constructor lo requiere)
        if (!estaVivo()) {
            throw new PersonajeDerrotadoException("El personaje está derrotado y no puede atacar.");
        }
        
        // Verifica que tenga al menos 10 de maná (corregido el nombre de la clase)
        if (mana < 10) {
            throw new RecursoInsuficienteException("mana", mana);
        }
        
        // Resta 10 al maná y ejecuta el ataque normal
        mana -= 10;
        System.out.println(nombre + " ataca con su forma de " + formaAnimal + " causando " + calcularDanio() + ". Maná restante: " + mana);
    }

    public int calcularDanio(){
        return nivel * 10;
    }

    public void lanzarHechizo() throws RpgException {
        if(mana >= 10){
            mana -= 10;
            System.out.println(nombre + " lanza un hechizo causando " + calcularDanio() + " de daño. Maná restante: " + mana);
        } else {
            throw new RecursoInsuficienteException("mana", mana);
        }
    }

    public int getMana(){
        return mana;
    }

    public void curarAliado(Personaje aliado) throws RpgException {
        // Verifica que el aliado no sea null
        if (aliado == null) {
            throw new PersonajeNuloException("curarAliado");
        }
        // Verifica que el aliado esté vivo
        if (!aliado.estaVivo()) {
            throw new AccionInvalidaException("curarAliado", "No se puede curar a un personaje derrotado");
        }
        
        // Lógica de curación y costo de maná
        if(mana >= 5){
            mana -= 5;
            aliado.puntosVida += poderCuracion;
            System.out.println(nombre + " cura a " + aliado.getNombre() + " por " + poderCuracion + " puntos de vida. Maná restante: " + mana);
        } else {
            throw new RecursoInsuficienteException("mana", mana);
        }
    }

    public int getPoderCuracion(){
        return poderCuracion;
    }
}