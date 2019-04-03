package Tests;
import Clases.ProfesorImpl;
import Enumerados.Sexo;

public class TestProfesorImpl {
    public static void main(String[] args) {
        ProfesorImpl p1 = new ProfesorImpl();
        ProfesorImpl p2 = new ProfesorImpl("COD1", "Luis", Sexo.HOMBRE, 30);
        ProfesorImpl p3 = new ProfesorImpl(p2);
        System.out.println(p1.toString());
        p1.superCrear("COD2","PEPE",Sexo.HOMBRE, 35);
        System.out.println(p1.toString());
        System.out.println(p3.toString());

    }

}
