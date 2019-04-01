/*
 * Nombre: Profesor
 * Propiedades:
 *       Basicas:
 *           String codigo   CONSULTABLE Y MODIFICABLE
 *           String nombre   CONSULTABLE Y MODIFICABLE
 *           Sexo sexo       CONSULTABLE Y MODIFICABLE
 *           int edad        CONSULTABLE Y MODIFICABLE
 *       Derivadas:
 *       Compartidas:
 *           int contadorID
 * Restricciones:
 *   -la edad debe ser positiva
 * Metodos añadidos:
 * Metodos interface:
 * public int getProfesorID();
 * public String getNombre();
 * public Sexo getSexo();
 * public int getEdad();
 *
 * public void setNombre(String nombre);
 * public void setSexo(Sexo sexo);
 * public void setEdad(int edad);
 *
 * Metodos object:
 * toString
 * */
package Clases;
import Interfaces.*;
import Enumerados.*;
public class ProfesorImpl implements Profesor{

    private String codigo;
    private String nombre;
    private Sexo sexo;
    private int edad;



    public ProfesorImpl(){
        this.codigo = "DEFAULT";
        this.nombre = "DEFAULT";
        this.sexo = Sexo.NULL;
        this.edad = 0;
    }

    public ProfesorImpl(String codigo,String nombre, Sexo sexo, int edad){
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public ProfesorImpl(ProfesorImpl p){
        this.codigo = p.getCodigo();
        this.nombre = p.getNombre();
        this.sexo = p.getSexo();
        this.edad = p.getEdad();
    }


    /*Setters y getters*/
    public String getCodigo(){return this.codigo;}
    public String getNombre(){return this.nombre;}
    public Sexo getSexo(){return this.sexo;}
    public int getEdad(){return this.edad;}

    public void setCodigo(String codigo){this.codigo = codigo;}
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setSexo(Sexo sexo){
        this.sexo = sexo;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }


    /*Metodos Object*/
    @Override
    public String toString (){
        String cadena;
        cadena = getCodigo()+","+getNombre()+","+getSexo()+","+getEdad()+"\n";
        return cadena;
    }
}
