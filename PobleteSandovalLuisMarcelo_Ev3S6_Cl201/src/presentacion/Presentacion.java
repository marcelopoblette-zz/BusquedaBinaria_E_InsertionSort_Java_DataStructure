/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.JOptionPane;
import java.util.Scanner;

/**
 *
 * @author Luis Marcelo Poblete Sandoval.
 */
public class Presentacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0; //inicialización de variables
// información descriptiva del programa
        JOptionPane.showMessageDialog(null, ""
                + "Programa que realiza una Búsqueda de los Días de la Semana con un Método de Búsqueda Binaria y Recursiva.\n"
                + "========================================================================================\n"
                + "- El almacenamiento de los Días de la Semana se ha hecho con una estructura de arreglo de tipo String.\n"
                + "- El Ordenamiento se realiza antes de la búsqueda con un Método Insertion-Sort.\n"
                + "- La Búsqueda se realiza de manera Binaria y Recursiva en el arreglo de tipo String, "
                + "previamente ordenado.\n\n", "Información del Programa", JOptionPane.QUESTION_MESSAGE);
//        creacion de arreglo con los dias de la semana, inicialización y asignación del arreglo.
        String[] diasStr = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", "DOMINGO"};

        do {//ciclo que contiene el menu
            try { //Estructura try catch que contiene 

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "" //solicitud de datos al usuario para comparar arreglo 
                        + "1. Imprimir los días de la semana en su posición original, sin ordenar.\n"
                        + "2. Imprimir los días de la semana ordenados Alfabéticamente por el Método Insertion-Sort.\n"
                        + "3. Imprimir el proceso de Ordenamiento del Método Insertion-Sort.\n"
                        + "   (Ver detalle completo del proceso de de Ordenamiento en la consola).\n"
                        + "4. Buscar un día de la semana de con el Método de Búsqueda Binaria y Recursiva\n"
                        + "   en el arreglo de tipo String , previamente ordenado alfabéticamente.\n"
                        + "5. Salir. \n\n"
                        + "Ingrese una opción:\n"
                        + "", "Menú de Opciones - Busqueda Binaria Recursiva.", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1:
                        System.out.println("\n\n\n\n");
                        Negocio.reordenarDias(diasStr);
                        System.out.println("   Los Días de la Semana Sin Ordenar Alfabéticamente Son: ");//título que explica función del programa.
                        System.out.println("========================================================================================");
                        Negocio.imprimirArreglo(diasStr);// metodo que imprime arreglo
                        System.out.println("========================================================================================");
                        break;
                    case 2:
                        System.out.println("\n\n\n\n");
                        Negocio.reordenarDias(diasStr);
                        System.out.println("Los Días de la Semana ordenados Alfabéticamente quedan así: ");
                        System.out.println("========================================================================================");
                        String[] dia = {" "};
                        dia = Negocio.ordenadorporInsercion2(diasStr);
                        Negocio.imprimirArreglo(dia);//se imprimen los valores ordenados del arreglo
                        System.out.println("========================================================================================");
                        break;
                    case 3:
                        System.out.println("\n\n\n\n");
                        Negocio.reordenarDias(diasStr);
                        System.out.println("   Los Días de la Semana Sin Ordenar Alfabéticamente Son: ");//título que explica función del programa.
                        System.out.println("========================================================================================");
                        Negocio.imprimirArreglo(diasStr);// metodo que imprime arreglo
                        System.out.println("\nA continuación se imprime el proceso de ordenamiento Insertion Sort: ");
                        System.out.println("========================================================================================");
//                        se asigna valor retornado por método que ordena arreglo con estructura isertion-sort
                        dia = Negocio.ordenadorporInsercion(diasStr);
                        System.out.println("========================================================================================\n"
                                + "                   Ordenamiento Resultante.\n"
                                + "========================================================================================\n");
                        Negocio.imprimirArreglo(dia);//se imprimen los valores ordenados del arreglo
                        System.out.println("========================================================================================");
                        break;

                    case 4:
                        System.out.println("\n\n\n\n");
                        Negocio.reordenarDias(diasStr);
                        System.out.println("A continuación se imprime el proceso de la Búsqueda Binaria Recursiva: ");
                        dia = Negocio.ordenadorporInsercion2(diasStr);//se llama metodo que ordena el arreglo
//                        se solicita dato al usuario para hacer las comparaciones en el metodo de busqueda binaria recursiva
                        String busqueda = JOptionPane.showInputDialog(null, ""
                                + "Ingrese el Nombre del Días de la Semana que desea encontrar.", "Ejecutando Busqueda Binaria Recursiva.",
                                JOptionPane.INFORMATION_MESSAGE);
//                        se llama al metodo de busqueda binaria recursiva para hacer la comparación, retorna el indice del arreglo
                        int indice = Negocio.busquedaBinariaRecursiva(dia, busqueda.toUpperCase(), 0, diasStr.length - 1);
                        if ((indice < 0)) {//se valida que el indice retornado pertenezca a unindice válido (es decir no sea -1)
                            JOptionPane.showMessageDialog(null, ""//mensaje al usuario que ha ingresado un dato inválido
                                    + "El Valor de Búsqueda Ingresado:\n"
                                    + "                     [ " + busqueda + " ]\n"
                                    + "No Corresponde a un nombre de un Día de la Semana, o está mal escrito.\n"
                                    + "\n\n(Ver detalle completo del proceso de Busqueda Binaria recursiva en la consola).", "Valor No Encontrado.",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
//                            mensaje en caso de que el ingreaso haya sido valido se devuelven los parámetros validados desde el método
                            JOptionPane.showMessageDialog(null, ""
                                    + "- El Método Insertion-Sort ha ordenado alfabéticamente el arreglo tipo String.\n\n"
                                    + "El Valor Ingresado ha sido encontrado por el método de Búsqueda Binaria y Recursiva!\n\n"
                                    + "El valor correspondiente al día " + dia[indice] + ", "// se entrega el dia buscado / dia[indice]"
                                    + "se encuentra en la pocisión N° [ " + (indice + 1) + " ].\n"
                                    + "De acuerdo a su orden alfabético.\n" // y el indice
                                    + "\n\n(Ver detalle completo del proceso de Busqueda Binaria recursiva en la consola).", "         Valor Encontrado.",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        // } while (boolIterador);//condición establecida en false para continuar el programa si los datos ingresados pasan las validaciones. 
                        break;

                    case 5:
//                        mensaje de despedida al elegir salir del programa en el menú de opciones.
                        JOptionPane.showMessageDialog(null, "Gracias por su evaluación!",
                                "Programa Finalizado.", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("\n");
                        break;

                    default:
//                         se imprime mensaje por pantalla en caso de que la opción ingresada este fuera de las ofrecidas en el menú.
                        JOptionPane.showMessageDialog(null, "La opción ingresada no es válida.",
                                "Opcion Incorrecta.", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            } catch (NumberFormatException n) {
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage()); //se captura el error y se muestra por pantalla.

            }

        } while (opcion != 5);

    }

}
