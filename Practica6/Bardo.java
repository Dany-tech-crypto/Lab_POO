public class Bardo extends Personaje implements Sanador {
    private int poderCuracion;
    private String instrumento;

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, String instrumento){
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
    }
    
    @Override
    public void atacar(){
        System.out.println(nombre + " ataca con su " + instrumento + " causando " + calcularDanio());
    }

    @Override 
    public int calcularDanio(){
        return nivel * 8;
    }

    @Override 
    public void curarAliado(Personaje aliado){
        aliado.estaVivo();
        aliado.puntosVida += poderCuracion;
        System.out.println(nombre + " cura a " + aliado.getNombre() + " por " + poderCuracion + " puntos de vida.");
    }

    @Override 
    public int getPoderCuracion(){
        return poderCuracion;
    }
}
