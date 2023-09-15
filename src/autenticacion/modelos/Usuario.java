/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autenticacion.modelos;

import java.io.Serializable;

/**
 *
 * @author dg551
 */
public class Usuario implements Serializable{
    private String codigo;
    private String contrasena;
    private String rol;
    private String nombre;
    private String apellido;
    private String correo;
    private char genero;
    
    public Usuario(String codigo, String contrasena, String rol, String nombre, String apellido, String correo, char genero){
        this.codigo = codigo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.genero = genero;
    }
    
    public Usuario(){
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public char getGenero() {
        return genero;
    }
    
    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString() {
        return nombre; // Esto determina cómo se mostrará el nombre en el JComboBox.
    }
}
