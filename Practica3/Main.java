public class Main {
    public static void main(String[] args){
        System.out.println("==== Sistema Multimodal (UML) ====");

        Automovil tesla = new Automovil("Tesla", "Model S", 2027, 250, 4, true);
        Avion boeing = new Avion("Boeing", "747", 2015, 920, 15000, 4);
        Barcos titanic = new Barcos("Titanic", "RMS Titanic", 1912, 40, 30, 17);

        System.out.println("\n" + tesla.toString());
        System.out.println("\n====================================\n");

        System.out.println(boeing.toString());
        System.out.println("====================================\n");

        System.out.println(titanic.toString());
    }
    
}
