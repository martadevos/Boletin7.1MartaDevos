package boletin7;

public class Persona {
    private String nombre, DNI;
    private int edad;
    private char genero;
    private double peso, altura;

    public Persona(String nombre, String DNI, int edad, char genero, double peso, double altura) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
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

    public double imc (){
        double imc = this.peso / Math.pow(this.altura, 2);
        int dev;
        if (imc<18.5){
            dev=-1;
        }else if (imc>=18.5 &&imc <=24.9){
            dev=0;
        }else {
            dev=1;
        }
        return dev;
    }
}
