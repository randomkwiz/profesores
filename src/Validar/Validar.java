package Validar;

import Clases.ProfesorImpl;
import Enumerados.Sexo;
import Gestion.Gestion;

import java.util.Scanner;

public class Validar {
    /* INTERFAZ
     * Signatura: public int menu()
     * Comentario: pide lee y valida la opcion del menu
     * Precondiciones:
     * Entradas:
     * Salidas: entero que es la opcion del menu
     * Entradas/Salidas:
     * Postcondiciones: asociado al nombre devuelve opcion del menu
     * */
    public int menu(){
        Gestion gestion = new Gestion();
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            gestion.imprimirMenu();
            op = sc.nextInt();
        }while(op < 0 || op > 7);
        return op;
    }

    /*
    * INTERFAZ
    * Signatura: public int edad()
    * Comentario: pide y valida una edad que deberá ser igual o superior a 18
    * Precondiciones:
    * Entrada:
    * Salida: entero que es la edad
    * Postcondiciones: asociado al nombre se devuelve la edad validada
    *
    * */
    public int edad(){
        Scanner sc = new Scanner(System.in);
        int edad;
        System.out.println("Edad: ");
        edad = sc.nextInt();
        return edad;
    }

    /*
     * INTERFAZ
     * Signatura: public Sexo sexo()
     * Comentario: pide y valida un sexo
     * Precondiciones:
     * Entrada:
     * Salida: enum de Sexo
     * Postcondiciones: asociado al nombre se devuelve el sexo
     *
     * */
    public Sexo sexo(){
        Scanner sc = new Scanner(System.in);
        Sexo sexo = Sexo.NULL;
        String respuesta="";
        do {
            System.out.println("Escribe tu genero (Hombre/Mujer/Otro): ");
            respuesta = sc.next();
        }while(!respuesta.toLowerCase().equals("hombre") && !respuesta.toLowerCase().equals("mujer") && !respuesta.toLowerCase().equals("otro"));
        switch (respuesta){
            case "hombre":
                sexo = Sexo.HOMBRE;
                break;
            case "mujer":
                sexo = Sexo.MUJER;
                break;
            case "otro":
                sexo = Sexo.OTRO;
                break;
        }
        return sexo;
    }

    /*
     * INTERFAZ
     * Signatura: public String codigo()
     * Comentario: pide un codigo de profesor
     * Precondiciones:
     * Entrada:
     * Salida: String
     * Postcondiciones: asociado al nombre se devuelve el codigo
     * */
    public String codigo(){
        Scanner sc = new Scanner(System.in);
        String codigo="";
        System.out.println("Introduce el codigo del profesor: ");
        codigo = sc.next();

       return codigo;
    }


}
