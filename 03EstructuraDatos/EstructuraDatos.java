/*
vamos a crear 14 programas dentro de un menu gigante
para poner a prueba sus conocimientos 
1.- desarrollar un programa para calcular el boni de un descuento por edad
2.- convertir numeros decimales a binarios
3.- convertir temperaturas entre los 3 principales grados C -> F y K
4.- Realizar un programa para contar numero de positivos y negativos de una serie de numeros 
5.- desarrollar una tienda para agregar productos y precios
6.- desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras
7.- desarrollar una tabla ahorita aver que se me ocurre 
8.- desarrollar un programa para calcular el factorial con recursividad
9.-vamos a hacer dibujitos 
10.- desarrollar un figura hueca
11.- realizar un diamante
12.- desarrollar una calcukladora basica + - * /
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
            System.out.println("\n\n\n\nESCOGE LA OPCION QUE DESEAS USAR");
            System.out.println("||=================================||");
            System.out.println("||1-Descuestos por edad perrones   ||");
            System.out.println("||2-Numeros decimales a binarios   ||");
            System.out.println("||3-Conversion de temperaturas     ||");
            System.out.println("||4-Contador de numeros            ||");
            System.out.println("||5-Tiendita kawai                 ||");
            System.out.println("||6-Calculadora de area y perimetro||");
            System.out.println("||7-Tabla de multiplicar           ||");
            System.out.println("||8-Factorial con recursividad     ||");
            System.out.println("||9-Cuadrado magico                ||");
            System.out.println("||10-Desarrollo de figura hueca    ||");
            System.out.println("||11-                              ||");
            System.out.println("||13-                              ||");
            System.out.println("||14-Salir                         ||");
            System.out.println("||=================================||");

            // entrada de datos

            opcion = entrada.nextInt();

            // ahora tenemos que evaluar la entrada

            switch (opcion) {

                case 1:
                    // descuentos segun la edad en el cine
                    System.out.println("\n\n\ndescuentos perrones");
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
                    
                    System.out.println("\n\nel precio normal es de:  $" + costo);
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
                    System.out.println("\n\n\ningrese un numero positivo enteroque se dese convertir en binario");
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
                        guardarbinario = "\n\nno se puede convertir ese numero, solo aceptapositivos";
                        
                    }
                    System.out.println("\n\nel numero convertido a binario es: " + guardarbinario);
                    break;





                case 3:
                    System.out.println("\n\n\nconversor de temperaturas");
                    System.out.println("las temperaturas son: C (celsius), F(Fahrenheit), K(Kelvin)");
                    
                    System.out.println("ingresa una temperatura: ");
                    double valor = 0;
                    valor = entrada.nextDouble();
                    //pa ver que tipo de temperatura es
                    System.out.println("que tipo es? (C/F/K)");
                    String escala = entrada.next().trim().toUpperCase();
                    // amos a leer a quitar espacios si pone y convetir su letra a mayusculas
                    
                    if (escala.length() != 1){
                        System.out.println("te dije que solo C, F o K animal :|");
                    escala = entrada.next().trim().toUpperCase();
                    }
                    
                    //lo siguiente dijo gepeto que lo usara pa que se me fuera el error
                    char tipo =escala.charAt(0);
                    double c = 0;
                    double f = 0;
                    double k = 0;
                    if (tipo == 'C'){
                        c = valor;
                        f = c* 9.0 / 5.0 + 32;
                        k = c + 273.15;
                    }
                    else if(tipo == 'F'){
                        f = valor;
                        c = (f - 32) * 5.0 / 9.0;
                        k = c + 273.15;
                    }
                    else if (tipo == 'K'){
                        k = valor;
                        c = k -273.15;
                        f = c * 9.0 / 5.0 + 32;
                    }
                    else{
                        System.out.println("ese tipo no existe menso, usa C, F o K");
                    escala = entrada.next().trim().toUpperCase();
                    }
                    //mostramos resultados
                    System.out.println("\n=== resultados ===");
                    System.out.printf("  %.2f °C\n", c);
                    System.out.printf("  %.2f °F\n", f);
                    System.out.printf("  %.2f K\n",  k);
                    break;




                case 4:
                    System.out.println("\n\n\ncontador de numeros negativos y positivos");
                    System.out.println("ingresa numero por numero");
                    System.out.println("cuando quieras terminar escibre 0");
                    //variables
                    int positivos = 0;
                    int negativos = 0;
                    int ceros = 0;
                    int numero;
                    System.out.println("numero: ");
                    numero = entrada.nextInt();
                    //contadores
                    while (numero != 0) {
                        if (numero > 0) {
                            positivos++;
                        }
                        else if (numero < 0) {
                            negativos++;
                        }
                        else{
                            ceros++;
                        }
                        System.out.println("numero: ");
                        numero = entrada.nextInt();
                    }
                    //resultados
                    System.out.println("resultados: ");
                    System.out.println("positivos: " + positivos);
                    System.out.println("negativos: " + negativos);
                    System.out.println("ceros: "+ ceros);
                    break;




                case 5:
                    System.out.println("\n\n\nBienvenido a esta hermosa tiendita linda y kawaii");
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
                    System.out.println("\n\n\n||==============================||");
                    System.out.println("||calculadora areas y perimetros||");
                    System.out.println("||1-Cuadrado                    ||");
                    System.out.println("||2-Rectangulo                  ||");
                    System.out.println("||3-Triangulo                   ||");
                    System.out.println("||4-Circulo                     ||");
                    System.out.println("||5-Trapecio                    ||");
                    System.out.println("||==============================||");
                    System.out.println("ingresa todos los datos que te pida");
                    System.out.println("ELIGE EL NUMERO (1-5): ");
                    
                    int eleccion = 0;
                    eleccion = entrada.nextInt();
                    //cuadrado
                    if (eleccion == 1){
                        System.out.println("Lado: ");
                        double lado = entrada.nextDouble();
                        double area = lado * lado;
                        double perimetro = 4 * lado;
                        System.out.println("CUADRADO");
                        System.out.printf("Area:  %.2f\n", area);
                        System.out.printf("perimetro: %.2f\n", perimetro);
                    }
                    //rectangulo
                    else if (eleccion == 2) {
                        System.out.println("base: ");
                        double base = entrada.nextDouble();
                        System.out.println("altura: ");
                        double altura = entrada.nextDouble();
                        double area = base * altura;
                        double perimetro = 2 * (base + altura);
                        System.out.println("RECTANGULO");
                        System.out.printf("Area:  %.2f\n", area);
                        System.out.printf("perimetro:  %.2f\n", perimetro);
                    }
                    //triangulo
                    else if (eleccion == 3) {
                        System.out.println("base: ");
                        double base = 0.0;
                        base = entrada.nextDouble();
                        System.out.println("Altura: ");
                        double altura = 0.0;
                        altura= entrada.nextDouble();
                        System.out.println("lado del triangulo: ");
                        double lado = 0.0;
                        lado = entrada.nextDouble();
                        double area =(base * altura) / 2;
                        double perimetro = lado + lado + lado;
                        System.out.println("TRIANGULO");
                        System.out.printf("Area:  %.2f\n", area);
                        System.out.printf("Perimetro:  %.2f\n", perimetro);
                    }
                    //circulo
                    else if (eleccion == 4) {
                        System.out.println("Radio: ");
                        double radio = 0.0;
                        radio = entrada.nextDouble();
                        double area = Math.PI * radio * radio;
                        double perimetro = 2 * Math.PI * radio;
                        System.out.println("CIRCULO");
                        System.out.printf("Area:  %.2f\n", area);
                        System.out.printf("Circunferencia:  %.2f\n", perimetro);
                    }
                    //trapecio
                    else if (opcion == 5) {
                        System.out.println("Base mayor: ");
                        double BaseMayor = 0.0;
                        BaseMayor = entrada.nextDouble();
                        System.out.println("Base menor: ");
                        double BaseMenor = 0.0;
                        BaseMenor = entrada.nextDouble();
                        System.out.println("Altura");
                        double altura = 0.0;
                        altura = entrada.nextDouble();
                        System.out.println("lateral 1: ");
                        double lateral1 = 0.0;
                        lateral1 = entrada.nextDouble();
                        System.out.println("lateral 2");
                        double lateral2 = 0.0;
                        lateral2 = entrada.nextDouble();
                        double area = ((BaseMayor + BaseMenor) / 2) * altura;
                        double perimetro = BaseMayor + BaseMenor + lateral1 + lateral2;
                        
                        System.out.println("TRAPECIO");
                        System.out.printf("Area:  %.2\n", area);
                        System.out.printf("perimetro:  %.2\n", perimetro);
                    }
                    else{
                        System.out.println("\nesa opcion que hijo te dije elige del 1 al 5 animal de granja");
                        eleccion = entrada.nextInt();
                    }
                    break;




                case 7:
                    //Tabla de Multiplicar 
                    for (int n = 0; n <= 10; n++) {
                        System.out.println(" | " + n + " " + " | " + (n*10 + " "  + " | " + (n*100) + "" + " | " + (n*1000)));
                    }   
                break;




                case 8:
                    System.out.println( "=== factorial recursivo===");
                    System.out.println("Ingresa un numero");
                    
                    int cantidad = entrada.nextInt();
                    if (cantidad < 0){
                        System.out.println("no se puede calcular factorial negativo");
                        cantidad = entrada.nextInt();
                    }
                    if(cantidad == 0 || cantidad == 1){
                        System.out.println(cantidad + "! = 1");
                        cantidad = entrada.nextInt();
                    }
                    //pa numeros cabrones usamos el long pa 20 asi bien cabron
                    long factorial = new Object(){long fact(int n){return n==0 || n== 1 ? 1 : n*fact(n-1);}}.fact(cantidad);
                    System.out.println(cantidad + "! = ");
                    for(int i = 1; i <= cantidad; i++){
                        //con esta madre vamos a mostrar el proceso y de que lado masca la iguana
                        if (i < cantidad){
                            System.out.print(i + " x ");
                        }else{
                            System.out.print(i + " = ");
                        }
                    }
                    System.out.println(factorial);
                    //ya si es muy grande
                    if(cantidad > 20){
                        System.out.println("\nNota: para numeros > 20 el resultado no alcanza perdon :)");
                    }
                    break;





                case 9:
                    System.out.println("Vamos a realizar un dibujo de un cuadrado magico");
                    System.out.println("Ingrese el tamaño del cuadrado (Entre 1 y 20): ");
                    int n1 = entrada.nextInt();
                    if (n1 >= 1 && n1 <= 20) {
                        // Se imprime
                        for (int i = 1; i <= n1; i++) {
                            // Se recorren las columnas
                            for (int j = 1; j <= n1; j++) {
                                System.out.print("* ");
                            }
                            System.out.println(" ");
                        }
                    } else {
                        System.out.println("Porfavor ingrese un numero entre 1 y 20");
                    }
                    break;




                case 10:
                    System.out.println("\n\nfigura hueca");
                    System.out.println("Ingresa el tamaño del cuadrado");
                    int cifra = entrada.nextInt();
                    if (cifra < 2){
                        System.out.println("el tamaño debe ser minimo de 2");
                        break;
                    }
                    for(int i = 1; i <= cifra; i++){
                        for(int j = 1; j <= cifra; j++){
                            //solo imprime * en los bordes}
                            if(i == 1 || i == cifra || j ==1 || j == cifra){
                                System.out.print("* ");
                            }else{
                                System.out.print("  ");
                            }
                        }
                        System.out.println();//pa que de un salto de linea la chingadera
                    }
                    break;





                case 11:
                    System.out.println("vamo a hacer un diamante");
                    System.out.println("Ingresa el tamaño del diamante (la mitad)");
                    int digito = entrada.nextInt();
                    if (digito < 1){
                        System.out.println("Eltamaño minimo debe ser de 1");
                        break;
                    }
                    //pal pico del miamiante
                    for (int i = 1; i <= digito; i++){
                        for(int j = 1; j <= digito - i; j++){
                            System.out.print("  ");
                        }
                        for(int j =1; j <= 2 * i - 1; j++ ){
                            System.out.print("* ");
                        }
                        System.out.println();//pa que me salte esta xdxdxdxd
                    }
                    //pa la parte de abajo del miamiante
                    for(int i = digito -1; i >= 1; i--){
                        for (int j = 1; j <= digito - i; j++){
                            System.out.print("  ");
                        }
                        for(int j = 1; j <= 2 * i - 1; j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;




                case 12:
                    break;






                case 14:
                    System.out.print("\n\nSaliendo ");
                    
                    char[] palitos = {'|', '/', '-', '\\'};
                    for (int i = 0; i < 33; i++) {  // ≈5 segundos (33 × 150ms)
                        System.out.print("\b" + palitos[i % 4]);
                        try {
                            Thread.sleep(150);
                        } catch (InterruptedException ignored) {}
                    }
                    
                    System.out.println("\n¡Hasta luego!");
                    entrada.close();
                    System.exit(0);
                    break;




                default:
                    System.out.println("\n\nesa mmda que hijo no esta esa opcion, pon otra :|");
                    break;
            }
            System.out.println("\n\nDeseas repetir el programa? escribe S o s para si");
            letrapararepetir = entrada.next().charAt(0);
        } while (letrapararepetir == 's' || letrapararepetir == 'S');
    }
}