public class MAIN
{
    public static void main(String[] args)
    {
        Perro perro = new Perro("Mofeo", 1, 4, "Snauzer", true);
        Gato gato = new Gato("Alfredo", 2, 3, "Blanco", false);
        Canario canario = new Canario("Pio", 1, 0.5, "Amarillo", true);

        perro.comer();
        perro.ladrar();
        perro.buscarPelora();
        perro.dormir();
        System.out.println(perro);

        System.out.println();

        gato.comer();
        gato.maullar();
        gato.ronronear();
        gato.dormir();
        System.out.println(gato);

        System.out.println();

        canario.comer();
        canario.cantar();
        canario.volar();
        canario.dormir();
        System.out.println(canario);
    }
}
