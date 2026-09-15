public class Main {
    public static void main(String[] args) {
        System.out.println("\n=== RPJ - Expansión: Nuevas Clases ===\n");

        Nigromante nigromante = new Nigromante("Morgath", 5, 100, 70, 70, "Arte Sangrienta");
        Druida druida = new Druida("Elowen", 4, 80, 50, 20, "Lobo");
        Bardo bardo = new Bardo("Lyra", 3, 60, 15, "Flauta");

        Personaje[] equipo = { nigromante, druida, bardo };

        System.out.println("-- Ataques y daño --");
        for (Personaje personaje : equipo) {
            personaje.atacar();

            System.out.println("\n-- Solo Hechiceros atacan --");    
            if (personaje instanceof Hechizero hechizero) {
                hechizero.lanzarHechizo();
            }

            System.out.println("\n-- Solo Sanadores curan --");
            if (personaje instanceof Sanador sanador){
                sanador.curarAliado(nigromante);
            }
        }

        System.out.println("\n=== Estado Final de los Personajes ===");
        System.out.println(nigromante);
        System.out.println(druida);
        System.out.println(bardo);
    }
}
