package boletin7;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int resp, cant=0, hombre=0, mujer=0, otro=0, estado;
        double sumaPeso=0, sumaAltura=0, sumaEdad=0;
        //Bucle do-while para repetir el programa hatsa que la persona quiera dejar de introducir datos, sale pulsando 0
        do{
            cant++;
            System.out.println("Se va a crear una nueva persona");
            Persona persona=new Persona();
            persona.introducirDatos();
            estado=persona.imc();

            switch (estado) {
                case -1 -> System.out.println("Está bajo su peso ideal");
                case 0 -> System.out.println("Está en su peso ideal");
                case 1 -> System.out.println("Está por encima de su peso ideal");
            }
            //if-else para escribir en pantalla si es o no mayor de edad según el resultado de llamar al método mayorEdad
            if (persona.mayorEdad()){
                System.out.println("Es mayor de edad");
            }else {
                System.out.println("No es mayor de edad");
            }
            System.out.println(persona.toString());
            System.out.println("¿Desea introducir los datos de otra persona? pulse 1 para sí y 0 para no");
            resp=s.nextInt();
            sumaPeso+= persona.getPeso();
            sumaAltura+= persona.getAltura();
            sumaEdad+= persona.getEdad();
            //switch para sumar al contador de cada género en función del género de la persona
            switch (persona.getGenero()) {
                case H -> hombre++;
                case M -> mujer++;
                case O -> otro++;
            }
        }while (resp==1);
        //Bucle do-while para repetir el menú tantas veces como desee el usuario
        do {
            menu(cant, sumaPeso, sumaAltura, sumaEdad, hombre, mujer, otro);
            System.out.println("¿Desea ver algo más? pulse 1 para sí y 0 para no");
            resp=s.nextInt();
        }while (resp==1);
    }

    public static void menu(int cant, double sumaPeso, double sumaAltura, double sumaEdad, int hombre, int mujer, int otro){
        Scanner s=new Scanner(System.in);
        int resp;
        System.out.println("Introduzca los siguientes números dependiendo de la acción que quiera realizar:");
        System.out.println("1 para la media del peso de todas las personas");
        System.out.println("2 para la media de la altura de todas las personas");
        System.out.println("3 para la media de edad de todas las personas");
        System.out.println("4 para cuantas personas de cada género hubo");
        resp=s.nextInt();
        //Switch para que realice una acción del menú según la respuesta que se haya escogido
        switch (resp){
            case 1:
                System.out.println("La media del peso de las personas es "+media(cant, sumaPeso));
                break;
            case 2:
                System.out.println("La media de la altura de las personas es "+media(cant, sumaAltura));
                break;
            case 3:
                System.out.println("La media de edad de las personas es "+media(cant, sumaEdad));
                break;
            case 4:
                System.out.println("El "+porcentaje(cant, hombre)+"% son hombres. ("+hombre+" hombres)");
                System.out.println("El "+porcentaje(cant, mujer)+"% son mujeres. ("+mujer+" mujeres)");
                System.out.println("El "+porcentaje(cant, otro)+"% son otros. ("+otro+" otros)");
                break;
        }
    }
    public static double media (int cant, double suma){
        return suma/cant;
    }
    public static double porcentaje (int cant, int x){
        return (double) x*100/cant;
    }
}
