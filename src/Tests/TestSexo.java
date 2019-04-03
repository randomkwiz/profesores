package Tests;

import Enumerados.Sexo;

public class TestSexo {
    public static void main(String[] args) {
        System.out.println(Sexo.HOMBRE);
        System.out.println(Sexo.MUJER);
        System.out.println(Sexo.OTRO);

        System.out.println(Sexo.valueOf("OTRO"));

    }
}
