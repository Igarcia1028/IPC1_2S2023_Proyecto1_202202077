/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package administracion.vistas;

import Archivos.Binario;
import Archivos.Texto;
import administracion.controladores.GestorCampos;
import administracion.controladores.GestorCursos;
import administracion.modelos.Actividad;
import administracion.modelos.Curso;
import autenticacion.controladores.GestorUsuarios;
import autenticacion.modelos.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dg551
 */
public class VentanaDetalleCurso extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDetalleCurso
     */
    
    Curso cursoActual;
    Texto texto;
    GestorUsuarios gestorUsuario = GestorUsuarios.getInstancia();
    GestorCursos gestorCurso = GestorCursos.getInstancia();
    
    DefaultTableModel modelAlumno;
    DefaultTableModel modelActividad;
    Binario binario;
    
    ModuloProfesor moduloProfesor;

    public VentanaDetalleCurso(Curso curso) {
        initComponents();
        setLocationRelativeTo(null);
        lblNombreCurso.setText(curso.getNombre());
        texto = new Texto();
        binario = new Binario();
        this.cursoActual = curso;
        ListarActividades(gestorCurso.obtenerActividadesDeCurso(cursoActual.getCodigo()));
        ListarAlumnos(gestorCurso.obtenerAlumnosDeCurso(cursoActual.getCodigo()));
        actualizarAcumulado();
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
            modelAlumno.addRow(row);
        }
    }
    
    public void ListarActividades(ArrayList<Actividad> lstActividades) {
        modelActividad = (DefaultTableModel)tblActividades.getModel();
        modelActividad.setNumRows(0);

        for(int i = 0; i < lstActividades.size(); i ++){
            Object[] row = new Object[5];
            row[0] = lstActividades.get(i).getNombre();
            row[1] = lstActividades.get(i).getDescripcion();
            row[2] = lstActividades.get(i).getPonderacion();
            row[3] = 0;
            modelActividad.addRow(row);
        }
    }
    
    public void RecibirPanel (ModuloProfesor vtn){
        moduloProfesor = vtn;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreCurso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlumnos = new javax.swing.JTable();
        btnMejorRendimiento = new javax.swing.JButton();
        lblNombreActividad = new javax.swing.JLabel();
        btnCargaMasivaAlumnos1 = new javax.swing.JButton();
        btnCrearActividad = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblActividades = new javax.swing.JTable();
        txtNombreActividad = new javax.swing.JTextField();
        txtDescripcionActividad = new javax.swing.JTextField();
        txtPonderacionActividad = new javax.swing.JTextField();
        btnPeorRendimiento1 = new javax.swing.JButton();
        lblReportes1 = new javax.swing.JLabel();
        lblDescripcionActividad = new javax.swing.JLabel();
        lblNotas = new javax.swing.JLabel();
        btnSeleccionarNotas = new javax.swing.JButton();
        lblPonderacion = new javax.swing.JLabel();
        lblReportes5 = new javax.swing.JLabel();
        lblAcumuladoCantidad = new javax.swing.JLabel();
        lblReportes2 = new javax.swing.JLabel();
        lblReportes3 = new javax.swing.JLabel();
        lblAcumulado1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        lblNombreCurso.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        tblAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "Correo"
            }
        ));
        tblAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlumnos);

        btnMejorRendimiento.setText("Top 5 - Estudiantes con Mejor Rendimiento");
        btnMejorRendimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMejorRendimientoActionPerformed(evt);
            }
        });

        lblNombreActividad.setText("Nombre");

        btnCargaMasivaAlumnos1.setText("Carga Masiva Alumnos");
        btnCargaMasivaAlumnos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaMasivaAlumnos1ActionPerformed(evt);
            }
        });

        btnCrearActividad.setText("Crear Actividad");
        btnCrearActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActividadActionPerformed(evt);
            }
        });

        tblActividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripción", "Ponderación", "Promedio"
            }
        ));
        jScrollPane2.setViewportView(tblActividades);

        btnPeorRendimiento1.setText("Top 5 - Estudiantes con Peor Rendimiento");
        btnPeorRendimiento1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeorRendimiento1ActionPerformed(evt);
            }
        });

        lblReportes1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReportes1.setText("Reportes");

        lblDescripcionActividad.setText("Descripción");

        lblNotas.setText("Notas");

        btnSeleccionarNotas.setText("Seleccionar archivo CSV");
        btnSeleccionarNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarNotasActionPerformed(evt);
            }
        });

        lblPonderacion.setText("Ponderación");

        lblReportes5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblReportes5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReportes5.setText("Crear Actividad");

        lblReportes2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReportes2.setText("Listado Alumnos");

        lblReportes3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReportes3.setText("Actividades");

        lblAcumulado1.setText("Acumulado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombreCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblReportes1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMejorRendimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addComponent(btnCargaMasivaAlumnos1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnPeorRendimiento1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblReportes2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblPonderacion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPonderacionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSeleccionarNotas, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblDescripcionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDescripcionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lblReportes3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCrearActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(20, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblReportes5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(121, 121, 121))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblAcumulado1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblAcumuladoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(129, 129, 129))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReportes2)
                    .addComponent(lblReportes3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAcumuladoCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAcumulado1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblReportes5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCargaMasivaAlumnos1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblReportes1)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnMejorRendimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPeorRendimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescripcionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPonderacionActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPonderacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSeleccionarNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMejorRendimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMejorRendimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMejorRendimientoActionPerformed

    private void btnCargaMasivaAlumnos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaMasivaAlumnos1ActionPerformed
        String path = texto.Buscar();
        texto.cargarAlumnosDelCurso(path, gestorCurso, cursoActual.getCodigo());
        //ListarProfesores(binario.obtener());
        ListarAlumnos(gestorUsuario.getAlumnosDelCurso(cursoActual));
        moduloProfesor.setCantidadAlumnos(cursoActual.getCantidadAlumnos());
    }//GEN-LAST:event_btnCargaMasivaAlumnos1ActionPerformed

    private void btnCrearActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActividadActionPerformed
        String nombre = txtNombreActividad.getText();
        String descripcion = txtDescripcionActividad.getText();
        Double ponderacion = converToDouble(txtPonderacionActividad.getText());
        String codigoCurso = cursoActual.getCodigo();
        ArrayList<String> campos = new ArrayList<String>();
        campos.add(nombre);
        campos.add(descripcion);
        campos.add(String.valueOf(ponderacion));
        
        if(new GestorCampos().camposVacios(campos)){
            Mensaje("Debe ingresar todos los campos");
        } else if (ponderacion <= 0.0) {
            Mensaje("La ponderación debe ser un valor numérico mayor a cero");
        } else {
            if (cursoActual != null && (gestorCurso.obtenerSumaPonderaciones(gestorCurso.obtenerActividadesDeCurso(codigoCurso)) + ponderacion) <= 100) {
                // Crear una nueva instancia de Actividad
                Actividad actividad = new Actividad(nombre, descripcion, ponderacion);

                // Agregar la actividad al curso actual
                gestorCurso.agregarActividadACurso(codigoCurso, actividad);
                //cursoActual.agregarActividad(actividad);

                // Limpiar los campos del formulario
                txtNombreActividad.setText("");
                txtDescripcionActividad.setText("");
                txtPonderacionActividad.setText("");
                
                System.out.println("Cantidad de actividades: " + cursoActual.getActividades().size());
                ListarActividades(gestorCurso.obtenerActividadesDeCurso(codigoCurso));
                guardarBinarioCurso();
                actualizarAcumulado();
                // Mensaje de éxito
                //Mensaje("Actividad creada con éxito");
            } else {
                Mensaje("La suma de ponderaciones excede 100%");
            }
        }
    }//GEN-LAST:event_btnCrearActividadActionPerformed

    public Double converToDouble(String value){
        try{
            double valorConvertido;
            return valorConvertido = Double.parseDouble(value);
        }catch(Exception e){
             return -1.0;
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
    
    public void actualizarAcumulado(){
        Double sumaPonderacion = gestorCurso.obtenerSumaPonderaciones(gestorCurso.obtenerActividadesDeCurso(cursoActual.getCodigo()));
        lblAcumuladoCantidad.setText(sumaPonderacion+"/100");
    }
    
    private void btnPeorRendimiento1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeorRendimiento1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPeorRendimiento1ActionPerformed

    private void btnSeleccionarNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarNotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarNotasActionPerformed

    private void tblAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlumnosMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblAlumnos.getModel();
        int selectedRow = tblAlumnos.getSelectedRow();
        
        Usuario profesor = gestorUsuario.obtenerUsuarioByCodigo(model.getValueAt(selectedRow, 0).toString());
        VentanaMasInformacionEstudiante vtnActualizar = new VentanaMasInformacionEstudiante();
        vtnActualizar.llenarTextField(profesor.getCodigo(), profesor.getNombre(), profesor.getApellido(),
            profesor.getCorreo(), String.valueOf(profesor.getGenero()), profesor.getContrasena(), profesor, cursoActual);
        vtnActualizar.RecibirPaneles(this, moduloProfesor);
        vtnActualizar.setVisible(true);
    }//GEN-LAST:event_tblAlumnosMouseClicked

    public void Mensaje(String msj){
        JOptionPane.showMessageDialog(null, msj);
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
            java.util.logging.Logger.getLogger(VentanaDetalleCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaDetalleCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaDetalleCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaDetalleCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaDetalleCurso().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargaMasivaAlumnos1;
    private javax.swing.JButton btnCrearActividad;
    private javax.swing.JButton btnMejorRendimiento;
    private javax.swing.JButton btnPeorRendimiento1;
    private javax.swing.JButton btnSeleccionarNotas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAcumulado1;
    private javax.swing.JLabel lblAcumuladoCantidad;
    private javax.swing.JLabel lblDescripcionActividad;
    private javax.swing.JLabel lblNombreActividad;
    private javax.swing.JLabel lblNombreCurso;
    private javax.swing.JLabel lblNotas;
    private javax.swing.JLabel lblPonderacion;
    private javax.swing.JLabel lblReportes1;
    private javax.swing.JLabel lblReportes2;
    private javax.swing.JLabel lblReportes3;
    private javax.swing.JLabel lblReportes5;
    private javax.swing.JTable tblActividades;
    private javax.swing.JTable tblAlumnos;
    private javax.swing.JTextField txtDescripcionActividad;
    private javax.swing.JTextField txtNombreActividad;
    private javax.swing.JTextField txtPonderacionActividad;
    // End of variables declaration//GEN-END:variables

}
