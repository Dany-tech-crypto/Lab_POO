public class Canario extends Animal
{
    private String color;
    private Boolean volar;

    public Canario(String nombre, int edad, double peso, String color, Boolean volar)
    {
        super(nombre, edad, peso);
        this.color = color;
        this.volar = volar;
    }

    public String getcolor(){
        return color;
    }

    public Boolean getvolar(){
        return volar;
    }

    public void cantar(){
        System.out.println(super.getnombre() + " esta cantando");
    }

    public void volar(){
        System.out.println(super.getnombre() + " esta volando");
    }


    @Override
    public String toString(){
        return super.toString() + " Color: " + color + " Vuela libre?: " + (volar? "Si" : "No");
    }
    
}
