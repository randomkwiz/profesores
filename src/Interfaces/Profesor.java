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
package Interfaces;
import Enumerados.Sexo;
public interface Profesor {

     public String getCodigo();
     public String getNombre();
     public Sexo getSexo();
     public int getEdad();

     public void setCodigo(String codigo);
     public void setNombre(String nombre);
     public void setSexo(Sexo sexo);
     public void setEdad(int edad);
}
