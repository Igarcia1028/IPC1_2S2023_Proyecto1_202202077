/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion.modelos;

import autenticacion.controladores.GestorUsuarios;
import autenticacion.modelos.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dg551
 */
public class Curso implements Serializable {
    private String codigo;
    private String nombre;
    private int creditos;
    private ArrayList<Usuario> alumnos;
    private Usuario profesor;
    private ArrayList<Actividad> actividades;
    private ArrayList<Nota> notas;
    
    public Curso(String codigo, String nombre, int creditos, ArrayList<Usuario> alumnos, Usuario profesor, ArrayList<Actividad> actividades, ArrayList<Nota> notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.alumnos = alumnos;
        this.profesor = profesor;
        this.actividades = actividades;
        this.notas = notas;
    }

    public Curso() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getCantidadAlumnos() {
        return alumnos.size();
    }
    
    public ArrayList<Usuario> getAlumnos(){
        return alumnos;
    }

    public void setAlumnos(ArrayList<Usuario> alumnos) {
        this.alumnos = alumnos;
    }
    
    public void setAlumno(Usuario alumno ){
        this.alumnos.add(alumno);
    }

    public Usuario getProfesor() {
        return profesor;
    }

    public void setProfesor(Usuario profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividad> actividades) {
        this.actividades = actividades;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
    
    // Métodos para agregar actividades y notas
    public void agregarActividad(Actividad actividad) {
        actividades.add(actividad);
    }

    public void agregarNota(Nota nota) {
        notas.add(nota);
    }
    
    public void eliminarAlumno(Usuario alumno) {
       alumnos.remove(alumno);
    }
}
