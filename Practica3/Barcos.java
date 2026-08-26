public class Barcos extends vehiculo
{
    private double tonelajeMaximo;
    private int numTripulantes;;

    public Barcos(String marca, String modelo, int anio, double velocidadMax, double tonelajeMaximo, int numTripulantes)
    {
        super(marca, modelo, anio, velocidadMax);
        setTonelajeMaximo(tonelajeMaximo);
        setNumTripulantes(numTripulantes);
    }

    public double getTonelajeMaximo() { return tonelajeMaximo; }
    public int getNumTripulantes() { return numTripulantes; }

    public void setTonelajeMaximo(double tonelajeMaximo)
    {
        if(tonelajeMaximo >= 10 && tonelajeMaximo <= 100){
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: tonelaje maximo no valido");
        }
    }

    public void setNumTripulantes(int numTripulantes)
    {
        if(numTripulantes >= 4 && numTripulantes <= 20){
            this.numTripulantes = numTripulantes;
        } else {
            System.out.println("Error: numero de tripulantes no valido");
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\n Tonelaje Maximo = " + tonelajeMaximo + " ton, Numero de Tripulantes = " + numTripulantes + "\n";
    }
    
}
