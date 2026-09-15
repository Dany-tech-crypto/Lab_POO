public class Druida extends Personaje implements Sanador, Hechizero {
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
    public void atacar(){
        System.out.println(nombre + " ataca con su forma de " + formaAnimal + " causando " + calcularDanio());
    }

    @Override
    public int calcularDanio(){
        return nivel * 10;
    }

    @Override
    public void lanzarHechizo(){
        if(mana >= 10){
            mana -= 10;
            System.out.println(nombre + " lanza un hechizo causando " + calcularDanio() + " de daño. Mana restante: " + mana);
        } else {
            System.out.println("Mana insuficiente.");
        }
    }

    @Override 
    public int getMana(){
        return mana;
    }

    @Override 
    public void curarAliado(Personaje aliado){
        if(mana >= 5){
            mana -= 5;
            aliado.estaVivo();
            aliado.puntosVida += poderCuracion;
            System.out.println(nombre + " cura a " + aliado.getNombre() + " por " + poderCuracion + " puntos de vida. Mana restante: " + mana);
        } else {
            System.out.println("Mana insuficiente.");
        }
    }

    @Override 
    public int getPoderCuracion(){
        return poderCuracion;
    }
}
