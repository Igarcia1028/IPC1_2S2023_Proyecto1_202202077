/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package administracion.vistas;

import Archivos.Binario;
import Archivos.Texto;
import administracion.controladores.GestorCursos;
import administracion.modelos.Curso;
import autenticacion.controladores.GestorUsuarios;
import autenticacion.modelos.Roles;
import autenticacion.modelos.Usuario;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dg551
 */
public class ModuloAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdministrador
     */
    GestorUsuarios gestorUsuario = GestorUsuarios.getInstancia();
    GestorCursos gestorCurso = GestorCursos.getInstancia();
    DefaultTableModel modelProfesor;
    DefaultTableModel modelCurso;
    DefaultTableModel modelAlumno;
    ArrayList<Usuario> listaProfesor = GestorUsuarios.getInstancia().getProfesores();
    ArrayList<Usuario> lstAlumno = GestorUsuarios.getInstancia().getAlumnos();
    ArrayList<Curso> listaCurso = GestorCursos.getInstancia().getCursos();
    Binario binario;
    Texto texto;
    
    public ModuloAdministrador() {
        initComponents();
        setLocationRelativeTo(null);
        this.binario = new Binario();
        this.texto = new Texto();
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        ListarAlumnos(binario.obtenerAlumnos());
        ListarProfesores(binario.obtenerProfesores());
        listaUsuarios.addAll(binario.obtenerAlumnos());
        listaUsuarios.addAll(binario.obtenerProfesores());
        gestorUsuario.setListaUsuarios(listaUsuarios);
        ListarCursos(binario.obtenerCursos());
        gestorCurso.setListaCursos(binario.obtenerCursos());
    }
    
    public void ListarProfesores(ArrayList<Usuario> lstProfesor){
        modelProfesor = (DefaultTableModel)tblProfesores.getModel();
        modelProfesor.setNumRows(0);
        for (int i = 0; i < lstProfesor.size(); i++) {
            Object[] row = new Object[5];
            row[0] = lstProfesor.get(i).getCodigo();
            row[1] = lstProfesor.get(i).getNombre();
            row[2] = lstProfesor.get(i).getApellido();
            row[3] = lstProfesor.get(i).getCorreo();
            row[4] = lstProfesor.get(i).getGenero();
            
            modelProfesor.addRow(row);
        }
        tblProfesores.setModel(modelProfesor);
    }
    
    public void agregarFila(String codigo, String nombre, String apellido, String correo, String genero){
        modelProfesor.addRow(new Object[]{codigo, nombre, apellido, correo, genero});
        tblProfesores.setModel(modelProfesor);
    }
    
    public void ListarAlumnos(ArrayList<Usuario> lstAlumno) {
        modelAlumno = (DefaultTableModel)tblAlumnos.getModel();
        modelAlumno.setNumRows(0);

        for(int i = 0; i < lstAlumno.size(); i ++){
            Object[] row = new Object[5];
            row[0] = lstAlumno.get(i).getCodigo();
            row[1] = lstAlumno.get(i).getNombre();
            row[2] = lstAlumno.get(i).getApellido();
            row[3] = lstAlumno.get(i).getCorreo();
            row[4] = lstAlumno.get(i).getGenero();
            
            modelAlumno.addRow(row);
        }
    }
    
    public void ListarCursos(ArrayList<Curso> lstCurso) {
        modelCurso = (DefaultTableModel)tblCursos.getModel();
        modelCurso.setNumRows(0);
        for(int i = 0; i < lstCurso.size(); i ++){
            Object[] row = new Object[5];
            row[0] = lstCurso.get(i).getCodigo();
            row[1] = lstCurso.get(i).getNombre();
            row[2] = lstCurso.get(i).getCreditos();
            row[3] = lstCurso.get(i).getCantidadAlumnos();
            row[4] = lstCurso.get(i).getProfesor().getNombre() + " " + lstCurso.get(i).getProfesor().getApellido();
            
            modelCurso.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPestañas = new javax.swing.JTabbedPane();
        pnlProfesores = new javax.swing.JPanel();
        btnCargaMasivaProf = new javax.swing.JButton();
        btnEliminarProf = new javax.swing.JButton();
        btnCrearProf = new javax.swing.JButton();
        btnExportarPDFProf = new javax.swing.JButton();
        btnActualizarProf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfesores = new javax.swing.JTable();
        pnlCursos = new javax.swing.JPanel();
        btnCrearCurso = new javax.swing.JButton();
        btnActualizarCurso = new javax.swing.JButton();
        btnEliminarCurso = new javax.swing.JButton();
        btnExportarPDFCurso = new javax.swing.JButton();
        btnCargaMasivaCurso = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCursos = new javax.swing.JTable();
        pnlAlumnos = new javax.swing.JPanel();
        btnExportarPDF = new javax.swing.JButton();
        btnCargaMasivaAlumno = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 400));

        btnCargaMasivaProf.setText("Carga Masiva");
        btnCargaMasivaProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMasivaProfActionPerformed(evt);
            }
        });

        btnEliminarProf.setText("Eliminar");
        btnEliminarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProfActionPerformed(evt);
            }
        });

        btnCrearProf.setText("Crear");
        btnCrearProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProfActionPerformed(evt);
            }
        });

        btnExportarPDFProf.setText("Exportar Listado a PDF");
        btnExportarPDFProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarPDFProfActionPerformed(evt);
            }
        });

        btnActualizarProf.setText("Actualizar");
        btnActualizarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarProfActionPerformed(evt);
            }
        });

        tblProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Apellido", "Correo", "Género"
            }
        ));
        tblProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfesoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblProfesoresMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblProfesores);

        javax.swing.GroupLayout pnlProfesoresLayout = new javax.swing.GroupLayout(pnlProfesores);
        pnlProfesores.setLayout(pnlProfesoresLayout);
        pnlProfesoresLayout.setHorizontalGroup(
            pnlProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfesoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExportarPDFProf, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlProfesoresLayout.createSequentialGroup()
                        .addComponent(btnActualizarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlProfesoresLayout.createSequentialGroup()
                        .addComponent(btnCrearProf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargaMasivaProf, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pnlProfesoresLayout.setVerticalGroup(
            pnlProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfesoresLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlProfesoresLayout.createSequentialGroup()
                        .addGroup(pnlProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCargaMasivaProf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearProf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(btnExportarPDFProf, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPestañas.addTab("Profesores", pnlProfesores);

        btnCrearCurso.setText("Crear");
        btnCrearCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCursoActionPerformed(evt);
            }
        });

        btnActualizarCurso.setText("Actualizar");
        btnActualizarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCursoActionPerformed(evt);
            }
        });

        btnEliminarCurso.setText("Eliminar");
        btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursoActionPerformed(evt);
            }
        });

        btnExportarPDFCurso.setText("Exportar Listado a PDF");

        btnCargaMasivaCurso.setText("Carga Masiva");
        btnCargaMasivaCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMasivaCursoActionPerformed(evt);
            }
        });

        tblCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Créditos", "Alumnos", "Profesor"
            }
        ));
        jScrollPane2.setViewportView(tblCursos);

        javax.swing.GroupLayout pnlCursosLayout = new javax.swing.GroupLayout(pnlCursos);
        pnlCursos.setLayout(pnlCursosLayout);
        pnlCursosLayout.setHorizontalGroup(
            pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCursosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnExportarPDFCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCursosLayout.createSequentialGroup()
                        .addComponent(btnActualizarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCursosLayout.createSequentialGroup()
                        .addComponent(btnCrearCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCargaMasivaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        pnlCursosLayout.setVerticalGroup(
            pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCursosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCursosLayout.createSequentialGroup()
                        .addGroup(pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCargaMasivaCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(btnExportarPDFCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPestañas.addTab("Cursos", pnlCursos);

        btnExportarPDF.setText("Exportar Listado a PDF");

        btnCargaMasivaAlumno.setText("Carga Masiva");
        btnCargaMasivaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMasivaAlumnoActionPerformed(evt);
            }
        });

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Apellido", "Correo", "Género"
            }
        ));
        jScrollPane3.setViewportView(tblAlumnos);

        javax.swing.GroupLayout pnlAlumnosLayout = new javax.swing.GroupLayout(pnlAlumnos);
        pnlAlumnos.setLayout(pnlAlumnosLayout);
        pnlAlumnosLayout.setHorizontalGroup(
            pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAlumnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCargaMasivaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        pnlAlumnosLayout.setVerticalGroup(
            pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAlumnosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAlumnosLayout.createSequentialGroup()
                        .addComponent(btnCargaMasivaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPestañas.addTab("Alumnos", pnlAlumnos);

        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPestañas)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPestañas, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargaMasivaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMasivaAlumnoActionPerformed
        String path = texto.Buscar();
        texto.cargarAlumnos(path, gestorUsuario);
        //ListarProfesores(binario.obtener());
        ListarAlumnos(gestorUsuario.getAlumnos());
        guardarBinarioAlumno();
    }//GEN-LAST:event_btnCargaMasivaAlumnoActionPerformed

    private void btnCrearProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProfActionPerformed
//        this.dispose();
        VentanaCrearProfesor vtnProfesor = new VentanaCrearProfesor();
        vtnProfesor.setVisible(true);
        vtnProfesor.recibirDatos(this);
    }//GEN-LAST:event_btnCrearProfActionPerformed

    private void btnCrearCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCursoActionPerformed
