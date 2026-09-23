import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;

    public GestorBatalla(){
        this.historial = new ArrayList<>();
    }

    public void ejecutarAtaque(Personaje atacante){
        atacante.calcularDanio();
        atacante.atacar();

        System.out.println(atacante.getNombre() + " ha atacado y ha causado " + atacante.calcularDanio() + " puntos de daño.");
        historial.add(atacante.getNombre() + " ha atacado y ha causado " + atacante.calcularDanio() + " puntos de daño.");
    }

    public void ejecutarAtaque(Personaje atacante, Personaje defensor){
        atacante.calcularDanio();
        atacante.atacar();

        if(defensor != null && defensor.isEstaVivo()){
            defensor.defender();
            defensor.recibirDanio(atacante.calcularDanio());
        }

        System.out.println(atacante.getNombre() + " ha atacado a " + defensor.getNombre() + " y ha causado " + atacante.calcularDanio() + " puntos de daño.");
        historial.add(atacante.getNombre() + " ha atacado a " + defensor.getNombre() + " y ha causado " + atacante.calcularDanio() + " puntos de daño.");
    }

    public void ejecutarAtaque(Personaje[] equipo){
        for(Personaje p : equipo){
            if(p != null && p.isEstaVivo()){
                p.calcularDanio();
                p.atacar();
                System.out.println(p.getNombre() + " ha atacado y ha causado " + p.calcularDanio() + " puntos de daño.");
                historial.add(p.getNombre() + " ha atacado y ha causado " + p.calcularDanio() + " puntos de daño.");
            }
        }
    }

    public void mostrarHistorial(){
        System.out.println("== Historial de batalla ==");
        if(historial .isEmpty()){
            System.out.println("No hay eventos registrados");
        } else {
            for(String evento : historial){
                System.out.println(evento);
            }
        }
    }

    public void limpiarHistorial(){
        historial.clear();
        System.out.println("Historial de batalla limpiado");
    }
}
