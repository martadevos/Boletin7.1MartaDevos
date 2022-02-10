package boletin7;

import java.util.Scanner;

enum GENERO {H, M, O, NULL}

public class Persona implements Comparable<Persona> {
    private String nombre, dni;
    private int edad;
    private GENERO genero;
    private double peso, altura;

    //Constructor con con atributos por defecto
    public Persona() {
        this.nombre = "";
        this.dni = "";
        this.edad = 0;
        this.genero = GENERO.NULL;
        this.peso = 0;
        this.altura = 0;
    }

    //Constructor ordinario para rellenar
    public Persona(String nombre, String dni, int edad, GENERO genero, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    //Constructor copia
    public Persona(Persona persona) {
        this.nombre = persona.nombre;
        this.dni = persona.dni;
        this.edad = persona.edad;
        this.genero = persona.genero;
        this.peso = persona.peso;
        this.altura = persona.altura;
    }

    //Método clon sobreescrito
    @Override
    protected Object clone() {
        Persona persona = null;
        try {
            persona = (Persona) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("No se puede clonar el objeto");
        }
        return persona;
    }


    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public GENERO getGenero() {
        return genero;
    }

    public void setGenero(GENERO genero) {
        this.genero = genero;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    //Método toString propio
    @Override
    public String toString() {
        return "Persona: " + System.lineSeparator() +
                "Nombre: " + nombre + System.lineSeparator() +
                "DNI: " + dni + System.lineSeparator() +
                "Género: " + genero + System.lineSeparator() +
                "Edad: " + edad + System.lineSeparator() +
                "Peso: " + peso + System.lineSeparator() +
                "Altura: " + altura + System.lineSeparator() +
                "IMC: " + calcularImc();
    }

    /*
     * Método que calcula el imc dividiendo el peso de la persona entre su altura en metros al
     * cuadrado y la devuelve para usarla después
     * @return Devuelve un double que corresponde al imc de la persona
     */
    public double calcularImc() {
        return this.peso / Math.pow(this.altura, 2);
    }

    /*
     * Método para ver si la persona está bajopeso, normopeso o con sobrepeso a través de if,
     * else if y else; llama al método calcularImc y si el imc es menor de 18.5, está bajopeso
     * (devuelve -1), si está entre 18.5 y 24.9, está normopeso (devuelve 0) y si es mayor a
     * 24.9 está con sobrepeso (devuelve 1)
     * @return Devuelve un int que indica en qué rango de peso está
     */
    public int imc() {
        int dev;
        if (calcularImc() < 18.5) {
            dev = -1;
        } else if (calcularImc() >= 18.5 && calcularImc() <= 24.9) {
            dev = 0;
        } else {
            dev = 1;
        }
        return dev;
    }

    /*
     * Metodo para comprobar si es mayor de edad (18 años) a través de un bucle if; si es mayor de 18 años,
     * devuelve un booleno con true y si es no es mayor de 18 con un false
     * @return devuelve un booleano que indica si es o no mayor de edad
     */
    public boolean mayorEdad() {
        return this.edad >= 18;
    }

    //compareTo de nombre por orden natural
    @Override
    public int compareTo(Persona objc) {
        return this.nombre.compareTo(objc.nombre);
    }

    /*Método para crear nuevas personas pidiendo: nombre, DNI, edad, peso, altura y género y
    almacenando los datos en el objeto persona*/
    public void introducirDatos() {
        Scanner s = new Scanner(System.in);
        String genero;
        System.out.println("Introduzca su nombre: ");
        this.nombre=s.next();
        System.out.println("Introduzca su DNI: ");
        this.dni=s.next();
        System.out.println("Introduzca su edad: ");
        this.edad=s.nextInt();
        System.out.println("Introduzca su peso: ");
        this.peso=s.nextDouble();
        System.out.println("Introduzca su altura: ");
        this.altura=s.nextDouble();
        System.out.println("Introduzca su género. (hombre, mujer u otro): ");
        while (this.genero == GENERO.NULL) {
            genero = s.next();
            switch (genero) {
                case "hombre" -> this.genero = GENERO.H;
                case "mujer" -> this.genero = GENERO.M;
                case "otro" -> this.genero = GENERO.O;
                default -> {
                }
            }
            if (this.genero==GENERO.NULL){
                System.out.println("No es correcto, introduzca de nuevo su género. (hombre, mujer u otro) ");
            }
        }
    }
    public boolean equals(Object obj){
        boolean resp=false;
        if(this==obj){
            resp=true;
        } else if (obj != null && obj instanceof Persona otra) {
            if (this.nombre.equals(otra.nombre)&&
            this.dni.equals(otra.dni)&&
            this.genero.equals(otra.genero)&&
            this.edad==otra.edad&&
            this.peso==otra.peso&&
            this.altura==otra.altura){
                resp=true;
            }
        }
        return resp;
    }
}

