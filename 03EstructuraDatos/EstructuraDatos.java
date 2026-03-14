/*
vamos a crear 14 programas dentro de un menu gigante
para poner a prueba sus conocimientos 
1.- desarrollar un programa para calcular el boni de un descuento por edad
2.-  convertir numeros decimales a binarios
3.- convertir temperaturas entre los 3 principales grados C -> F y K
4.- Realizar un programa para contar numero de positivos y negativos de una serie de numeros 
5.- desarrollar una tienda para agregar productos y precios
6.- desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.- desarrollar una tabla ahorita aver que se me ocurre 
8.- desarrollar un programa para calcular el factorial 
9.-vamos a hacer dibujitos 
10.- desarrollar un figura hueca
11.- desarrolar unos patrones
12.- realizar un diamante
13.- desarrollar una calcukladora basica + - * /
*/

import java.util.Scanner;

class EstructuraDatos {
    public static void main(String[] args) {
        // aqui van las variables

        int opcion;
        char letrapararepetir;

        // aqui van los objetos

        Scanner entrada = new Scanner(System.in);

        // aqui va el menu

        do {

            System.out.println("   |==============================|");
            System.out.println("1.-||descuestos por edad perrones||");
            System.out.println("2.-||numeros decimales a binarios||");
            System.out.println("3.-");
            System.out.println("4.-");
            System.out.println("5.-");
            System.out.println("6.-");
            System.out.println("7.-");
            System.out.println("8.-");
            System.out.println("9.-");
            System.out.println("10.-");
            System.out.println("11.-");
            System.out.println("12.-");
            System.out.println("13.-");
            System.out.println("14.- Salir");

            // entrada de datos

            opcion = entrada.nextInt();

            // ahora tenemos que evaluar la entrada

            switch (opcion) {

                case 1:
                    // descuentos segun la edad en el cine
                    System.out.println("descuentos perrones");
                    System.out.println("ingrese su edad");
                    int edad;
                    edad = entrada.nextInt();
                    double costo = 250.0;
                    double descuento = 0;

                    if (edad <= 5) {
                        descuento = 0.40;
                    }
                    else if(edad <= 12){
                        descuento = 0.30;
                    }
                    else if(edad >= 60){
                        descuento = 0.35;
                    }
                    // si no esta ni tan viejo ni tan joven ps 0 xd
                    double precioFinal = costo -(costo * descuento);
                    
                    System.out.println("el precio normal es de:  $" + costo);
                    System.out.println("tu descuento perron es de:  " + (descuento * 100) + "%");
                    if (edad > 12){
                        if (edad < 60) {
                        System.out.println("pa ti no hay descuento perron ");
                        }
                    }
                    System.out.println("el precio ya con el descuento es de:  $" + precioFinal);
                    break;




                case 2:
                    // convertir un numero decimal a binario
                    System.out.println("ingrese un numero positivo enteroque se dese convertir en binario");
                    int numbinario;
                    String guardarbinario = "";
                    numbinario = entrada.nextInt();

                    if (numbinario > 0) {
                        // realizamos el modulo de 2
                        while (numbinario > 0) {
                            if (numbinario % 2 == 0) {
                                guardarbinario = "0" + guardarbinario;
                            } else {
                                // tas pendejo hijo
                                guardarbinario = "1" + guardarbinario;
                            }
                            numbinario = (int) numbinario / 2;
                        }
                    } else if (numbinario == 0) {
                        guardarbinario = "0";
                    } else {
                        guardarbinario = "no se puede convertir ese numero, solo aceptapositivos";
                    }
                    System.out.println("el numero convertido a binario es: " + guardarbinario);
                    break;





                case 3:
                    break;




                case 4:
                    break;




                case 5:
                    System.out.println("Bienvenido a esta hermosa tiendita linda y kawaii");
                    System.out.println("Por favor ingrese cuantos elementos va a comprar:");
                    int elementosproducto = 0;
                    elementosproducto = entrada.nextInt();
                    if (elementosproducto > 0) {
                        float compra = 0;
                        for (int i = 1; i <= elementosproducto; i++) {
                            System.out.println("Ingrese el nombre del producto");
                            String nombreproducto = "";
                            nombreproducto = entrada.next();
                            System.out.println("Ingrese el precio:");
                            float precio = 0.0f;
                            precio = entrada.nextFloat();
                            float resultado;
                            System.out.println("Ingrese la cantidad de producto:");
                            int cantidad = 0;
                            cantidad = entrada.nextInt();
                            resultado = precio * cantidad;
                            compra = resultado + compra;                        }
                            System.out.println("El total de la compra es: " + compra);
                        } 
                    else {
                        
                        System.out.println("Ingrese solo cantidades positivas.");
                    }
                    break;




                case 6:
                    break;




                case 7:
                    break;




                case 8:
                    break;





                case 9:
                    break;




                case 10:
                    break;




                case 11:
                    break;




                case 12:
                    break;




                case 13:
                    break;






                case 14:
                    break;




                default:
                    break;
            }
            System.out.println("Deseas repetir el programa? escribe S o s para si");
            letrapararepetir = entrada.next().charAt(0);
        } while (letrapararepetir == 's' || letrapararepetir == 'S');
    }
}