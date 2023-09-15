/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autenticacion.controladores;

import administracion.modelos.Curso;
import autenticacion.modelos.Usuario;
import autenticacion.modelos.Roles;
import autenticacion.vistas.VentanaAutenticacion;
import java.io.Serializable;
import java.util.ArrayList;

public class GestorUsuarios implements Serializable{
    public static GestorUsuarios instancia;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioLogueado;

    public GestorUsuarios() {
//        usuarios = new ArrayList<>();
//        usuarios.add(new Usuario("admin", "admin", Roles.ADMINISTRADOR, "ADMINISTRADOR", null, null, 'M'));
    }
    
    public static GestorUsuarios getInstancia() {
        if(instancia == null) {
            instancia = new GestorUsuarios();
        }
        return instancia;
    }

    public Usuario autenticar(String codigo, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigo().equals(codigo) && usuario.getContrasena().equals(contrasena)) {
                return usuario; // Autenticación exitosa
            }
        }
        return null; // Autenticación fallida
    }

    public void agregarUsuario(String codigo, String contrasena, String rol, String nombre, String apellido, String correo, char genero) {
        try{
            usuarios.add(new Usuario(codigo, contrasena, rol, nombre, apellido, correo, genero));
        }catch (Exception e){
        }
    }
    
    public void actualizarUsuario(String codigo, String rol, String nombre, String apellido, String correo, char genero) {
        try{
            Usuario profesor = obtenerUsuarioByCodigo(codigo);
            if (profesor != null) {
                profesor.setNombre(nombre);
                profesor.setApellido(apellido);
                profesor.setCorreo(correo);
                profesor.setGenero(genero);
            } else {
            // Manejar el caso en el que no se encuentre el usuario
        }
        }catch (Exception e){
        }
    }
    
    public void actualizarUsuario(String codigo, String rol, String nombre, String apellido, String correo, char genero, String contrasena) {
        try{
            Usuario profesor = obtenerUsuarioByCodigo(codigo);
            if (profesor != null) {
                profesor.setNombre(nombre);
                profesor.setApellido(apellido);
                profesor.setCorreo(correo);
                profesor.setGenero(genero);
                profesor.setContrasena(contrasena);
            } else {
            // Manejar el caso en el que no se encuentre el usuario
        }
        }catch (Exception e){
        }
    }
    
     public Usuario obtenerUsuarioByCodigo(String codigo){
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getCodigo().equals(codigo)) {
                return usuario;
            }
        }
        return null;
    }
     
    public void eliminarUsuario(String codigo) {
        Usuario profesor = obtenerUsuarioByCodigo(codigo);
        if (profesor != null) {
            usuarios.remove(profesor); // Elimina el usuario del ArrayList
        }
    }
    
    public ArrayList<Usuario> getProfesores(){
        ArrayList<Usuario> lstProfesor = new ArrayList<>();
        for (Usuario profesor : usuarios){
            if (profesor != null && profesor.getRol().equals(Roles.PROFESOR)) {
                lstProfesor.add(profesor);
            }
        } 
        return lstProfesor;
    }
    
    public ArrayList<Usuario> getAlumnos(){
        ArrayList<Usuario> lstAlumnos = new ArrayList<>();
        for (Usuario profesor : usuarios){
            if (profesor != null && profesor.getRol().equals(Roles.ALUMNO)) {
                lstAlumnos.add(profesor);
            }
        } 
        return lstAlumnos;
    }
    
    public ArrayList<Usuario> getAlumnosDelCurso(Curso curso) {
        ArrayList<Usuario> alumnosDelCurso = new ArrayList<>();
        for (Usuario alumno : curso.getAlumnos()) {
            if (alumno != null) {
                alumnosDelCurso.add(alumno);
            }
        }
        return alumnosDelCurso;
    }
    
    public boolean existeUsuario(String codigo){
        for (Usuario usuario: usuarios){
            if(usuario != null && usuario.getCodigo().equals(codigo)) return true;
        }
        return false;
    }
    
    public void setUsuarioLogueado(Usuario usuario) {
        usuarioLogueado = usuario;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void cerrarSesion() {
        usuarioLogueado = null;
        new VentanaAutenticacion().setVisible(true);
    }
    
    public void setListaUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

