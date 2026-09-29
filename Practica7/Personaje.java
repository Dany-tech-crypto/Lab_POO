public abstract class Personaje 
{
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;


    public Personaje(String nombre, int nivel, int puntosVida)
    {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
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
    public boolean estaVivo(){
        return estaVivo;
    }


    public void recibirDanio( int danio) throws AccionInvalidaException {
        if(danio < 0){
            throw new AccionInvalidaException(
                "recibirDanio", 
                "El daño no puede ser negativo: "+ danio);
        }
        puntosVida -= danio;
        if(puntosVida <= 0) {
            estaVivo = false;
            System.out.println(nombre + "ha sido derrotado");
        }
        System.out.println(nombre + " ha recibido " + danio + " de daño." + "Vida: " + puntosVida);
    }


    public abstract void atacar() throws RpgException;
    public abstract int calcularDanio();


    @Override
    public String toString()
    {
        String vivo = estaVivo ? "Vivo" : "Muerto";
        return String.format("Nombre: %-10s | Nivel: %-3d | Vida: %-5d | Estado: %s", nombre, nivel, puntosVida, vivo);
    }
}
