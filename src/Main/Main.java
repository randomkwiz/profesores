/*
* PSEUDOCODIGO
* inicio
* asegurarExistenciaArchivo
* si (archivo existe)
*   repetir
*       mostrarMenuLeerValidarOpcion
*       si (opcion no es salir)
*           segun(opcion)
*               caso 1: Nombre del profesor mas joven del grupo
*               caso 2: Nombre del profesor de más edad
*               caso 3: Numero de profesores con edad mayor al promedio
*               caso 4: Numero de profesores con edad menor al promedio
*               caso 5: Añadir profesor al archivo
*               caso 6: Ver profesores del archivo
*               caso 7: Buscar un profesor (por codigo)
*           finSegun
*       finSi
*   mientras(opcion no sea salir)
* finSi
* fin
*
* */
package Main;
import Clases.*;
import Enumerados.Sexo;
import Gestion.Gestion;
import Utilidades.Utilidad;
import Validar.Validar;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File archivoProfesores = new File("./archivoProfesores.txt");
        Utilidad util = new Utilidad();
        Gestion gest = new Gestion();
        Validar validar = new Validar();
        String codigo = "";
        int op;

        //asegurarExistenciaArchivo
        gest.asegurarExistenciaArchivo(archivoProfesores);
        if (archivoProfesores.exists()){
            do {
                //mostrarMenuLeerValidarOpcion
                op = validar.menu();

                if (op != 0) {
                    switch (op) {
                        case 1:
                            //Nombre del profesor mas joven del grupo
                            System.out.println("El profesor más joven del grupo es: " + gest.profesorMasJoven(archivoProfesores).getNombre() + " con " + gest.profesorMasJoven(archivoProfesores).getEdad() + " años.");
                            break;
                        case 2:
                            //Nombre del profesor de más edad
                            System.out.println("El profesor de más edad del grupo es: " + gest.profesorMasEdad(archivoProfesores).getNombre() + " con " + gest.profesorMasEdad(archivoProfesores).getEdad() + " años.");
                            break;
                        case 3:
                            //Numero de profesores con edad mayor al promedio
                            System.out.println("Hay " + gest.cantidadMayoresPromedio(archivoProfesores) + " profesores mayores a " + gest.edadPromedio(gest.obtenerEdades(archivoProfesores, 3)));
                            break;
                        case 4:
                            //Numero de profesores con edad menor al promedio
                            System.out.println("Hay " + gest.cantidadMenoresPromedio(archivoProfesores) + " profesores menores a " + gest.edadPromedio(gest.obtenerEdades(archivoProfesores, 3)));
                            break;
                        case 5:
                            //Añadir profesor al archivo
                            gest.addToFile(archivoProfesores, gest.generarProfesor());
                            break;
                        case 6:
                            //Ver profesores del archivo
                            gest.imprimirProfesores(archivoProfesores);
                            break;
                        case 7:
                            //Buscar un profesor (por codigo)
                            codigo = validar.codigo();
                            if (gest.buscarProfe(archivoProfesores, codigo.toUpperCase()) != null) {
                                System.out.println(gest.buscarProfe(archivoProfesores, codigo.toUpperCase()).toString());
                            } else {
                                System.out.println("Búsqueda finalizada sin éxito.");
                            }
                            break;

                    }
                }
            } while (op != 0);
    }
    }

}
