public class Personaje implements Combatiente
{
    private String nombre;
    private int puntosVida;
    private boolean estaVivo;
    private int nivel;

    public Personaje (String nombre, int puntosVida, int nivel)
    {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivel = nivel;
        this.estaVivo = true;
    }

    public String getNombre(){
        return nombre;
    }
    public int getVida(){
        return puntosVida;
    }
    public int getNivel(){
        return nivel;
    }
    public boolean isEstaVivo(){
        return estaVivo;
    }

    public void recibirDanio(int danio)
    {
        puntosVida -= danio;
        if(puntosVida <= 0){
            puntosVida = 0;
            estaVivo = false;
        }
        System.out.println(nombre + " Ha recibido " + danio + " Puntos de daño.\nPuntos de vida restantes: " + puntosVida);

        if(!estaVivo){
            System.out.println(nombre + " Ha muerto.");
        }
    }

    public int calcularDanio(){
        return getNivel() * 10; // Assuming a base damage value
    }

    
    @Override
    public void atacar(){
        System.out.println(nombre + " ataca con un golpe basico.");
    }

    @Override
    public void defender(){
        System.out.println(nombre + " se pone en guardia.");
    }

    @Override
    public String toString()
    {
        return("Nombre: " + nombre + 
        " | puntosVida: " + puntosVida + 
        " | nivel: " + nivel +
        " | Vivo: " + (estaVivo ? "sí" : "No"));
    }
}
