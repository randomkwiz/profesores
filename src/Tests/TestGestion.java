package Tests;

import Clases.ProfesorImpl;
import Enumerados.Sexo;
import Gestion.Gestion;
import Utilidades.Utilidad;

import java.io.File;

public class TestGestion {
    public static void main(String[] args) {
        File f = new File("./profesoresArchivo.txt");
        ProfesorImpl p = new ProfesorImpl("MOD3", "MARIA", Sexo.MUJER, 8);
        Gestion gestion = new Gestion();
        Utilidad u = new Utilidad();
        int[] arrayEdades;
        System.out.println(gestion.isCodigoRepetido(f,"MOD1"));;
        //gestion.addToFile(f,p);
        System.out.println(gestion.buscarProfe(f,"MOD1"));
        arrayEdades= gestion.obtenerEdades(f,3);
        for(int i = 0; i < u.siguientePosicionLibre(arrayEdades); i ++ ){
            System.out.println(arrayEdades[i]);
        }


    }
}
