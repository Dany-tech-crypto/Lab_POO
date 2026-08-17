public class Animal
{
    private String nombre;
    private int edad;
    private double peso;

    public Animal(String nombre, int edad, double peso)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }


    public String getnombre(){
        return nombre;
    }

    public int getedad(){
        return edad;
    }

    public double getpeso(){
        return peso;
    }

    public void comer(){
        System.out.println(nombre + " esta comiendo");
    }

    public void dormir(){
        System.out.println(nombre + " esta durmiendo");
    }


    public String toString(){
        return "Nombre: " + nombre + " Edad: " + edad + " Peso: " + peso;
    }
}