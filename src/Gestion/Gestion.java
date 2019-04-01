package Gestion;

import Clases.ProfesorImpl;
import Enumerados.Sexo;
import Interfaces.Profesor;
import Utilidades.Utilidad;
import Validar.Validar;

import java.io.*;
import java.util.Scanner;

public class Gestion {

    /*
     * MENU
     * */
    public void imprimirMenu(){
        System.out.println("--------------- MENU --------------");
        System.out.println("0: Salir\n"+"1: Nombre del profesor mas joven del grupo\n" +
                "2: Nombre del profesor de más edad\n" +
                "3: Numero de profesores con edad mayor al promedio\n" +
                "4: Numero de profesores con edad menor al promedio\n" +
                "5: Añadir profesor al archivo\n" +
                "6: Ver profesores del archivo\n" +
                "7: Buscar un profesor (por codigo) ");
    }

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
        FileWriter escribir = null;
        BufferedWriter buf = null;
        try{
            escribir = new FileWriter(archivo,true);
            buf = new BufferedWriter(escribir);
            buf.newLine();
            escribir.write(profe.toString());
            escribir.flush();
            escribir.close();

        }catch (IOException e){
            e.printStackTrace();
        }
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
        BufferedReader buf = null;
        FileReader leer = null;
        String registro = "";
        String campos[] ;
        ProfesorImpl profeBuscado = null;
        Sexo sexo;
        boolean exito = false;

        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);
            while(buf.ready() && !exito){
                registro = buf.readLine();
                campos = registro.split(",");
                if ( campos[0].equals(codigo)){
                    profeBuscado = new ProfesorImpl(campos[0],campos[1], Sexo.valueOf(campos[2]),Integer.parseInt(campos[3]));
                    exito = true;
                }
            }
            buf.close();
            leer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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
        FileReader leer = null;
        BufferedReader buf = null;
        String registro = "";
        String campos[] ;


        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);
            int i = 0;

            while(buf.ready() && i < array.length){

                registro = buf.readLine();
                campos = registro.split(",");

                array[i] = Integer.parseInt(campos[numeroCampo]);

                ++i;
            }
            buf.close();
            leer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

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
        Utilidad util = new Utilidad();
        double contador=0;
        for(int i = 0; i < util.siguientePosicionLibre(edades); i ++){
            contador+=edades[i];
        }
        return contador/(double)util.siguientePosicionLibre(edades);
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
        FileReader leer = null;
        BufferedReader buf = null;
        ProfesorImpl profe = null;
        String registro = "";
        String[] campos ;
        int minimo = 9999999;
        final int EDAD = 3; //la edad es el campo 3

        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);

            while(buf.ready()){
                registro = buf.readLine();
                campos = registro.split(",");

                if ( Integer.parseInt(campos[EDAD]) < minimo){

                    minimo = Integer.parseInt(campos[EDAD]);
                    profe = new ProfesorImpl(campos[0], campos[1],Sexo.valueOf(campos[2]), Integer.parseInt(campos[3]));
                }
            }
            leer.close();
            buf.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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
        FileReader leer = null;
        BufferedReader buf = null;
        ProfesorImpl profe = null;
        String registro = "";
        String[] campos ;
        int maximo = -9999999;
        final int EDAD = 3; //la edad es el campo 3

        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);

            while(buf.ready()){
                registro = buf.readLine();
                campos = registro.split(",");

                if ( Integer.parseInt(campos[EDAD]) > maximo){

                    maximo = Integer.parseInt(campos[EDAD]);
                    profe = new ProfesorImpl(campos[0], campos[1],Sexo.valueOf(campos[2]), Integer.parseInt(campos[3]));
                }
            }
            leer.close();
            buf.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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
        FileReader leer = null;
        BufferedReader buf = null;
        ProfesorImpl profe = null;
        String registro = "";
        String[] campos ;
        final int EDAD = 3; //la edad es el campo 3
        double promedio = edadPromedio(obtenerEdades(archivo,EDAD));
        int cantidad = 0;


        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);

            while(buf.ready()){
                registro = buf.readLine();
                campos = registro.split(",");

                if ( Integer.parseInt(campos[EDAD]) > promedio){
                    cantidad++;
                }
            }
            leer.close();
            buf.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return cantidad;
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
        FileReader leer = null;
        BufferedReader buf = null;
        ProfesorImpl profe = null;
        String registro = "";
        String[] campos ;
        final int EDAD = 3; //la edad es el campo 3
        double promedio = edadPromedio(obtenerEdades(archivo,EDAD));
        int cantidad = 0;


        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);

            while(buf.ready()){
                registro = buf.readLine();
                campos = registro.split(",");

                if ( Integer.parseInt(campos[EDAD]) < promedio){
                    cantidad++;
                }
            }
            leer.close();
            buf.close();
        }catch (IOException e){
            e.printStackTrace();
        }
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
     *
     * */
    public ProfesorImpl generarProfesor(){
            Scanner sc = new Scanner(System.in);
            Validar validar = new Validar();
            ProfesorImpl profe = null;
            String nombre, codigo;
            int edad;
            Sexo sexo;

            System.out.println("Codigo profesor: ");
            codigo = sc.next();
            System.out.println("Nombre: ");
            nombre = sc.next();
            edad = validar.edad();
            sexo = validar.sexo();

            profe = new ProfesorImpl(codigo.toUpperCase(), nombre.toUpperCase(), sexo, edad);


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
        BufferedReader buf = null;
        FileReader leer = null;
        String registro = "";
        String campos[] ;


        try{
            leer = new FileReader(archivo);
            buf = new BufferedReader(leer);
            while(buf.ready() ){
                registro = buf.readLine();
                campos = registro.split(",");
                System.out.println("Codigo: "+campos[0]);
                System.out.println("Nombre: "+campos[1]);
                System.out.println("Sexo: "+campos[2]);
                System.out.println("Edad: "+campos[3]);
                System.out.println("----------------------");
            }
            buf.close();
            leer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /*
    * INTERFAZ
    * Signatura: public void asegurarExistenciaArchivo (File archivo)
    * Comentario: Asegura la existencia del archivo. Si no existe, lo crea y le añade los registros básicos.
    * Precondiciones: se pasa el archivo (existente o no)
    * Entradas: File archivo
    * SalidaS:
    * Postcondiciones: se asegura que el archivo existirá
    * */
    public void asegurarExistenciaArchivo(File archivoProfesores){
        boolean existencia;
        Utilidad util = new Utilidad();
        try {
            existencia = archivoProfesores.createNewFile(); //si no existe el archivo lo crea
            if (existencia){
                util.cargarFichero(archivoProfesores);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
