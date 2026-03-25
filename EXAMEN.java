/*
INSTRUCCIONES
Objetivo:

Hacer un programa que calcule el costo de instalar piso.

Menú con 3 opciones:

1.Datos del cliente
Pedir:
-Nombre
-Apellido paterno
-Apellido materno
-Fecha de nacimiento
-Dirección

2.Mostrar tipos de piso
-Porcelanato → $22.35 m²
-Marmoleado → $34.27 m²
-Acrílico → $22.94 m²

3.Cálculo de compra
-Pedir número de cuartos (entre 2 y 4)
-Pedir largo y ancho de cada cuarto
-Elegir tipo de piso
-Calcular costo por cuarto
-Mostrar total general + datos del cliente

Extra:
-Aplicar IVA 16%
-Preguntar si compra:
-Si sí → aplicar descuento 7.95%
*/
import java.util.Scanner;

public class EXAMEN {
    public static void main(String[] args){
        Scanner datosos = new Scanner(System.in);

        //datop del comprador son los que se mantienen en la ejecucion
        String nombre = "";
        String apellidoPaterno = "";
        String apellidoMaterno = "";
        String fechaNacimiento = "";
        String direccion = "";

        System.out.println("=== Programa pa calculo de costo de un piso ===");
        
        //aqui sigue el menu

        while (true) {
            System.out.println("\n\n||====================================||");
            System.out.println("||            MENU PRINCIPAL          ||");
            System.out.println("||====================================||");
            System.out.println("||1-Ingresar datos del cliente        ||");
            System.out.println("||2-tipos de piso que se venden       ||");
            System.out.println("||3-Calcular costo de la compra       ||");
            System.out.println("||4-Salir                             ||");
            System.err.println("||====================================||");

        }
    }
}
