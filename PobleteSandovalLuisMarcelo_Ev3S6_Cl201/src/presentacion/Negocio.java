/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.io.IOException;

/**
 *
 * @author Luis Marcelo Poblete Sandoval.
 */
public class Negocio {
//    Método de ordenamiento del tipo sort-Insertion

    public static String[] ordenadorporInsercion(String[] arreglo) { //se le entrega el arreglo a ordenar por par+ametro
        int contadorComaparaciones = 0, contadorIntercambios = 0;
        for (int saliente = 0; saliente < arreglo.length; saliente++) {//se recorre el arreglo y se divide

            System.out.println("Posicion Inicial° : " + (saliente + 1));
            String temporal = arreglo[saliente]; //se asigna el indice y se remueve el item marcado
            System.out.println("Día que entra: " + temporal);
            int in;//se crea variable auxiliar para hacer la comparacion desde la variable desde la posicion marcada
            for (in = saliente - 1; in >= 0 && temporal.compareToIgnoreCase(arreglo[in]) <= 0; in--) {//se realiza la comparación hasta que uno sea de menor valor
                contadorComaparaciones++;
                System.out.println("\nCiclo Comparativo N°: " + contadorComaparaciones);
                System.out.println("Pocision de Quiebre " + (in + 2) + ", se encuentra valor menor al anterior: ");
                System.out.println("Día que sale de la pocisión de Quiebre: " + temporal);
                arreglo[in + 1] = arreglo[in];//cuando terminan las comparaciones  se asigna el valor del auxiliar en el orden que le corresponde y se corre a la derecha
                contadorIntercambios++;
                System.out.println("\nCiclo Intercambio N°: " + contadorIntercambios);
                System.out.println("Nuevo Día asignado a la pocición de Quiebre: " + arreglo[in + 1]);

                System.out.println("========================================================================================");

            }

            arreglo[in + 1] = temporal;//el valor original es reemplazado por el nuevo valor en su posición, hasta que acaban las comparaciones
        }
        System.out.println("Total Comparaciones: " + contadorComaparaciones);
        System.out.println("Total Intercambios: " + contadorIntercambios);

        return arreglo; //se retorna el arreglo ordenado

    }

    public static String[] ordenadorporInsercion2(String[] arreglo) { //se le entrega el arreglo a ordenar por par+ametro
        for (int saliente = 0; saliente < arreglo.length; saliente++) {//se recorre el arreglo y se divide
            String temporal = arreglo[saliente]; //se asigna el indice y se remueve el item marcado
            int in;//se crea variable auxiliar para hacer la comparacion desde la variable desde la posicion marcada
            for (in = saliente - 1; in >= 0 && temporal.compareTo(arreglo[in]) <= 0; in--) {//se realiza la comparación hasta que uno sea de menor valor
                arreglo[in + 1] = arreglo[in];//cuando terminan las comparaciones  se asigna el valor del auxiliar en el orden que le corresponde y se corre a la derecha
            }

            arreglo[in + 1] = temporal;//el valor original es reemplazado por el nuevo valor en su posición, hasta que acaban las comparaciones
        }
        return arreglo; //se retorna el arreglo ordenado
    }

    public static void imprimirArreglo(String arreglo[]) { //se entrega un arreglo por parametro 
        for (int i = 0; i < arreglo.length; i++) {// se recorre el arreglo
            System.out.println("                     " + (i + 1) + " " + arreglo[i]); //por cada ciclo se imprimen el indice y el Día
        }
    }

    public static int busquedaBinariaRecursiva(String[] arreglo, String busqueda, int izquierda, int derecha) {

        System.out.println("========================================================================================\n"
                + "En este cliclo:\n"
                + "Los valores que entran a la Búsqueda Binaria Recursiva son : \n"
                + "1.- El Arreglo con los Días de la Semana Ordenados Alfabeticamente: \n"
                + "2.- Valor Buscado, que es: " + busqueda + ".\n"
                + "3.- La Posición Inicial de la Búsqueda, que en este ciclo es: " + (izquierda + 1) + ".\n"
                + "4.- Posición Final de la Búsqueda, que en este ciclo es: " + (derecha + 1) + ".\n"
                + "========================================================================================");
        // Si izquierda es mayor que derecha significa que no encontramos nada
        if (izquierda > derecha) {
            System.out.println("========================================================================================\n"
                    + "\nCuando el valor ingresado no se ha encuentrado en el arreglo.\n"
                    + "Se valida si la Posición Inicial es mayor a la Posición Final: \n"
                    + "Como en este caso.\n"
                    + "La Posición Inicial de la Búsqueda [" + (izquierda + 1) + "]"
                    + " es mayor que la Posición Final de la Búsqueda [" + (derecha + 1) + "].\n"
                    + "Se cumple la condición establecida y el programa sale del Ciclo Recursivo y retorna -1.\n"
                    + "Se le indica al usuario por pantalla que el valor ingresado no fue encontrado.\n"
                    + "========================================================================================\n\n");
            return -1;
        }
//          Calculamos las mitades...

        System.out.println("Luego: \n"
                + "Se identifica la posición del centro y el valor que contiene.");
        int indiceDelElementoDelMedio = (int) Math.floor((izquierda + derecha) / 2);
        String elementoDelMedio = arreglo[indiceDelElementoDelMedio];
        System.out.println("LA POSICIÓN DEL CENTRO EN ESTE CICLO ES: " + (indiceDelElementoDelMedio + 1) + ""
                + " Y CONTIENE EL DÍA: " + elementoDelMedio + ".\n"
                + "Se compara si el valor encontrado en el centro es igual al buscado.\n"
                + "Sino lo es.\nSeguimos recorriendo el arreglo. ");

//        Primero vamos a comparar y luego vamos a ver si el resultado es negativo, positivo ó 0
        int resultadoDeLaComparacion = busqueda.compareTo(elementoDelMedio);

//        Si el resultado de la comparación es 0, significa que hemos encontrado la búsqueda
        if (resultadoDeLaComparacion == 0) {
            System.out.println("========================================================================================\n"
                    + "========================================================================================\n"
                    + "Cuando la posición del centro contiene el valor buscado: \n"
                    + "El Programa retorna:\n"
                    + "1.- La posición del arreglo, que en este caso, es : " + (indiceDelElementoDelMedio + 1) + "\n"
                    + "2.- El valor que contiene, que en este caso, es : " + elementoDelMedio + "\n"
                    + "Se le indica al usuario por pantalla que el valor ingresado fue encontrado.\n"
                    + "========================================================================================\n\n");
            return indiceDelElementoDelMedio;
        }

//        Si no, entonces vemos si está a la izquierda o derecha
        if (resultadoDeLaComparacion < 0) {
            derecha = indiceDelElementoDelMedio - 1;

            return busquedaBinariaRecursiva(arreglo, busqueda, izquierda, derecha);
        } else {
            izquierda = indiceDelElementoDelMedio + 1;
            return busquedaBinariaRecursiva(arreglo, busqueda, izquierda, derecha);
//            se devuelven los valores al ciclo recursivo hasta que se se cumple la igualdad y se confirma la busqueda
        }
    }

    public static void limpiar(int lineas) {
        for (int i = 0; i < lineas; i++) {
            System.out.println();
        }
    }

    public static String[] reordenarDias(String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            String[] dias = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", "DOMINGO"};
            arreglo[i] = dias[i];
        }
        return arreglo;
    }
}
