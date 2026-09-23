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
    public void entrenar(){
        this.fuerza += 5;
        System.out.println(getNombre() + " ha entrenado y ahora tiene " + getFuerza());
    }
    public void entrenar(int sesiones){
        this.fuerza += 5 * sesiones;
        System.out.println(getNombre() + " ha entrenado " + sesiones + " veces y ahora tiene " + getFuerza());
    }
    public void entrenar(int sesiones, boolean intensivo){
        int incremento = 5 * sesiones;
        if(intensivo){
            incremento *= 2;
            System.out.println(getNombre() + " ha entrenado intensivamente");
        }
        this.fuerza += incremento;
        System.out.println(getNombre() + " ha entrenado " + sesiones + " veces y ahora tiene " + getFuerza());
    }

    @Override 
    public int calcularDanio(){
        return getNivel() * fuerza;
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
