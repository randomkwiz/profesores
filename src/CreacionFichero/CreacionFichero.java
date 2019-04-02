package CreacionFichero;
import Clases.ProfesorImpl;
import Enumerados.Sexo;
import Gestion.Gestion;
import Validar.Validar;
import java.io.*;
import java.util.Scanner;

/*
* El archivo de creación del fichero debe tener lo necesario para
* crear el fichero (si ya existe lo borra. De eso debes preocuparte tú, de no
* ejecutarlo cuando no debes), cargar los datos iniciales
* y dejarlos como te pidan al inicio (ordenados, por ejemplo).
* No debe tener menú sino que es algo lineal que se ejecuta completamente
* cada vez que le das a ejecutar.
* */
public class CreacionFichero {
    public static void main(String[] args) {
        File archivo = new File("./profesoresArchivo.txt");
        Scanner entrada = new Scanner(System.in);
        FileWriter escribir = null;
        BufferedWriter bw = null;
        FileReader leer = null;
        BufferedReader br = null;
        Validar validar = new Validar();
        Gestion gest = new Gestion();
        ProfesorImpl profe = new ProfesorImpl();
        String codigo, nombre;
        Sexo sexo;
        int edad;
        try{
            escribir = new FileWriter(archivo,false);
            bw = new BufferedWriter(escribir);
            for(int i = 0; i < 3; i++ ) {
                //pido los datos fuera porque una clase no se puede validar a si misma
                codigo = validar.codigo();
                System.out.println("Nombre: ");
                nombre = entrada.nextLine();
                sexo = validar.sexo();
                edad = validar.edad();
                //llamo al metodo que tiene dentro los setters
                profe.superCrear(codigo.toUpperCase(), nombre.toUpperCase(), sexo, edad);
                bw.write(profe.toString());
                bw.newLine();
            }
            bw.close();
            escribir.close();
        }catch (IOException e){
            e.getStackTrace();

        }

        try{
            leer = new FileReader(archivo);
            br = new BufferedReader(leer);

            while(br.ready()){
                System.out.println(br.readLine());
            }
        }catch (IOException e){
            e.getStackTrace();
        }




    }
}
