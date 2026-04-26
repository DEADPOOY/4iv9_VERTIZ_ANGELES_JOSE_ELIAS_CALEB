import java.util.Scanner;

//me falto meter try catch y falte el dia que lo dijo haber si me lo acepta :)
//wuache try catch al fallo

public class CalculaFiguras{
    //wuachese profe el mejor codigo de mi vida ahora evite el copiar wazza👻👻
    Scanner entrada = new Scanner(System.in);
    public void menu(){
        int opcionMenu;
        do{
        //vamos a colocar 5 figuras en el menu y va a ser de ahi un chuich
        //triangulo, cuadrado, trapecio, circulo, rombo
        System.out.println("\nIngresa la opcion que deseas usar");
        System.out.println("||================================||");
        System.out.println("||1.-Circulo                      ||");
        System.out.println("||2.-cuadrado                     ||");
        System.out.println("||3.-Triangulo                    ||");
        System.out.println("||4.-Trapecio                     ||");
        System.out.println("||5.-Rombo                        ||");
        System.out.println("||0.-Salir                        ||");
        System.out.println("||================================||");
        System.out.println("\n");

        try{
        opcionMenu = entrada.nextInt();
        switch (opcionMenu) {
            //mire profe aqui no recuerdo muy bien pero en progra basica enseñaron clases asi
            //de que ponemos el nombre en el chuich y ya de ahi hacemos la clase con ese nomble
            case 1:
                CalcularCirculo();
                break;
            case 2:
                CalcularCuadrado();
                break;
            case 3:
                CalcularTriangulo();
                break;
            case 4:
                CalcularTrapecio();
                break;
            case 5:
                CalcularRombo();
                break;
            case 0:
                System.out.println("gracias por usar el programa");
            default:
                System.out.println("opcion invalida escoje del 0-5");
        }
        }catch (Exception e){
            System.out.println("debes ingresar un numero valido");
            entrada.nextLine();
            opcionMenu = -1;
        }
        }while (opcionMenu != 0);
    }
    //si funciono na la mera verdura del caldo
    //es mas profe yo doy la clase 👻👻, nah mentira
    public void CalcularCirculo(){
        try{
        System.out.println("\nintroduce el radio del circulo");
        float r = entrada.nextFloat();
        if(r <= 0){
            System.out.println("el radio debe ser mayor que 0");
            return;
        }
        double di = r*2;
        double Area = Math.PI * r * r;//no supe como meter el cuadrado xd
        double Perimetro = Math.PI * di;
        System.out.println("\nEl area del circulo es de: " + Area);
        System.out.println("El perimetro del circulo es: " + Perimetro);
        }catch(Exception e){
            System.out.println("debes ingresar un numero valido");
            entrada.nextLine();
        }
    }
    public void CalcularCuadrado(){
        try{
        System.out.println("\nintroduce el lado del cuadrado");
        float L = entrada.nextFloat();
        if (L <= 0){
            System.out.println("el lado debe ser mayor de 0");
            return;
        }
        double Area = L * L;
        double Perimetro = L*4;
        System.out.println("\nEl area del cuadrado es: " + Area);
        System.out.println("El perimetro del cuadrado es: " + Perimetro);
        }catch (Exception e){
            System.out.println("debes ingresar un numero valido para el lado");
            entrada.nextLine();
        }
    }
    public void CalcularTriangulo(){
        try{
        System.out.println("\nintroduce la base del triangulo");
        float b = entrada.nextFloat();
        System.out.println("\nintroduce la altura");
        float h = entrada.nextFloat();
        if (b <= 0 ||h <= 0){
            System.out.println("la base y la altura deben ser mayores a 0");
            return;
        }
        double Area = (b*h)/2;
        double Perimetro = b + b + b;
        System.out.println("\nEl area del triangulo es: " + Area);
        System.out.println("El perimetro del triangulo es: " + Perimetro);
        }catch (Exception e){
            System.out.println("debes ingresar numeros validos");
            entrada.nextLine();
        }
    }
    public void CalcularTrapecio(){
        try{
        System.out.println("\ningresa base mayor");
        float BaMa = entrada.nextFloat();
        System.out.println("\ningresa base menor");
        float Bame = entrada.nextFloat();
        System.out.println("\ningreasa la altura");
        float h = entrada.nextFloat();
        System.out.println("\ningresa el lado");
        float lado = entrada.nextFloat();
        if (BaMa <= 0 || Bame <= 0 || h <= 0 || lado <=0) {
            System.out.println("todos los valores deben ser mayores a 0");
            return;
        }
        if (BaMa < Bame){
            System.out.println("la base mayor debe ser mayor que la base menor");
            return;
        }
        double Area = ((BaMa + Bame)*h)/2;
        double Perimetro = BaMa + Bame + (2*lado);
        System.out.println("\nEl area del trapecio es: " + Area);
        System.out.println("El perimetro del trapecio es: " + Perimetro);
        }catch (Exception e){
            System.out.println("debes ingresar numero validos");
            entrada.nextLine();
        }
    }
    public void CalcularRombo(){
        try{
        System.out.println("\ningresa la diagonal mayor");
        float DiMa = entrada.nextFloat();
        System.out.println("\ningresa la diagonal menor");
        float Dime = entrada.nextFloat();
        System.out.println("\ningresa un lado");
        Float lado = entrada.nextFloat();
        if (DiMa <= 0 || Dime <= 0 || lado <= 0) {
            System.out.println("todos los valores deben ser mayores que 0");
            return;
        }
        double Area = (DiMa * Dime)/2;
        double Perimetro = 4 * lado;
        System.out.println("\nEl area del rombo es: " + Area);
        System.out.println("El perimetro del rombo es: " + Perimetro);
        }catch(Exception e){
            System.out.println("error debes ingresar numeros validos");
            entrada.nextLine();
        }
    }
}
