/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion.controladores;

import administracion.modelos.Actividad;
import administracion.modelos.Curso;
import administracion.modelos.Nota;
import autenticacion.modelos.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dg551
 */
public class GestorNotas implements Serializable{
    public static GestorNotas instancia;
    private ArrayList<Nota> notas;
    
    public GestorNotas() {
        notas = new ArrayList<>();
    }
    
    public static GestorNotas getInstancia() {
        if(instancia == null){
            instancia = new GestorNotas();
        }
        return instancia;
    }
    
    // Método para crear una nueva nota al curso
    public Nota crearNota(Actividad actividad, Double punteo, Usuario alumno) {
        Nota nuevaNota = new Nota(alumno, actividad, punteo);
        notas.add(nuevaNota);
        return nuevaNota;
    }
    
    public double obtenerPromedioNotasPorActividad(Actividad actividad) {
        double sumaNotas = 0.0;
        int cantidadNotas = 0;

        for (Nota nota : notas) {
            if (nota.getActividad().equals(actividad)) {
                sumaNotas += nota.getValor();
                cantidadNotas++;
            }
        }

        if (cantidadNotas > 0) {
            return sumaNotas / cantidadNotas;
        } else {
            return 0.0; // Si no hay notas para la actividad, el promedio es 0.
        }
    }
    
    //Método para obtener la nota
//    public void obtenerNotaPorAlumno(Alumno){
//    
//    }
}
