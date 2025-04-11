/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exp2_s4_francisca_valenzuela.java;

import java.util.Scanner;

/**
 *
 * @author IVI
 */
public class Exp2_S4_Francisca_ValenzuelaJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String[][] asientos = {
                { "A1", "A2", "A3", "A4" },
                { "B1", "B2", "B3", "B4" },
                { "C1", "C2", "C3", "C4" }
        };
        boolean continuar = true;

        // Menú principal con ciclo for
        for (; continuar;) {
            System.out.println("");
            System.out.println("===================================");
            System.out.println("    BIENVENIDO AL TEATRO MORO");
            System.out.println("===================================");
            System.out.println("Menu:");
            System.out.println("1. Comprar entrada");
            System.out.println("2. Salir");
            System.out.println("-----------------------------------");
            System.out.print("Elija una opción: ");

            int opcion = 0;
            boolean opcionValida = false;

            // Validación para la opción del menú
            while (!opcionValida) {
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion == 1 || opcion == 2) {
                        opcionValida = true;
                    } else {
                        System.out.println("Opción inválida. Por favor, ingrese 1 o 2.");
                        System.out.print("Elija una opción: ");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número (1 o 2).");
                    System.out.print("Elija una opción: ");
                    scanner.next(); 
                }
                scanner.nextLine(); 
            }

            //Opción 1: Comprar entrada
            if (opcion == 1) {
                // Mostrar plano de asientos y precios por zona
                System.out.println("");
                System.out.println("===================================");
                System.out.println("        PLANO DEL TEATRO");
                System.out.println("===================================");
                System.out.println("| Zona A | Zona B | Zona C |");
                System.out.println("| $5000  | $4000  | $3000  |");
                System.out.println("===================================");
                
                for (int i = 0; i < asientos.length; i++) {
                    
                    char zonaChar = (char) ('A' + i);
                    System.out.print("Zona " + zonaChar + ": ");
                    for (int j = 0; j < asientos[i].length; j++) {
                        if (asientos[i][j] != null) {
                            System.out.print("[" + asientos[i][j] + "] ");
                        } else {
                            System.out.print("[XX] "); 
                        }
                    }
                    System.out.println(""); 
                }
                 System.out.println("-----------------------------------");


                // Variables para la compra actual
                boolean asientoComprado = false;
                String zonaElegida = "";
                double precioBase = 0; 
                int zonaIndice = -1;   

                
                while (!asientoComprado) {

                    // Pedir y validar zona
                    if (zonaElegida.isEmpty()) {
                        System.out.print("Ingrese la zona (A, B, C): ");
                        zonaElegida = scanner.nextLine().toUpperCase();

                        // Asignar índice y PRECIO BASE 
                        if (zonaElegida.equals("A")) {
                            zonaIndice = 0;
                            precioBase = 5000;
                        } else if (zonaElegida.equals("B")) {
                            zonaIndice = 1;
                            precioBase = 4000; 
                        } else if (zonaElegida.equals("C")) {
                            zonaIndice = 2;
                            precioBase = 3000; 
                        } else {
                            System.out.println("Zona inválida. Intente nuevamente.");
                            zonaElegida = ""; 
                            zonaIndice = -1;  
                            continue;
                        }
                    }

                    //Pedir y validar asiento 
                    System.out.print("Ingrese el número de asiento (1-4) para la Zona " + zonaElegida + ": ");
                    int numAsiento = 0;
                    boolean asientoNumValido = false;

                    // Validación para número de asiento
                    while(!asientoNumValido){
                        if (scanner.hasNextInt()) {
                            numAsiento = scanner.nextInt();
                             if (numAsiento >= 1 && numAsiento <= 4) {
                                asientoNumValido = true;
                             } else {
                                 System.out.println("Número de asiento inválido. Debe ser entre 1 y 4.");
                                 System.out.print("Ingrese el número de asiento (1-4) para la Zona " + zonaElegida + ": ");
                             }
                        } else {
                             System.out.println("Entrada inválida. Por favor, ingrese un número.");
                             System.out.print("Ingrese el número de asiento (1-4) para la Zona " + zonaElegida + ": ");
                             scanner.next();
                        }
                        scanner.nextLine(); 
                    }


                    // Verificar disponibilidad del asiento
                    if (asientos[zonaIndice][numAsiento - 1] != null) {
                        String asiento = asientos[zonaIndice][numAsiento - 1];
                        asientos[zonaIndice][numAsiento - 1] = null;
                        asientoComprado = true;

                         System.out.println("-----------------------------------");
                         System.out.println("Asiento " + asiento + " seleccionado.");
                         System.out.println("-----------------------------------");

                        // Solicitar y validar edad 
                        System.out.print("Ingrese su edad: ");
                        int edad = 0;
                        boolean edadValida = false;
                        while (!edadValida) {
                            if (scanner.hasNextInt()) {
                                edad = scanner.nextInt();
                                if (edad >= 0 && edad <= 110) { 
                                    edadValida = true;
                                } else {
                                    System.out.println("Edad inválida. Por favor, ingrese una edad realista (0-110).");
                                    System.out.print("Ingrese su edad: ");
                                }
                            } else {
                                System.out.println("Entrada inválida. Por favor, ingrese su edad como un número.");
                                System.out.print("Ingrese su edad: ");
                                scanner.next();
                            }
                            scanner.nextLine(); 
                        }

                        //Calcular descuento
                        double descuento = 0.0;
                        String tipoDescuento = "Ninguno";
                        if (edad <= 18) {
                            descuento = 0.10; // 10%
                            tipoDescuento = "Estudiante (10%)";
                        } else if (edad >= 60) { 
                            descuento = 0.15; // 15%
                            tipoDescuento = "Tercera Edad (15%)";
                        }

                        // --- Calcular Precio Final ---
                        double precioFinal = precioBase - (precioBase * descuento);

                        // Mostrar Resumen de la Compra
                        System.out.println("\n===================================");
                        System.out.println("    RESUMEN DE SU COMPRA");
                        System.out.println("===================================");
                        System.out.println("Ubicación del asiento: " + asiento);
                        System.out.printf("Precio base:         $%.0f\n", precioBase); 
                        System.out.println("Descuento aplicado:  " + tipoDescuento);
                        System.out.printf("Precio final a pagar:$%.0f\n", precioFinal); 
                        System.out.println("===================================");


                        //Preguntar si desea realizar otra compra
                        boolean otraCompraValida = false;
                        while (!otraCompraValida) {
                            System.out.print("¿Desea realizar otra compra? (si/no): ");
                            String respuesta = scanner.nextLine().toLowerCase();
                            if (respuesta.equals("no")) {
                                continuar = false; 
                                otraCompraValida = true;
                                System.out.println("===================================");
                                System.out.println("Gracias por utilizar nuestro sistema.");
                            } else if (respuesta.equals("si")) {
                                otraCompraValida = true;
                                } else {
                                System.out.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
                            }
                        }

                    } else { 
                        System.out.println("-----------------------------------");
                        System.out.println("El asiento " + zonaElegida + (numAsiento) + " ya está ocupado. Intente nuevamente.");
                        System.out.println("-----------------------------------");
                        
                        
                    }
                }

            //  Opción 2: Salir
            } else if (opcion == 2) {
                
                System.out.println("\nSaliendo del sistema. ¡Gracias por visitarnos!");
                continuar = false; 

            }
            

        } 

        scanner.close(); 
        System.out.println("\nGracias por su compra, disfrute la función.");
    } 
}