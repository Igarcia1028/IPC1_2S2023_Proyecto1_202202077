/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion.modelos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author dg551
 */
public class Actividad implements Serializable{
   private static int contadorCodigo = 0; // Variable estática para llevar el registro del último código asignado
    private String nombre;
    private String descripcion;
    private double ponderacion;
    private double nota;
    private String codigo;

    public Actividad(String nombre, String descripcion, double ponderacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ponderacion = ponderacion;
        this.nota = 0.0;
        this.codigo = generarCodigoUnico();
    }

    // Método privado para generar un código único autoincrementable
    private String generarCodigoUnico() {
        contadorCodigo++;
        return "ACT_" + contadorCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(double ponderacion) {
        this.ponderacion = ponderacion;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
}
