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
public class GestorCursos implements Serializable{
    public static GestorCursos instancia;
    private ArrayList<Curso> cursos; // Una lista para almacenar los cursos
    
    public GestorCursos() {
        cursos = new ArrayList<>();
    }
    
    public static GestorCursos getInstancia() {
        if(instancia == null){
            instancia = new GestorCursos();
        }
        return instancia;
    }

    // Método para crear un nuevo curso
    public void crearCurso(String codigo, String nombre, int creditos, Usuario profesor) {
        Curso nuevoCurso = new Curso(codigo, nombre, creditos, new ArrayList<>(), profesor, new ArrayList<>(), new ArrayList<>());
        cursos.add(nuevoCurso);
    }
     
    // Método para editar un curso
    public void actualizarCurso(String codigo, String nombre, int creditos, Usuario profesor) {
        try {
            Curso curso = obtenerCursoByCodigo(codigo);
            if (curso != null) {
                curso.setNombre(nombre);
                curso.setCreditos(creditos);
                curso.setProfesor(profesor);
            } else {
        }
        } catch (Exception e){
        }
    }
    
    // Método para listar los cursos
    public ArrayList<Curso> getCursos(){
        ArrayList<Curso> lstCursos = new ArrayList<>();
        for (Curso curso : cursos){
            if (curso != null) {
                lstCursos.add(curso);
            }
        } 
        return lstCursos;
    }
    
    // Método para listar los cursos del profesor
    public ArrayList<Curso> getCursosDelProfesor(Usuario profesor) {
        ArrayList<Curso> cursosDelProfesor = new ArrayList<>();
        for (Curso curso : cursos) {
            if (curso != null && curso.getProfesor().getCodigo().equals(profesor.getCodigo())) {
                cursosDelProfesor.add(curso);
            }
        }
        return cursosDelProfesor;
    }
    
    // Método para listar los cursos del alumno
    public ArrayList<Curso> getCursosDelAlumno(Usuario alumno) {
        ArrayList<Curso> cursosDelAlumno = new ArrayList<>();
        for (Curso curso : cursos) {
            for (Usuario alumnoI : curso.getAlumnos()) {
                if (alumnoI != null && alumnoI.getCodigo().equals(alumno.getCodigo())) {
                    cursosDelAlumno.add(curso);
                }
            }
        }
        return cursosDelAlumno;
    }
    
    //Método que verifica la existencia de un curso
    public boolean existeCurso(String codigo){
        for (Curso curso: cursos){
            if(curso != null && curso.getCodigo().equals(codigo)) return true;
        }
        return false;
    }
    
    //Método para obtener un curso por su código
    public Curso obtenerCursoByCodigo(String codigo){
        for(Curso curso: cursos){
            if(curso != null && curso.getCodigo().equals(codigo)){
                return curso;
            }
        }
        return null;
    }
    
    //Método para eliminar un curso
    public void eliminarCurso(String codigo) {
        Curso curso = obtenerCursoByCodigo(codigo);

        if (curso != null) {
            cursos.remove(curso); // Elimina el usuario del ArrayList
        }
    }
    
    //Método para asignar la lista de cursos
    public void setListaCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
    
    //Método para agregar un usuario al curso
    public void agregaAlumno(String codigoCurso, Usuario alumno) {
        try{
            Curso curso = obtenerCursoByCodigo(codigoCurso);
            if (curso != null) {
                curso.setAlumno(alumno);
            } else {
            // Manejar el caso en el que no se encuentre el usuario
        }
        }catch (Exception e){
        }
    }
    
    // Método para eliminar un usuario del curso
    public void eliminarAlumno(String codigoCurso, Usuario alumno) {
        try {
            Curso curso = obtenerCursoByCodigo(codigoCurso);
            for (Usuario alumnoI : curso.getAlumnos()) {
                if (alumnoI != null && alumnoI.getCodigo().equals(alumno.getCodigo())) {
                    curso.eliminarAlumno(alumno);
                }
            }
        } catch (Exception e) {
            // Manejar cualquier excepción aquí
        }
    }
    
    // Método para agregar una actividad a un curso
    public void agregarActividadACurso(String codigoCurso, Actividad actividad) {
        Curso curso = obtenerCursoByCodigo(codigoCurso);
        if (curso != null) {
            curso.agregarActividad(actividad);
        } else {
            // Manejar el caso en el que no se encuentre el curso
        }
    }

    // Método para agregar una nota a un curso
    public void agregarNotaACurso(String codigoCurso, Nota nota) {
        Curso curso = obtenerCursoByCodigo(codigoCurso);
        if (curso != null) {
            curso.agregarNota(nota);
        } else {
            // Manejar el caso en el que no se encuentre el curso
        }
    }

    // Método para obtener las actividades de un curso
    public ArrayList<Actividad> obtenerActividadesDeCurso(String codigoCurso) {
        Curso curso = obtenerCursoByCodigo(codigoCurso);
        if (curso != null) {
            return curso.getActividades();
        } else {
            // Manejar el caso en el que no se encuentre el curso
            return new ArrayList<>();
        }
    }

    // Método para obtener las notas de un curso
    public ArrayList<Nota> obtenerNotasDeCurso(String codigoCurso) {
        Curso curso = obtenerCursoByCodigo(codigoCurso);
        if (curso != null) {
            return curso.getNotas();
        } else {
            // Manejar el caso en el que no se encuentre el curso
            return new ArrayList<>();
        }
    }
    
    // Método para obtener los alumnos del curso
    public ArrayList<Usuario> obtenerAlumnosDeCurso(String codigoCurso) {
        Curso curso = obtenerCursoByCodigo(codigoCurso);
        if (curso != null) {
            return curso.getAlumnos();
        } else {
            // Manejar el caso en el que no se encuentre el curso
            return new ArrayList<>();
        }
    }
    
    // Método para sumar ponderaciones
    public double obtenerSumaPonderaciones(ArrayList<Actividad> actividades) {
        double suma = 0;
        for (Actividad actividad : actividades) {
            suma += actividad.getPonderacion();
        }
        return suma;
    }
    
    public static void main(String[] args) {
        // Ejemplo de cómo utilizar el método para crear un curso
        //Usuario profesorEjemplo = new Usuario("profesor123", "Nombre del Profesor", "Apellido del Profesor");
//        GestorCursos gestorCursos = new GestorCursos();
//        gestorCursos.crearCurso("CSCI101", "Introducción a la Programación", 3, profesorEjemplo);
    }
}
