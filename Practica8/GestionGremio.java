import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GestionGremio {

    private ArrayList<Personaje> roster;
    private java.util.LinkedList<String> colaTurnos;
    private java.util.HashMap<String, Integer> inventario;
    private java.util.HashSet<String> habilidades;

    public GestionGremio() {
        roster      = new ArrayList<>();
        colaTurnos  = new java.util.LinkedList<>();
        inventario  = new java.util.HashMap<>();
        habilidades = new java.util.HashSet<>();
    }

    // ──────────────────────────────────────────
    // SECCIÓN 1 — ArrayList: roster de personajes
    // ──────────────────────────────────────────

    public void agregarMiembro(Personaje p) {
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personaje> it = roster.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();   // forma segura de eliminar durante iteración
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (Personaje p : roster) {      // for-each
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");
        for (int i = 0; i < roster.size(); i++) {
            Personaje p = roster.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() +
                               " | Nivel: " + p.getNivel() +
                               " | Vida: " + p.getPuntosVida());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 2 — LinkedList: cola de turnos
    // ──────────────────────────────────────────

    public void encolarSolicitante(String nombre) {
        colaTurnos.addLast(nombre);    // agrega al final
        System.out.println("[Cola] " + nombre +
                        " en posición " + colaTurnos.size());
    }

    public String atenderSiguiente() {
        if (colaTurnos.isEmpty()) {
            System.out.println("[Cola] No hay solicitantes en espera.");
            return null;
        }
        String atendido = colaTurnos.removeFirst();   // saca del frente
        System.out.println("[Cola] Atendiendo a: " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
        int pos = 1;
        for (String nombre : colaTurnos) {    // for-each sobre LinkedList
            System.out.println(pos++ + ". " + nombre);
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 3a — HashMap: inventario de objetos
    // ──────────────────────────────────────────

    public void agregarItem(String item, int cantidad) {
        int cantidadActual = inventario.getOrDefault(item, 0);
        int nuevaCantidad = cantidadActual + cantidad;
        inventario.put(item, nuevaCantidad);
        System.out.println("[Inventario] " + cantidad + "x " + item + " añadido(s). Total actual: " + nuevaCantidad);
    }

    public void usarItem(String item) {
        if (inventario.containsKey(item)) {
            int cantidadActual = inventario.get(item);
            if (cantidadActual > 0) {
                int nuevaCantidad = cantidadActual - 1;
                if (nuevaCantidad == 0) {
                    inventario.remove(item);
                    System.out.println("[Inventario] Se usó la última unidad de " + item + ". Item agotado y removido.");
                } else {
                    inventario.put(item, nuevaCantidad);
                    System.out.println("[Inventario] Se usó 1x " + item + ". Quedan: " + nuevaCantidad);
                }
            } else {
                System.out.println("[Inventario] Error: El item " + item + " no tiene unidades disponibles.");
                inventario.remove(item);
            }
        } else {
            System.out.println("[Inventario] Error: El item '" + item + "' no existe en el inventario.");
        }
    }

    public void mostrarInventario() {
        System.out.println("\n=== Inventario del Gremio (" + inventario.size() + " tipos de items) ===");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 3b — HashSet: habilidades únicas
    // ──────────────────────────────────────────

    public void registrarHabilidad(String habilidad) {
        boolean esNueva = habilidades.add(habilidad);
        if (esNueva) {
            System.out.println("[Habilidades] ¡Nueva habilidad registrada con éxito: " + habilidad + "!");
        } else {
            System.out.println("[Habilidades] La habilidad '" + habilidad + "' ya se encontraba registrada.");
        }
    }

    public boolean tieneHabilidad(String habilidad) {
        return habilidades.contains(habilidad);
    }

    public void mostrarHabilidades() {
        System.out.println("\n=== Habilidades del Gremio (" + habilidades.size() + " únicas) ===");
        for (String hab : habilidades) {
            System.out.println("- " + hab);
        }
    }
}