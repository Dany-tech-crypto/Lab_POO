public class Gato extends Animal
{
    private String color;
    private Boolean interior;

    public Gato(String nombre, int edad, double peso, String color, Boolean interior)
    {
        super(nombre, edad, peso);
        this.color = color;
        this.interior = interior;
    }

    public String getcolor(){
        return color;
    }

    public Boolean getinterior(){
        return interior;
    }

    public void maullar(){
        System.out.println(super.getnombre() + " esta maullando");
    }

    public void ronronear(){
        System.out.println(super.getnombre() + " esta ronroneando");
    }

    public void arañir(){
        System.out.println(super.getnombre() + " esta arañando");
    }


    @Override
    public String toString(){
        return super.toString() + " Color: " + color + " Es de interior?: " + (interior? "Si" : "No");
    }
}
