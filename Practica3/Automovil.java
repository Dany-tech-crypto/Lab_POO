public class Automovil extends vehiculo
{
    private int numPuertas;
    private Boolean esElectrico;

    public Automovil(String marca, String modelo, int anio, double velocidadMax, int numPuertas, Boolean esElectrico)
    {
        super(marca, modelo, anio, velocidadMax);
        setNumPuertas(numPuertas);
        this.esElectrico = esElectrico;;
    }

    public int getNumPuertas() { return numPuertas; }
    public Boolean isElectrico() {return esElectrico; }

    public void setNumPuertas(int numPuertas)
    {
        if(numPuertas >= 2 && numPuertas <= 6){
            this.numPuertas = numPuertas;
        } else {
            System.out.println("Error: numero de puertas no valido");
        }
    }

    @Override
    public String toString(){
        String tipoMotor = esElectrico ? "Elecrtico" : "Gasolina";
        return super.toString() + "\n Número de Puertas = " + numPuertas + ", Tipo de Motor = " + tipoMotor;
    }
}
