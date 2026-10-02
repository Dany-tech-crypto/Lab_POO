public class Nigromante extends Personaje{
    private int manaOscuro;
    private String maldicion;

    public Nigromante(String nombre, int nivel, int puntosVida, int manaOscuro, String maldicion){
        super(nombre, nivel, puntosVida);
        this.manaOscuro = manaOscuro;
        this.maldicion = maldicion;
    }

    @Override 
    public void atacar() throws RpgException {
        // Verifica que esté vivo
        if (!estaVivo()) {
            throw new PersonajeDerrotadoException("El personaje está derrotado y no puede atacar.");
        }
        
        // Verifica que tenga al menos 15 de maná oscuro
        if (manaOscuro < 15) {
            throw new RecursoInsuficienteException("mana", manaOscuro);
        }
        
        // Resta 15 al maná oscuro y ejecuta el ataque
        manaOscuro -= 15;
        System.out.println(nombre + " ataca con su maldicion de " + maldicion + " causando " + calcularDanio() + " daño. Maná oscuro restante: " + manaOscuro);
    }

    @Override 
    public int calcularDanio(){
        return nivel * 12;
    }

    public void lanzarHechizo() throws RpgException {
        if(manaOscuro >= 15){
            manaOscuro -= 15;
            System.out.println(nombre + " lanza un hechizo oscuro causando " + calcularDanio() + " daño. Maná oscuro restante: " + manaOscuro);
        } else {
            throw new RecursoInsuficienteException("mana", manaOscuro);
        }
    }

    public int getMana(){
        return manaOscuro;
    }
}