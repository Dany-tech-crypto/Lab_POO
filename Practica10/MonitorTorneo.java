public class MonitorTorneo extends Thread {
    private String nombreCampo;
    private int duracionSegundos;

    public MonitorTorneo(String nombreCampo, int duracionSegundos) {
        this.nombreCampo = nombreCampo;
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public void run(){
        System.out.println("[Monitor] Vigilando campo " + nombreCampo + "\n");

        for(int i = 0; i <= duracionSegundos; i++){
            try {
                Thread.sleep(1000);
                System.out.println("[Monitor] " + nombreCampo + " - segundo " + i + " de " + duracionSegundos + "\n");
            } catch (InterruptedException e) {
                System.out.println("[Monitor] Monitoreo interrumpido.\n");
                Thread.currentThread().interrupt();
                return ;
            }
        }

        System.out.println("[Monitor] " + nombreCampo + " finalizado.");
    }
    
}
