public class Main {
    public static void main(String[] args) {
        System.out.println("=== Batalla RPG ===\n");

        Guerrero thorin = new Guerrero("Thorin", 100, 5, 200, "Cota de Malla");
        Mago gandalf = new Mago("Gandalf", 100, 8, 120, "Fuego");
        Arquero legolas = new Arquero("Legolas", 100, 6, 95, "Flecha de Hielo");

        System.out.println("=== Calculo de Daño inviduvidual ===");
        System.out.println(thorin.getNombre() + " (Guerrero) daño causado: " + thorin.calcularDanio() + " puntos de daño.");
        System.out.println(gandalf.getNombre() + " (Mago) daño causado: " + gandalf.calcularDanio() + " puntos de daño.");
        System.out.println(legolas.getNombre() + " (Arquero) daño causado: " + legolas.calcularDanio() + " puntos de daño.\n");
        System.out.println();

        System.out.println("=== Arreglo polimórfico ===");
        Personaje[] equipo = {thorin, gandalf, legolas};
        for( Personaje p : equipo){
            System.out.println(p.getNombre() + " daño: " + p.calcularDanio());
        }
        System.out.println();

        System.out.println("=== Gestor de Batalla ===");
        GestorBatalla gestor = new GestorBatalla();

        gestor.ejecutarAtaque(thorin);
        System.out.println();
        gestor.ejecutarAtaque(gandalf, thorin);
        System.out.println();
        gestor.ejecutarAtaque(equipo);
        System.out.println();

        gestor.mostrarHistorial();
        System.out.println();

        System.out.println("=== Identificador de tipos ===");
        for(Personaje p : equipo){
            if(p instanceof Guerrero){
                System.out.println(p.getNombre() + " es un Guerrero");
            } else if(p instanceof Mago){
                System.out.println(p.getNombre() + " es un Mago");
            } else if(p instanceof Arquero){
                System.out.println(p.getNombre() + " es un Arquero");
            }
        }
        System.out.println();

        System.out.println("=== Demostracion de sobrecarga ===");
        
        Guerrero Thorin = (Guerrero) thorin;

        Thorin.entrenar();
        Thorin.entrenar(5);
        Thorin.entrenar(2, true);

    }
}