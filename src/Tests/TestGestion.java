package Tests;

import Clases.ProfesorImpl;
import Enumerados.Sexo;
import Gestion.Gestion;

import java.io.File;

public class TestGestion {
    public static void main(String[] args) {
        File f = new File("./profesoresArchivo.txt");
        ProfesorImpl p = new ProfesorImpl("MOD1", "PEPE", Sexo.HOMBRE, 43);
        Gestion gestion = new Gestion();

        System.out.println(gestion.isCodigoRepetido(f,"MOD1"));;

    }
}
