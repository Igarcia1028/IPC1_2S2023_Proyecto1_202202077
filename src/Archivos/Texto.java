/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import administracion.controladores.GestorCursos;
import administracion.controladores.GestorNotas;
import administracion.modelos.Actividad;
import administracion.modelos.Nota;
import administracion.modelos.Curso;
import autenticacion.controladores.GestorUsuarios;
import autenticacion.modelos.Roles;
import autenticacion.modelos.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dg551
 */
public class Texto {

    GestorUsuarios gestorUsuario = GestorUsuarios.getInstancia();
    GestorNotas gestorNota = GestorNotas.getInstancia();

    public Texto() {
    }
    
    public String Buscar() {
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos txt", "txt");
        jfc.setFileFilter(filtro);
        
        int resp = jfc.showOpenDialog(jfc);
        
        if(resp == JFileChooser.APPROVE_OPTION){
            return jfc.getSelectedFile().getPath();
        }
        
        return "";
    }
    
    public void cargarProfesores(String path, GestorUsuarios usuario){
        try {
            FileReader fr = new FileReader (path);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            String contenido= "";
            
            while((linea=br.readLine()) != null) {
                contenido += linea+"\n";
            }
            
            br.close();
            fr.close();
            System.out.println(contenido);
            cargarDatosProfesores(contenido, usuario);
        } catch (Exception e) {
        
        }
    }
    
    private void cargarDatosProfesores(String contenido, GestorUsuarios usuario){
        String [] listado = contenido.split("\n");
        int cant = listado.length;
        String codigo;
        String nombre;
        String apellido;
        String correo;
        String contrasena = "1234";
        char genero;
        String rol = Roles.PROFESOR;

        
        for (int i = 0; i < cant; i++) {
            System.out.println(listado[i]);
            String [] valores = listado[i].split(",");
            
            codigo = valores[0];
            nombre = valores[1];
            apellido = valores[2];
            correo = valores[3];
            genero = valores[4].toUpperCase().charAt(0);

            usuario.agregarUsuario(codigo, contrasena, rol, nombre, apellido, correo, genero);
        }
    }
    
     public void cargarCursos(String path, GestorCursos curso){
        try {
            FileReader fr = new FileReader (path);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            String contenido= "";
            
            while((linea=br.readLine()) != null) {
                contenido += linea+"\n";
            }
            
            br.close();
            fr.close();
            System.out.println(contenido);
            cargarDatosCursos(contenido, curso);
        } catch (Exception e) {
        
        }
    }
    
    private void cargarDatosCursos(String contenido, GestorCursos curso){
        String [] listado = contenido.split("\n");
        int cant = listado.length;
        String codigo;
        String nombre;
        int creditos;
        String codProfesor;
        Usuario profesor;
        
        for (int i = 0; i < cant; i++) {
            System.out.println(listado[i]);
            String [] valores = listado[i].split(",");
            
            codigo = valores[0];
            nombre = valores[1];
            creditos = convertNum(valores[2]);
            codProfesor = valores[3];
            
            profesor = gestorUsuario.obtenerUsuarioByCodigo(codProfesor);
            
            if(profesor == null){
                JOptionPane.showMessageDialog(null, "Profesor "+ codProfesor +" no encontrado");
            }else {
                curso.crearCurso(codigo, nombre, creditos, profesor);
            }
        }
    }
    
    public void cargarAlumnos(String path, GestorUsuarios usuario){
        try {
            FileReader fr = new FileReader (path);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            String contenido= "";
            
            while((linea=br.readLine()) != null) {
                contenido += linea+"\n";
            }
            
            br.close();
            fr.close();
            System.out.println(contenido);
            cargarDatosAlumnos(contenido, usuario);
        } catch (Exception e) {
        
        }
    }
    
    private void cargarDatosAlumnos(String contenido, GestorUsuarios usuario){
        String [] listado = contenido.split("\n");
        int cant = listado.length;
        String codigo;
        String nombre;
        String apellido;
        String correo;
        String contrasena = "1234";
        char genero;
        String rol = Roles.ALUMNO;

        
        for (int i = 0; i < cant; i++) {
            System.out.println(listado[i]);
            String [] valores = listado[i].split(",");
            
            codigo = valores[0];
            nombre = valores[1];
            apellido = valores[2];
            correo = valores[3];
            genero = valores[4].toUpperCase().charAt(0);

            usuario.agregarUsuario(codigo, contrasena, rol, nombre, apellido, correo, genero);
        }
    }
    
     public void cargarAlumnosDelCurso(String path, GestorCursos curso, String codCurso){
        try {
            FileReader fr = new FileReader (path);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            String contenido= "";
            
            while((linea=br.readLine()) != null) {
                contenido += linea+"\n";
            }
            
            br.close();
            fr.close();
            System.out.println(contenido);
            cargarDatosAlumnosDelCurso(contenido, curso, codCurso);
        } catch (Exception e) {
        
        }
    }
    
    private void cargarDatosAlumnosDelCurso(String contenido, GestorCursos curso, String codCurso){
        String [] listado = contenido.split("\n");
        int cant = listado.length;
        String codigo;
        Usuario alumnoObtenido; 
        
        for (int i = 0; i < cant; i++) {
            System.out.println(listado[i]);
            String [] valores = listado[i].split(",");
            
            codigo = valores[0];
            alumnoObtenido = gestorUsuario.obtenerUsuarioByCodigo(codigo);
            curso.agregaAlumno(codCurso, alumnoObtenido);
        }
    }
    
    
    public void cargarNotasAlumno(String path, GestorCursos gestorCurso, Curso curso, Actividad actividad){
        try {
            FileReader fr = new FileReader (path);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = "";
            String contenido= "";
            
            while((linea=br.readLine()) != null) {
                contenido += linea+"\n";
            }
            
            br.close();
            fr.close();
            System.out.println(contenido);
            cargarDatosNotasAlumno(contenido, gestorCurso, curso, actividad);
        } catch (Exception e) {
        
        }
    }
//    
    private void cargarDatosNotasAlumno(String contenido, GestorCursos gestorCurso, Curso curso, Actividad actividad){
        String [] listado = contenido.split("\n");
        int cant = listado.length;
        String codigo;
        Double punteo;
        Usuario alumnoObtenido; 
        Nota notaCreada;
        
        for (int i = 0; i < cant; i++) {
            System.out.println(listado[i]);
            String [] valores = listado[i].split(",");
            
            codigo = valores[0];
            punteo = convertDouble(valores[1]);
            
            alumnoObtenido = gestorUsuario.obtenerUsuarioByCodigo(codigo);
            notaCreada = gestorNota.crearNota(actividad, punteo, alumnoObtenido);
            gestorCurso.agregarNotaACurso(curso.getCodigo(), notaCreada);
        }
    }
    
    public int convertNum(String val){
        try {
            return Integer.parseInt(val);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Solo se admiten valores numéricos");
            return -1;
        }
    }
    
    public Double convertDouble(String val){
        try {
            return Double.parseDouble(val);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Solo se admiten valores numéricos");
            return -1.0;
        }
    }
}
