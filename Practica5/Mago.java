public class Mago extends Personaje {
    private int mana;
    private String tipoHechizo;

    public Mago(String nombre, int puntosVida, int nivel, int mana, String tipoHechizo){
        super(nombre, puntosVida, nivel);
        this.mana = mana;
        this.tipoHechizo = tipoHechizo;
    }

    public int getMana(){
        return mana;
    }

    public String getTipoHechizo(){
        return tipoHechizo;
    }

    @Override 
    public int calcularDanio(){
        return getNivel() * mana;
    }

    @Override
    public void atacar(){
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza un hechizo de tipo " + getTipoHechizo() + " causando " + getMana() + " puntos de daño!");
    }

    @Override
    public void defender(){
        System.out.println("¡" +getNombre() + " realiza un escudo magico ");
    }
}
