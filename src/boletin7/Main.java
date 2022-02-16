package boletin7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int resp;
        //Bucle do-while para repetir el programa hatsa que la persona quiera dejar de introducir datos, sale pulsando 0
        do{
            Utilidades.cantPersonas++;
            System.out.println("Se va a crear una nueva persona");
            Persona persona=new Persona();
            persona.introducirDatos();

            switch (persona.imc()) {
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
            System.out.println(persona);
            System.out.println("¿Desea introducir los datos de otra persona? pulse 1 para sí y 0 para no");
            resp=Utilidades.leerNumero();
        }while (resp==1);
        Utilidades.menu();
    }
}
