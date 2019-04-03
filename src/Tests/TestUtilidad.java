package Tests;

import Utilidades.Utilidad;

public class TestUtilidad {
    public static void main(String[] args) {
        Utilidad u = new Utilidad();
        int[] array = new int[3];
        System.out.println(u.siguientePosicionLibre(array));
/*
        u.cargarFichero();  //sale así porque es un método obsoleto [sale tachado]
*/
    }
}
