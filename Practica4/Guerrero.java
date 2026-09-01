public class Guerrero extends Personaje {
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int puntosVida, int nivel, int fuerza, String armadura){
        super(nombre, puntosVida, nivel);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza(){
        return fuerza;
    }
    public String getArmadura(){
        return armadura;
    }

    @Override
    public void atacar(){
        super.atacar();
        System.out.println("¡" + getNombre() + " ataca con su espada causando " + getFuerza() + " puntos de daño!");
    }

    @Override
    public void defender(){
        System.out.println("¡" + getNombre() + " bloquea con su armadura de " + getArmadura() + "!");
    }
}