//        this.dispose();
        VentanaCrearCurso vtnCurso = new VentanaCrearCurso();
        vtnCurso.setVisible(true);
        vtnCurso.recibirDatos(this);
    }//GEN-LAST:event_btnCrearCursoActionPerformed

    private void tblProfesoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfesoresMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblProfesoresMouseEntered

    private void tblProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfesoresMouseClicked
       
    }//GEN-LAST:event_tblProfesoresMouseClicked

    private void btnActualizarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarProfActionPerformed
        int selectedRow = tblProfesores.getSelectedRow();
        if (selectedRow >= 0) {
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tblProfesores.getModel();

            // Obtener los valores de la fila seleccionada
            String codigo = model.getValueAt(selectedRow, 0).toString();
            String nombre = model.getValueAt(selectedRow, 1).toString();
            String apellido = model.getValueAt(selectedRow, 2).toString();
            String correo = model.getValueAt(selectedRow, 3).toString();
            String genero = model.getValueAt(selectedRow, 4).toString();
            
            VentanaEditarProfesor ventanaEditarProfesor = new VentanaEditarProfesor();
            ventanaEditarProfesor.setCodigoTextField(codigo);
            ventanaEditarProfesor.setNombreTextField(nombre);
            ventanaEditarProfesor.setApellidoTextField(apellido);
            ventanaEditarProfesor.setCorreoTextField(correo);
            ventanaEditarProfesor.setGeneroTextField(genero);
            ventanaEditarProfesor.setVisible(true);
            ventanaEditarProfesor.recibirDatos(this);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor de la tabla"); 
        }
    }//GEN-LAST:event_btnActualizarProfActionPerformed

    private void btnEliminarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProfActionPerformed
        int selectedRow = tblProfesores.getSelectedRow();
        
        if (selectedRow >= 0){
            int confirm = JOptionPane.showConfirmDialog(rootPane, "¿Desea eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) tblProfesores.getModel();
                gestorUsuario.eliminarUsuario(model.getValueAt(selectedRow, 0).toString());
                ((DefaultTableModel) tblProfesores.getModel()).removeRow(selectedRow);
                guardarBinarioProfesor();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un profesor de la tabla");
        }
    }//GEN-LAST:event_btnEliminarProfActionPerformed

    private void btnActualizarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCursoActionPerformed
        int selectedRow = tblCursos.getSelectedRow();
        if (selectedRow >= 0) {
            // Obtener el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) tblCursos.getModel();

            // Obtener los valores de la fila seleccionada
            String codigo = model.getValueAt(selectedRow, 0).toString();
            String nombre = model.getValueAt(selectedRow, 1).toString();
            String creditos = model.getValueAt(selectedRow, 2).toString();
            String profesor = model.getValueAt(selectedRow, 4).toString();
            
            VentanaEditarCurso ventanaEditarCurso = new VentanaEditarCurso();
            ventanaEditarCurso.setCodigoTextField(codigo);
            ventanaEditarCurso.setNombreTextField(nombre);
            ventanaEditarCurso.setCreditosTextField(Integer.parseInt(creditos));
            ventanaEditarCurso.setProfesorCmb(profesor);
            this.dispose();
            ventanaEditarCurso.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un curso de la tabla"); 
        }
    }//GEN-LAST:event_btnActualizarCursoActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
       int confirmacion = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas cerrar la sesión?",
            "Confirmación de cierre de sesión",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            this.dispose();
            gestorUsuario.cerrarSesion();
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnExportarPDFProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarPDFProfActionPerformed
        ListarProfesores(binario.obtenerProfesores());
    }//GEN-LAST:event_btnExportarPDFProfActionPerformed

    private void btnCargaMasivaProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMasivaProfActionPerformed
        String path = texto.Buscar();
        texto.cargarProfesores(path, gestorUsuario);
        //ListarProfesores(binario.obtener());
        ListarProfesores(gestorUsuario.getProfesores());
        guardarBinarioProfesor();
    }//GEN-LAST:event_btnCargaMasivaProfActionPerformed

    private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
        int selectedRow = tblCursos.getSelectedRow();
        
        if (selectedRow >= 0){
            int confirm = JOptionPane.showConfirmDialog(rootPane, "¿Desea eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) tblCursos.getModel();
                gestorCurso.eliminarCurso(model.getValueAt(selectedRow, 0).toString());
                ((DefaultTableModel) tblCursos.getModel()).removeRow(selectedRow);
                guardarBinarioCurso();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un curso de la tabla");
        }
    }//GEN-LAST:event_btnEliminarCursoActionPerformed

    private void btnCargaMasivaCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMasivaCursoActionPerformed
        String path = texto.Buscar();
        texto.cargarCursos(path, gestorCurso);
        //ListarProfesores(binario.obtener());
        ListarCursos(gestorCurso.getCursos());
        guardarBinarioCurso();
    }//GEN-LAST:event_btnCargaMasivaCursoActionPerformed

    public void setPanel(int tab){
        pnlPestañas.setSelectedIndex(tab);
    }
    
    public void guardarBinarioProfesor(){
        boolean ok = binario.guardarProfesores(gestorUsuario.getProfesores());
        if(ok){
            Mensaje("Se ha guardado los datos");
        } else {
            Mensaje("Error!");
        }
    }
    
    public void guardarBinarioCurso(){
        boolean ok = binario.guardarCursos(gestorCurso.getCursos());
        if(ok){
            Mensaje("Se ha guardado los datos");
        } else {
            Mensaje("Error!");
        }
    }
    
    public void guardarBinarioAlumno(){
        boolean ok = binario.guardarAlumnos(gestorUsuario.getAlumnos());
        if(ok){
            Mensaje("Se ha guardado los datos");
        } else {
            Mensaje("Error!");
        }
    }
    
    public void Mensaje(String msj){
        JOptionPane.showMessageDialog(rootPane, msj);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarCurso;
    private javax.swing.JButton btnActualizarProf;
    private javax.swing.JButton btnCargaMasivaAlumno;
    private javax.swing.JButton btnCargaMasivaCurso;
    private javax.swing.JButton btnCargaMasivaProf;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnCrearCurso;
    private javax.swing.JButton btnCrearProf;
    private javax.swing.JButton btnEliminarCurso;
    private javax.swing.JButton btnEliminarProf;
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JButton btnExportarPDFCurso;
    private javax.swing.JButton btnExportarPDFProf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnlAlumnos;
    private javax.swing.JPanel pnlCursos;
    private javax.swing.JTabbedPane pnlPestañas;
    private javax.swing.JPanel pnlProfesores;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTable tblCursos;
    private javax.swing.JTable tblProfesores;
    // End of variables declaration//GEN-END:variables
}
