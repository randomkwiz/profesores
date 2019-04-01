package Utilidades;

import Clases.ProfesorImpl;
import Enumerados.Sexo;
import Gestion.Gestion;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;

public class Utilidad {

    /* INTERFAZ
     * Signatura: public int siguientePosicionLibre(int[] array)
     * Comentario: devuelve la siguiente posicion libre de un array
     * Precondiciones: se pasa un array
     * Entradas: array de int
     * Salidas: entero que es la posicion libre
     * Entradas/Salidas:
     * Postcondiciones: asociado al nombre se devuelve la posicon.
     * */
    public int siguientePosicionLibre(int[] array) {
        int pos = 0;
        for (int i = array.length -1; i >= 0; i -- ) {
            if (array[i] == 0 ) {	//devuelve el ultimo 0 empezando a contar por el final. Eso se traduce en que devuelve el siguiente espacio libre del array (empezando por el principio)
                pos = i;
            }
        }

        return pos;
    }

    /*
    * INTERFAZ
    * Signatura: public void cargarFichero (File archivo)
    * Comentario: carga el fichero con lo básico para que no salte nullpointerexception si lo tiene que crear de nuevo y está vacío
    * Precondiciones: se pasa el fichero que se quiere cargar
    * Entrada:
    * Salida:
    * Entrada/Salida: File archivo
    * Postcondiciones: se devuelve el fichero cargado
    * */
    public void cargarFichero (File archivo){
        Gestion gest = new Gestion();
        gest.addToFile(archivo, new ProfesorImpl("PROG1", "ASUN", Sexo.MUJER,56));
        gest.addToFile(archivo, new ProfesorImpl("BBDD1", "LEO", Sexo.HOMBRE,55));
        gest.addToFile(archivo, new ProfesorImpl("SI1", "FERNANDO", Sexo.HOMBRE,46));
        gest.addToFile(archivo, new ProfesorImpl("ENDES1", "MIGUEL ANGEL", Sexo.HOMBRE,42));
    }


}
