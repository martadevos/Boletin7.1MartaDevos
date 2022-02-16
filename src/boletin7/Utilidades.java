package boletin7;

import java.util.Scanner;

public class Utilidades {
    public static Scanner s = new Scanner(System.in);
    static int cantPersonas = 0, sumaEdad = 0, hombre = 0, mujer = 0, otro = 0;
    static double sumaPeso = 0, sumaAltura = 0;
    private static boolean salir=false;
    /**
     * Método de comprobación para la entrada de datos al programa.
     * @return Devuelve un entero que nos sirve para el menú y además comprobamos su validez.
     */
    public static int leerNumero (){
        int numero = 0;
        boolean salir=false;
        do {
            try {
                numero = s.nextInt();
                salir=true;
            } catch (Exception e) {
                s.nextLine();
                System.out.println("Esto no es un número entero.");
            }
        }while (!salir);
        return numero;
    }
    /**
     * Este programa es para mostrar el menú final de preguntando que se desea hacer con los datos introducidos.
     */
    public static void menu(){
        int resp;
        do {
        System.out.println("Introduzca los siguientes números dependiendo de la acción que quiera realizar:");
        System.out.println("1 para la media del peso de todas las personas");
        System.out.println("2 para la media de la altura de todas las personas");
        System.out.println("3 para la media de edad de todas las personas");
        System.out.println("4 para cuantas personas de cada género hubo");
        System.out.println("5 para salir");
        resp=leerNumero();
        //Switch para que realice una acción del menú según la respuesta que se haya escogido
        switch (resp) {
            case 1 -> System.out.println("La media del peso de las personas es " + media(cantPersonas, sumaPeso));
            case 2 -> System.out.println("La media de la altura de las personas es " + media(cantPersonas, sumaAltura));
            case 3 -> System.out.println("La media de edad de las personas es " + media(cantPersonas, sumaEdad));
            case 4 -> {
                System.out.println("El " + porcentaje(cantPersonas, hombre) + "% son hombres. (" + hombre + " hombres)");
                System.out.println("El " + porcentaje(cantPersonas, mujer) + "% son mujeres. (" + mujer + " mujeres)");
                System.out.println("El " + porcentaje(cantPersonas, otro) + "% son otros. (" + otro + " otros)");
            }
            case 5 -> salir=true;
            default -> System.out.println("La opción no es correcta");
        }

        }while (!salir);
    }
    public static double media (int cant, double suma){
        return suma/cant;
    }
    public static double porcentaje (int cant, int x){
        return (double) x*100/cant;
    }
}
