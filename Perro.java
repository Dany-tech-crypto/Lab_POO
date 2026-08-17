public class Perro extends Animal
{
    private String raza;
    private Boolean vacunado;

        public Perro(String nombre, int edad, double peso, String raza, Boolean vacunado)
        {
            super(nombre, edad, peso);
            this.raza = raza;
            this.vacunado = vacunado;
        }


        public String getraza(){
            return raza;
        }

        public Boolean getvacunado(){
            return vacunado;
        }

        public void ladrar(){
            System.out.println(super.getnombre() + " esta ladrando");
        }

        public void buscarPelora(){
            System.out.println(super.getnombre()+ " esta buscando la pelota");
        }


        @Override
        public String toString(){
            return super.toString() + " Raza: " + raza + " Esta vacunado?: " + (vacunado? "Si" : "No");
        }
}