public class Main {
    public static void main(String[] args) {
        GestionGremio gremio = new GestionGremio();
        
        // Sección 1: Roster
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 50, "Oso"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 60, "Arte demoniaca"));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        gremio.agregarMiembro(new Guerrero("Thorin", 12, 400, 80, "Cota de malla"));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        // Sección 2: Cola de turnos (¡Ahora dentro de main!)
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        gremio.atenderSiguiente();   // atiende a Gandalf (FIFO)
        gremio.mostrarCola();

        // Sección 3a: Inventario
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);  // suma → 8

        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");    // no existe
        gremio.mostrarInventario();

        // Sección 3b: Habilidades
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");    // duplicado — no se agrega

        gremio.mostrarHabilidades();

        System.out.println("¿Tiene habilidad tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene habilidad curación? " + gremio.tieneHabilidad("Curación"));

        // Reporte final
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}