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
-Porcelanato  $22.35 m²
-Marmoleado  $34.27 m²
-Acrílico  $22.94 m²

3.Cálculo de compra
-Pedir número de cuartos (entre 2 y 4)
-Pedir largo y ancho de cada cuarto
-Elegir tipo de piso
-Calcular costo por cuarto
-Mostrar total general + datos del cliente

Extra:
-Aplicar IVA 16%
-Preguntar si compra:
-Si sí  aplicar descuento 7.95%
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
        String direccionResidencial = "";

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

            int opcion;
            //pa que chequie chido si no lo regrese por donde vino
            try {
                opcion = Integer.parseInt(datosos.nextLine().trim());
            } catch (Exception e){
                System.out.println("Error: debe ingresar un numero entero. Intenta de nuez");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\nOpcion 1: Ingresando datos del comparador");
                    
                    System.out.print("Nombre: ");
                    nombre = datosos.nextLine().trim();
                    
                    System.out.println("Apellido Paterno: ");
                    apellidoPaterno= datosos.nextLine().trim();

                    System.out.println("Apellido Materno: ");
                    apellidoMaterno = datosos.nextLine().trim();

                    System.out.println("Fecha de nacimiento (DD/MM/AAAA): ");
                    fechaNacimiento = datosos.nextLine().trim();

                    System.out.println("Direccion residencial: ");
                    direccionResidencial = datosos.nextLine().trim();

                    System.out.println("DATOS GUARDADOS CORRECTAMENTE :)");
                    break;
                
                case 2:
                    System.out.println("\n||=============================================||");
                    System.out.println("||Opcion 2 Tipos de pisos disponibles          ||");
                    System.err.println("||=============================================||");
                    System.out.println("||1-Porcelanato---------22.35 el metro cuadrado||");
                    System.out.println("||2-Acrilico------------22.94 l metro cuandrado||");
                    System.out.println("||3-Marmoleado----------34.27 eL metro cuadeado||");
                    System.out.println("||=============================================||");
                    break;
                
                case 3:
                    System.out.println("\n Opcion 3: Calculo del costo");

                    //vamos a ver si ya ecistian datos del comprador
                    if (nombre.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty()) {
                        System.out.println("Esto no se puede hcaer: Primero ingrese los datos del comprador en la opcion 1");
                        break;
                    }
                    //validar numero de cuartos (2, 3 o 4)
                    int numCuartos;
                    while (true){
                        System.out.println("¿Cuantos cuartos tiene el inmueble? (maypr a 1 y menor de 5): ");
                        try{
                            numCuartos = Integer.parseInt(datosos.nextLine().trim());
                            if (numCuartos >= 2 && numCuartos <= 4) {
                                break;
                            } else {
                                System.out.println("Esto no se puede hacer: Debe ser un numero mayor a 1 y menor de 5. Pon otro valor.");
                            }     
                        } catch (Exception e){
                            System.out.println("ERROR: Debe ser un numero entero. pon otro valor.");
                        }
                    }
                    //arrays pa almacenar la info asi de cada cuarto
                    double[] largos = new double [numCuartos + 1];
                    double[] anchos = new double [numCuartos + 1];
                    String[] tipoStrings = new String [numCuartos + 1];
                    double[] costosPorCuarto = new double [numCuartos + 1];
                    double[] areas = new double [numCuartos + 1];

                    double totalBase = 0.0;
                    //procesar cada cuarto
                    for(int i = 1; i <= numCuartos; i++){
                        System.out.println("\n---cuarto" + i + "---");
                        
                        //largo
                        double largo;
                        while (true) {
                            System.out.println("lago del cuarto" + i + " (metros): ");
                            try {
                                largo = Double.parseDouble(datosos.nextLine().trim());
                                if (largo > 0) {
                                    break;
                                } else {
                                    System.out.println("Esto no se puede hacer: El largo debe ser mayor a 0. Pon otro valor.");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR: Debe ingresar un numero valido. pon otro valor.");
                            }
                        }

                        //ancho
                        double ancho;
                        while (true) {
                            System.out.println("ancho del cuarto " + i + " (metros): ");
                            try {
                                ancho = Double.parseDouble(datosos.nextLine().trim());
                                if (ancho > 0) {
                                    break;
                                } else {
                                    System.out.println("Esto no se puede hacer: El ancho debe ser mayor a 0 pon otro valor");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR: Debe ingresar un numero valido. Pon otro valor.");
                            }
                        }

                        //tipo de piso
                        int tipo;
                        while (true) {
                            System.out.println("tipo de piso (1 = porcelanato, 2 = marmoleado, 3 = Acrilico): ");
                            try {
                                tipo = Integer.parseInt(datosos.nextLine().trim());
                                if (tipo >= 1 && tipo <= 3) {
                                    break;
                                } else {
                                    System.out.println("Esto no se puede hacer: opcion invalida es solo del 1 al 3 pon otro");
                                }
                            } catch (Exception e) {
                                System.out.println("ERROR Debe ingreasr un numero entero del 1 al 3 pon otro valor");
                            }
                        }

                        double area = largo * ancho;
                        double precioM2 = 0;
                        String nombreTipo = "";
                        switch (tipo) {
                            case 1:
                                precioM2 = 22.35;
                                nombreTipo = "Porcelanato";
                                break;
                        
                            case 2:
                                precioM2 = 34.27;
                                nombreTipo = "Marmoleado";
                                break;
                        
                            case 3:
                                precioM2 = 22.94;
                                nombreTipo = "Acrilico";
                                break;
                        }
                        double costo = area * precioM2;

                        //guardar datos para imprimir al final ya me quiero ir a dormir
                        largos[i] = largo;
                        anchos[1] = ancho;
                        areas[i] = area;
                        tipoStrings[i] = nombreTipo;
                        costosPorCuarto[i] = costo;
                        totalBase += costo;
                    }
                    //ya lo final datos del comprador y precios
                    System.out.println("\n||================================================================||");
                    System.out.println("||                   DATOS COMPLETOS DEL COMPRADOR                ||");
                    System.out.println("||================================================================||");
                    System.out.println("||Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
                    System.out.println("||Fecha de nacimiento: " + fechaNacimiento);
                    System.out.println("||Dirección: " + direccionResidencial);
                    System.out.println("||================================================================||");
                    System.out.println("||                         COSTO POR CUARTO                       ||");
                    System.out.println("||================================================================||");

                    for(int i = 1; i <= numCuartos; i++){
                        System.out.println("cuarto " + i + ": " + tipoStrings[i]);
                        System.out.printf("medidas: %.2f m x %.2f m => Area: %.2f m\u00B2%n", largos[i], anchos[i], areas[i]);
                        System.out.printf("costo sin IVA: $%.2f%n", costosPorCuarto[i]);
                    }
                    System.out.printf("%nTOTAL GENERAL SIN IVA: $%.2f%n", totalBase);

                    //IVA 16%
                    double iva = totalBase * 0.16;
                    double totalConIva = totalBase + iva;
                    System.out.printf("Iva (16%%): $%.2f%n", iva);
                    System.out.printf("TOTAL CON IVA: $%.2f%n", totalConIva);

                    // Preguntar si desea realizar la compra
                    while (true) {
                        System.out.print("\n¿Desea realizar la compra? (si/no): ");
                        String respuesta = datosos.nextLine().trim().toLowerCase();
                        if (respuesta.equals("si") || respuesta.equals("sí") || respuesta.equals("s") ||
                            respuesta.equals("yes") || respuesta.equals("y")) {
                            double descuento = totalConIva * 0.0795;
                            double totalFinal = totalConIva - descuento;
                            System.out.println("\n¡COMPRA REALIZADA EXITOSAMENTE!");
                            System.out.printf("Descuento aplicado (7.95%% sobre el total): $%.2f%n", descuento);
                            System.out.printf("TOTAL FINAL A PAGAR: $%.2f%n", totalFinal);
                            break;
                        } else if (respuesta.equals("no") || respuesta.equals("n")) {
                            System.out.println("\nNo se realizó la compra.");
                            break;
                        } else {
                            System.out.println("Respuesta inválida. Escriba 'si' o 'no'.");
                        }
                    }
                    break;

                    case 4:
                        System.out.println("\n¡Gracias por usar el programa! Saliendo...");
                        datosos.close();
                        return;
            
                default:
                    System.out.println("Opción inválida. Solo se permiten las opciones 1, 2, 3 o 4");
                    break;
            }
        }
    }
}
