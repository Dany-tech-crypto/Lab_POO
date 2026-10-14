public class Main {
    public static void main(String[] args) {
        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100, 20, "Lobo");
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120, "Maldición de la Muerte");
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10, 95);
        Personaje t1 = new Guerrero("Thorin", 9, 400, 80, "Cobre");
        Personaje b1 = new Druida("Brego", 7, 250, 80, 15, "Oso");
        Personaje k1 = new Nigromante("Kael", 5, 180, 90, "Maldición de la Oscuridad");

        // Crear los Runnable
        CombateConcurrente c1 = new CombateConcurrente("Campo-1", s1, m1, tabla);
        CombateConcurrente c2 = new CombateConcurrente("Campo-2", l1, t1, tabla);
        CombateConcurrente c3 = new CombateConcurrente("Campo-3", b1, k1, tabla);

        // Envolver en Thread e iniciar
        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);

        h1.start();
        h2.start();
        h3.start();

        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
        monitor.start();

        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];

        try {
            // Esperar hilos del torneo
            h1.join();   
            h2.join();   
            h3.join();   
            monitor.join();

            System.out.println("\nTodos los combates han terminado.");
            tabla.mostrarResultados();

            // --- Sin synchronized ---
            for (int i = 0; i < 5; i++) {
                hilos[i] = new Thread(() -> {
                    for (int j = 0; j < 1000; j++) contador.incrementar();
                });
                hilos[i].start();
            }
            for (Thread t : hilos) t.join(); // Protegido dentro del try
            System.out.println("Sin sync  — esperado: 5000 | real: " + contador.getContador());

            // --- Con synchronized ---
            contador.resetear();
            for (int i = 0; i < 5; i++) {
                hilos[i] = new Thread(() -> {
                    for (int j = 0; j < 1000; j++) contador.incrementarSeguro();
                });
                hilos[i].start();
            }
            for (Thread t : hilos) t.join(); // Protegido dentro del try
            System.out.println("Con sync  — esperado: 5000 | real: " + contador.getContador());

        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}