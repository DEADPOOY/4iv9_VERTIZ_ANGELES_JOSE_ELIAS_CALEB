import java.util.Scanner;

public class CalculaFiguras{
    //wuachese profe el mejor codigo de mi vida ahora evite el copiar wazza👻👻
    Scanner entrada = new Scanner(System.in);
    public void menu(){
        //vamos a colocar 5 figuras en el menu y va a ser de ahi un chuich
        //triangulo, cuadrado, trapecio, circulo, rombo
        System.out.println("\nIngresa la opcion que deseas usar");
        System.out.println("||================================||");
        System.out.println("||1.-Circulo                      ||");
        System.out.println("||2.-cuadrado                     ||");
        System.out.println("||3.-Triangulo                    ||");
        System.out.println("||4.-Trapecio                     ||");
        System.out.println("||5.-Rombo                        ||");
        System.out.println("||================================||");
        System.out.println("\n");
        int opcionMenu = 0;
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
            default:
                System.out.println("opcion invalida intenta de nuevo");
                break;
        }
    }
    //si funciono na la mera verdura del caldo
    //es mas profe yo doy la clase 👻👻, nah mentira
    public void CalcularCirculo(){
        System.out.println("\nintroduce el radio del circulo");
        float radio = entrada.nextFloat();
        double diametro = radio*2;
        double Area = Math.PI * radio * radio;//no supe como meter el cuadrado xd
        double Perimetro = Math.PI * diametro;
        System.out.println("\nEl area del circulo es de: " + Area);
        System.out.println("El perimetro del circulo es: " + Perimetro);
    }
    public void CalcularCuadrado(){
        System.out.println("\nintroduce el lado del cuadrado");
        float lado = entrada.nextFloat();
        double Area = lado * lado;
        double Perimetro = lado*4;
        System.out.println("\nEl area del cuadrado es: " + Area);
        System.out.println("El perimetro del cuadrado es: " + Perimetro);
    }
    public void CalcularTriangulo(){
        System.out.println("\nintroduce la base del triangulo");
        float base = entrada.nextFloat();
        System.out.println("\nintroduce la altura");
        float altura = entrada.nextFloat();
        double Area = (base*altura)/2;
        double Perimetro = base + base + base;
        System.out.println("\nEl area del triangulo es: " + Area);
        System.out.println("El perimetro del triangulo es: " + Perimetro);
    }
    public void CalcularTrapecio(){
        System.out.println("\ningresa base mayor");
        float BaseM = entrada.nextFloat();
        System.out.println("\ningresa base menor");
        float Basem = entrada.nextFloat();
        System.out.println("\ningreasa la altura");
        float altura = entrada.nextFloat();
        System.out.println("\ningresa el lado");
        float lado = entrada.nextFloat();
        double Area = ((BaseM + Basem)*altura)/2;
        double Perimetro = BaseM + Basem + (2*lado);
        System.out.println("\nEl area del trapecio es: " + Area);
        System.out.println("El area del trapecio es: " + Perimetro);
    }
    public void CalcularRombo(){
        System.out.println("\ningresa la diagonal mayor");
        float DiagonalM = entrada.nextFloat();
        System.out.println("\ningresa la diagonal menor");
        float Diagonalm = entrada.nextFloat();
        System.out.println("\ningresa un lado");
        Float lado = entrada.nextFloat();
        double Area = (DiagonalM * Diagonalm)/2;
        double Perimetro = 4 * lado;
        System.out.println("\nEl area del rombo es: " + Area);
        System.out.println("El perimetro del rombo es: " + Perimetro);
        return;
    }
}
