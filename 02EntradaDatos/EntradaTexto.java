import java.util.Scanner;

class EntradaTexto {
    //metodo principal
    public static void main(String[] args){

        //instanciamos el objeto
        Scanner entrada = new Scanner(System.in);
       //las variables locales
       String nombre;
       int edad;
       //entrada
       System.out.println("escribe tu nombre");
       nombre= System.console().readLine();

       System.out.println("hola " + nombre + " bienvenido a programar my feo");

       System.out.println("Escribe tu edad: ");
       edad = entrada.nextInt();
       System.out.println("hola " + nombre +" tu edad es de "+ edad);
    }
    
}
