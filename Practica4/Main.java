public class Main {
    public static void main(String[] args) {
        System.out.println("=== Batalla RPG ===\n");

        Guerrero thorin = new Guerrero("Thorin", 100, 50, 120, "Cota de Malla");
        Mago gandalf = new Mago("Gandalf", 100, 50, 100, "Fuego");
        Arquero legolas = new Arquero("Legolas", 100, 50, 95, "Flecha de Hielo");

        System.out.println("-- Ronda 1: Ataques --");
        thorin.atacar();
        System.out.println();
        gandalf.atacar();
        System.out.println();
        legolas.atacar();
        System.out.println();


        System.out.println("-- Ronda 2: Defensas --");
        thorin.defender();
        gandalf.defender();
        legolas.defender();
        System.out.println();


        System.out.println("-- Daño recibido --");
        thorin.recibirDanio(60);
        gandalf.recibirDanio(200);
        System.out.println();


        System.out.println("-- Estado final --");
        System.out.println(thorin);
        System.out.println(gandalf);
        System.out.println(legolas);
    }
}