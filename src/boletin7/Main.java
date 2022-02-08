package boletin7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int resp;
        System.out.println("¿Desea introducir una persona nueva? Introduzca 1 para sí y 0 para no");
        resp=s.nextInt();
        if (resp==1){
            Persona Persona=new Persona();
            System.out.print("Introduzca su nombre: ");
            Persona.setNombre(s.next());
            System.out.print("Introduzca su DNI: ");
            Persona.setDni(s.next());
            System.out.print("Introduzca su edad: ");
            Persona.setEdad(s.next());
            System.out.print("Introduzca su peso: ");
            Persona.setPeso(s.next());
            System.out.print("Introduzca su altura: ");
            Persona.setAltura(s.next());
            System.out.print("Introduzca su género(H para hombre, M para mujer y O para otro): ");
            Persona.setGenero();
        }
        if (resp==0){

        }
    }
}
