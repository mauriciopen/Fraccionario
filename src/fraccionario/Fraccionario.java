/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fraccionario;

import java.util.Scanner;

public class Fraccionario {

    public static void main(String[] args) {
        int numerador;
        int denominador = 1;
        boolean rep = false;
        boolean error = false;
        int opc;
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("Simplificacion de fraccionarios");
            System.out.println("----------------------------------------------------");
            System.out.println("Ingrese el numerador:");

            numerador = reader.nextInt();
            do {
                System.out.println("Ingrese el denominador");
                denominador = reader.nextInt();
                if (denominador == 0) {
                    System.out.println("Division entre 0!");
                }

            } while (denominador == 0);/*Asegura que no haya division entre cero*/

            int mayor = 0;
            if (numerador < denominador) {
                /*se busca el mayor entre el numerador y el denominador*/
                mayor = denominador;
            } else {
                mayor = numerador;
            }

            for (int i = 2; i < mayor; i++) {/*Se itera desde 2 al mayor*/
                if (numerador % i == 0 && denominador % i == 0) {/*si el numerador y el denominador son divisibles*/
                    while (numerador % i == 0 && denominador % i == 0) {/*mientras sea divisible ambos se dividen entre i*/
                        numerador = numerador / i;
                        denominador = denominador / i;
                    }
                }

            }
            System.out.println("Su fraccion simplificada\n");

            if (denominador == 1) {
                System.out.println("= " + String.valueOf(numerador));
            } else {
                System.out.println("=");/*por estetica segun el tamano del numero mayor se ajusta la fraccion*/
                for (int i = 0; i < String.valueOf(mayor).length() / 2; i++) {
                    System.out.print(" ");/*espacio a la izquierda del numerador*/
                }
                System.out.println(String.valueOf(numerador));
                for (int i = 0; i < String.valueOf(mayor).length() * 2; i++) {
                    System.out.print("_");/*linea division*/
                }
                System.out.println("\n");
                for (int i = 0; i < String.valueOf(mayor).length() / 2; i++) {
                    System.out.print(" ");/*espacio izquierda denominador*/
                }
                System.out.println(String.valueOf(denominador));
            }
            do {
                error = false;
                System.out.println("\n¿Desea volver a intertarlo?\n"
                        + "(1)Si\n"
                        + "(2)No");
                opc = reader.nextInt();
                switch (opc) {
                    case 1:
                        rep = true;
                        break;
                    case 2:
                        rep = false;
                        break;
                    default:
                        error = true;
                        System.out.println("Opcion invalida");
                }
            } while (error);/*mientras no se una opcion valida se repite este bloque de codigo*/
        } while (rep);/*mientras el usario ingrese (1)Si se repetira todo el algoritmo*/

    }

}
