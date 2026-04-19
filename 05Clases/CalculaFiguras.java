import java.util.Scanner;

public class CalculaFiguras{
    //no se si se pueda meter aqui lo del escanner pero como no quiero copiar voy a usar el cerebro
    Scanner entrada = new Scanner(System.in)
    public void menu(){
        //vamos a colocar 5 figuras en el menu y va a ser de ahi un chuich
        //triangulo, cuadrado, trapecio, circulo, rombo
        System.out.println("\nIngresa la opcion que deseas usar");
        System.out.println("\n||================================||");
        System.out.println("||1.-Circulo                      ||");
        System.out.println("||2.-cuadrado                     ||");
        System.out.println("||3.-Triangulo                    ||");
        System.out.println("||4.-Trapecio                     ||");
        System.out.println("||5.-Rombo                        ||");
        System.out.println("||================================||");
        System.out.println("\nopcion: ");
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
                opcionMenu = entrada.nextInt();
                break;
        }
    }
    //si funciono na la mera verdura del caldo
    //es mas profe yo doy la clase, nah mentira
    public void CalcularCirculo(){
        float radio = 0;
        float diametro = radio * 2;
        System.out.println("introduce el radio del circulo");
        radio = entrada.nextFloat();
        Area = Math.PI * radio
    }
}
