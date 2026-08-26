public class Avion extends vehiculo
{
    private double altitudMaxima;
    private int numMotores;

    public Avion(String marca, String modelo, int anio, double velocidadMax, double altitudMaxima, int numMotores)
    {
        super(marca, modelo, anio, velocidadMax);
        setAltitudMaxima(altitudMaxima);
        setNumMotores(numMotores);
    }

    public double getAltitudMaxima() { return altitudMaxima; }
    public int getNumMotores() { return numMotores; }

    public void setAltitudMaxima(double altitudMaxima)
    {
        if(altitudMaxima > 10000 && altitudMaxima < 35000){
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: altitud maxima no valida");
        }
    }

    public void setNumMotores(int numMotores)
    {
        if(numMotores >= 1 && numMotores <= 4){
            this.numMotores = numMotores;
        } else {
            System.out.println("Error: numero de motores no valido");
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\n Altitud Maxima = " + altitudMaxima + "m, Numero de Motores = " + numMotores + "\n";
    }
}
