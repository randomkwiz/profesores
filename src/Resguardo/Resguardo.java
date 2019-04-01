package Resguardo;

import Clases.ProfesorImpl;
import java.io.*;

public class Resguardo {


    /*
     * INTERFAZ
     * Signatura: public void addToFile(File archivo, ProfesorImpl profe )
     * Comentario: añade un objeto a un archivo como registro nuevo
     * Precondiciones: por referencia se pasan un tipo File y un tipo ProfesorImpl. La ruta del archivo debe ser válida.
     * Entrada: se pasa un File y un ProfesorImpl
     * Salidas:
     * Postcondiciones: en el archivo quedara añadido un registro nuevo
     *
     * */
    public void addToFile(File archivo, ProfesorImpl profe ){

    }

    /*
     * INTERFAZ
     * Signatura: public ProfesorImpl buscarProfe(File archivo, int id )
     * Comentario: busca un profesor por su ID en el archivo correspondiente y lo devuelve
     * Precondiciones: por referencia se pasan un tipo File y un ID por valor. La ruta del archivo debe ser válida.
     * Entrada: se pasa un File y un int ID
     * Salidas: objeto de tipo ProfesorImpl
     * Postcondiciones: el archivo no se modifica. Asociado al nombre se devuelve el objeto Profesor buscado.
     *
     * */
    public ProfesorImpl buscarProfe(File archivo, String codigo ){
        ProfesorImpl profeBuscado = null;

        return profeBuscado;
    }


    /*
     * INTERFAZ
     * Signatura: public int[] obtenerEdades(File archivo, int numeroCampo)
     * Comentario: de un fichero dado extrae y coloca en un array de enteros todos los valores de un campo determinado
     * Precondiciones: el archivo debe existir y se pasa por referencia. El entero de numeroCampo se pasa por valor.
     * Entradas: File archivo y int numeroCampo
     * Salidas: array de enteros que es el conjunto de los valores de todos los registros de dicho campo
     * Postcondiciones: asociado al nombre se devuelve el array de las edades
     * */
    //nota de mejora: esto se podría hacer con tipos genéricos y estaría to guay
    public int[] obtenerEdades(File archivo, int numeroCampo){
        int[] array =new int[500];

        return array;
    }


    /*
     * INTERFAZ
     * Signatura: public double edadPromedio(int[] edades)
     * Comentario: pasado un array de enteros, halla y devuelve la media
     * Precondiciones: se pasa un array de enteros
     * Entradas: array de enteros
     * Salidas: real
     * Postcondiciones: asociado al nombre se pasa un double
     * */
    public double edadPromedio(int[] edades){

        return 0;
    }

    /*
     * Signatura: public ProfesorImpl profesorMasJoven (File archivo)
     * Comentario: devuelve el profesor mas joven del archivo
     * Precondiciones: se pasara el archivo donde estén los profesores y debe ser valido y contener profesores
     * Entradas: File archivo
     * Salidas: Se devuelve objeto profesor
     * Postcondiciones: asociado al nombre se devuelve un objeto profesor
     *
     * */
    public ProfesorImpl profesorMasJoven (File archivo){
        ProfesorImpl profe = null;

        return profe;
    }


    /*
     * Signatura: public ProfesorImpl profesorMasEdad (File archivo)
     * Comentario: devuelve el profesor mas viejo del archivo
     * Precondiciones: se pasara el archivo donde estén los profesores y debe ser valido y contener profesores
     * Entradas: File archivo
     * Salidas: Se devuelve objeto profesor
     * Postcondiciones: asociado al nombre se devuelve un objeto profesor
     *
     * */
    public ProfesorImpl profesorMasEdad (File archivo){
        ProfesorImpl profe = null;

        return profe;
    }




    /*
     * Signatura:  public int cantidadMayoresPromedio (File archivo)
     * Comentario: devuelve la cantidad de profesores con edad mayor al promedio
     * Precondiciones: se pasara el archivo donde estén los profesores y debe ser valido y contener profesores
     * Entradas: File archivo
     * Salidas: Se devuelve cantidad (entero)
     * Postcondiciones: asociado al nombre se devuelve la cantidad
     *
     * */
    public int cantidadMayoresPromedio (File archivo){


        return 0;
    }

    /*
     * Signatura:  public int cantidadMenoresPromedio (File archivo)
     * Comentario: devuelve la cantidad de profesores con edad menor al promedio
     * Precondiciones: se pasara el archivo donde estén los profesores y debe ser valido y contener profesores
     * Entradas: File archivo
     * Salidas: Se devuelve cantidad (entero)
     * Postcondiciones: asociado al nombre se devuelve la cantidad
     *
     * */
    public int cantidadMenoresPromedio (File archivo){
        int cantidad = 0;

        return cantidad;
    }

    /*
     * INTERFAZ
     * Signatura: public ProfesorImpl generarProfesor ()
     * Comentario: pide los datos para instanciar un objeto profesor y lo instancia y lo devuelve
     * Precondiciones:
     * Entradas:
     * Salidas: devuelve un profesor
     * Postcondiciones: asociado al nombre devuelve un profesor
     * */
    public ProfesorImpl generarProfesor(){
        ProfesorImpl profe = null;

        return profe;
    }


    /*
     * INTERFAZ
     * Signatura: public void imprimirProfesores(File archivo)
     * Comentario: imprime todos los profesores
     * Precondiciones: por referencia se pasan un tipo File . La ruta del archivo debe ser válida.
     * Entrada: se pasa un File
     * Salidas:
     * Postcondiciones: imprime en pantalla
     *
     * */
    public void imprimirProfesores(File archivo){

    }
}
