public class Main {
    public static void main(String[] args) {
        // Inicialización de motor y personajes base para las pruebas
        MotorCombate motor = new MotorCombate();
        Druida druida = new Druida("Panoramix", 5, 100, 30, 20, "Oso");
        Nigromante nigromante = new Nigromante("Malakor", 5, 120, 0, 40, "Sombra");

        System.out.println("=== INICIANDO PRUEBAS DEL SISTEMA RPG ==="); // O System.out.println

        // ==========================================
        // Escenario 1 — Turno normal sin excepción
        // ==========================================
        System.out.println("\n--- ESCENARIO 1: Turno normal sin excepción ---");
        try {
            motor.ejecutarTurno(druida, nigromante);
        } catch (Exception e) { 
            // Si MotorCombate lanza excepciones generales o RpgException
            System.out.println("Excepción inesperada: " + e.getMessage());
        }

        // ==========================================
        // Escenario 2 — Personaje derrotado intenta atacar
        // ==========================================
        System.out.println("\n--- ESCENARIO 2: Personaje derrotado intenta atacar ---");
        try {
            druida.recibirDanio(9999); // Primero derrota al druida
            
            // Forzamos la llamada directa al ataque para que lance la excepción al Main
            druida.atacar(); 
            
        } catch (PersonajeDerrotadoException e) {
            System.out.println("Capturado correctamente: " + e.getMessage());
        } catch (RpgException e) {
            System.out.println("Capturada otra RpgException: " + e.getMessage());
        }

        // ==========================================
        // Escenario 3 — Arquero sin flechas
        // ==========================================
        System.out.println("\n--- ESCENARIO 3: Arquero sin flechas ---");
        try {
            Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
            
            // Llamamos directamente a atacar para probar la excepción de recursos
            sinFlechas.atacar(); 
            
        } catch (RecursoInsuficienteException e) {
            System.out.println("Capturado correctamente (Recurso insuficiente): " + e.getMessage());
        } catch (RpgException e) {
            System.out.println("Capturada otra RpgException: " + e.getMessage());
        }

        // ==========================================
        // Escenario 4 — Curar aliado derrotado
        // ==========================================
        System.out.println("\n--- ESCENARIO 4: Curar aliado derrotado ---");
        Druida druida2 = new Druida("Silvanus", 5, 100, 30, 20, "Lobo");
        
        // Reutilizamos al druida original (que ya fue derrotado en el Escenario 2) como aliado derrotado
        try {
            druida2.curarAliado(druida);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        // ==========================================
        // Escenario 5 — Daño negativo con finally
        // ==========================================
        System.out.println("\n--- ESCENARIO 5: Daño negativo con finally ---");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        // ==========================================
        // Escenario 6 — Mostrar bitácora completa
        // ==========================================
        System.out.println("\n--- ESCENARIO 6: Bitácora completa del combate ---");
        motor.mostrarBitacora();
    }
}