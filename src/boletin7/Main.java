package boletin7;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String genero;
        Persona Persona1=new Persona();
        System.out.println("Introduzca su nombre: ");
        Persona1.setNombre(s.next());
        System.out.println("Introduzca su DNI: ");
        Persona1.setDni(s.next());
        System.out.println("Introduzca su edad: ");
        Persona1.setEdad(s.nextInt());
        System.out.println("Introduzca su peso: ");
        Persona1.setPeso(s.nextDouble());
        System.out.println("Introduzca su altura: ");
        Persona1.setAltura(s.nextDouble());
        System.out.println("Introduzca su género. (hombre, mujer u otro): ");
        while (Persona1.getGenero()==GENERO.NULL) {
            System.out.println("No es correcto, introduzca de nuevo su género. (hombre, mujer u otro) ");
            genero=s.next();
            switch (genero){
                case "hombre":
                    Persona1.setGenero(GENERO.H);
                    break;
                case "mujer":
                    Persona1.setGenero(GENERO.M);
                    break;
                case "otro":
                    Persona1.setGenero(GENERO.O);
                    break;
                default:
            }
        }

    }
}
