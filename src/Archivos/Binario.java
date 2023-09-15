/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import administracion.modelos.Curso;
import autenticacion.modelos.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author dg551
 */
public class Binario {
    String fileNameProfesor;
    String fileNameCurso;
    String fileNameAlumno;
    
    public Binario() {
        this.fileNameProfesor = "D:\\USAC\\4to. SEMESTRE\\IPC1\\LABORATORIO IPC1\\Proyecto1\\files\\Profesores.bin";
        this.fileNameAlumno = "D:\\USAC\\4to. SEMESTRE\\IPC1\\LABORATORIO IPC1\\Proyecto1\\files\\Alumnos.bin";
        this.fileNameCurso = "D:\\USAC\\4to. SEMESTRE\\IPC1\\LABORATORIO IPC1\\Proyecto1\\files\\Cursos.bin";
    }
    
    public boolean guardarProfesores(ArrayList<Usuario> lstUsuario){
        try {
            FileOutputStream fos = new FileOutputStream(fileNameProfesor);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lstUsuario);
            oos.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public ArrayList<Usuario> obtenerProfesores(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            File f = new File(fileNameProfesor);
            if(f.exists()){
                FileInputStream fis = new FileInputStream(fileNameProfesor);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usuarios = (ArrayList<Usuario>) ois.readObject();
                ois.close();
            }
            return usuarios;
        } catch (Exception e){
            return usuarios;
        }
    }
    
    public boolean guardarCursos(ArrayList<Curso> lstCursos){
        try {
            FileOutputStream fos = new FileOutputStream(fileNameCurso);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lstCursos);
            oos.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public ArrayList<Curso> obtenerCursos(){
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        try {
            File f = new File(fileNameCurso);
            if(f.exists()){
                FileInputStream fis = new FileInputStream(fileNameCurso);
                ObjectInputStream ois = new ObjectInputStream(fis);
                cursos = (ArrayList<Curso>) ois.readObject();
                ois.close();
            }
            return cursos;
        } catch (Exception e){
            return cursos;
        }
    }
    
    public boolean guardarAlumnos(ArrayList<Usuario> lstUsuario){
        try {
            FileOutputStream fos = new FileOutputStream(fileNameAlumno);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(lstUsuario);
            oos.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public ArrayList<Usuario> obtenerAlumnos(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            File f = new File(fileNameAlumno);
            if(f.exists()){
                FileInputStream fis = new FileInputStream(fileNameAlumno);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usuarios = (ArrayList<Usuario>) ois.readObject();
                ois.close();
            }
            return usuarios;
        } catch (Exception e){
            return usuarios;
        }
    }
    
}
