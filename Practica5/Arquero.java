public class Arquero extends Personaje {
    private int precision;
    private String tipoFlecha;

    public Arquero(String nombre, int puntosVida, int nivel, int precision, String tipoFlecha){
        super(nombre, puntosVida, nivel);
        this.precision = precision;
        this.tipoFlecha = tipoFlecha;
    }

    public int getPrecision(){
        return precision;
    }
    public String getTipoFlecha(){
        return tipoFlecha;
    }

    @Override
    public int calcularDanio(){
        return getNivel() * precision;
    }

    @Override
    public void atacar(){
        super.atacar();
        System.out.println("¡" + getNombre() + " dispara una flecha de tipo " + getTipoFlecha() + " con una precisión de " + getPrecision() + "%!");
    }

    @Override
    public void defender(){
        System.out.println("¡" + getNombre() + " esquiva el ataque enemigo!");
    }
}
