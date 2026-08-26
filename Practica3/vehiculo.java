public class vehiculo
{
    private String marca;
    private String modelo;
    private int anio;

    protected double velocidadMax;

    public vehiculo(String marca, String modelo, int anio, double velocidadMax)
    {
        this.marca = marca;
        this.modelo = modelo;
        setAnio(anio);
        setVelicidadMax(velocidadMax);
    }

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public double getVelocidadMax() { return velocidadMax; }

    public void setAnio(int anio)
    {
        if(anio >= 1885 && anio <= 2100){
            this.anio = anio;
        } else {
            System.out.println("Error: año no valido");
        }
    }

    public void setVelicidadMax(double velocidadMax)
    {
        if(velocidadMax > 0){
            this.velocidadMax = velocidadMax;
        } else {
            System.out.println("Error: velocidad maxima no valida");
        }
    }

    public void describir() {
        System.out.println("Vehiculo: " + marca + " " + modelo + "(" + anio + ")");
    }

    @Override
    public String toString(){
        return "Vehiculo [Marca = " + marca + " | Modelo = " + modelo + " | Año = " + anio + " | Velocidad Maxima = " + velocidadMax + " km/h]";
    }
}