public class Nigromante extends Personaje implements Hechizero {
    private int manaOscuro;
    private String maldicion;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int manaOscuro, String maldicion){
        super(nombre, nivel, puntosVida);
        this.manaOscuro = manaOscuro;
        this.maldicion = maldicion;
    }

    @Override 
    public void atacar(){
        System.out.println(nombre + " ataca con su maldicion de " + maldicion + " causando " + calcularDanio() + " daño.");
    }

    @Override 
    public int calcularDanio(){
        return nivel * 12;
    }

    @Override 
    public void lanzarHechizo(){
        if(manaOscuro >= 15){
            manaOscuro -= 15;
            System.out.println(nombre + " lanza un hechizo oscuro causando " + calcularDanio() + " daño.");
        } else {
            System.out.println("Mana oscuro insuficiente.");
        }
    }

    @Override 
    public int getMana(){
        return manaOscuro;
    }
}
