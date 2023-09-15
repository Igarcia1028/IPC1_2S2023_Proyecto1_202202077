/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion.modelos;

import autenticacion.modelos.Usuario;
import java.io.Serializable;

/**
 *
 * @author dg551
 */
public class Nota implements Serializable{
    private Usuario alumno;
    private Actividad actividad;
    private double nota;

    public Nota(Usuario alumno, Actividad actividad, double nota) {
        this.alumno = alumno;
        this.actividad = actividad;
        this.nota = nota;
    }

    public Usuario getAlumno() {
        return alumno;
    }

    public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
