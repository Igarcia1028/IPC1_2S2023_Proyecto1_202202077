/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package administracion.vistas;

import administracion.controladores.GestorCursos;
import administracion.modelos.Curso;
import autenticacion.controladores.GestorUsuarios;
import autenticacion.modelos.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dg551
 */
public class ModuloEstudiante extends javax.swing.JFrame {

    /**
     * Creates new form ModuloEstudiante
     */
    
    private JButton btnActualizarDatos;
    private JButton btnCerrarSesion;
    GestorUsuarios gestorUsuarios = GestorUsuarios.getInstancia();
    GestorCursos gestorCursos = GestorCursos.getInstancia();
    
    public ModuloEstudiante() {
        setTitle("Cursos del Profesor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        btnActualizarDatos = new JButton("Actualizar Datos");
        btnActualizarDatos.addActionListener(e -> btnActualizarDatosActionPerformed(e));

        btnCerrarSesion = new JButton("Cerrar Sesión");
        btnCerrarSesion.addActionListener(e -> btnCerrarSesionActionPerformed(e));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(btnActualizarDatos);
        buttonsPanel.add(btnCerrarSesion);

        getContentPane().add(buttonsPanel, BorderLayout.NORTH);
        setLocationRelativeTo(null);
    }
    
    public void recibirUsuarioLogueado(Usuario alumnoLogueado) {
         // Obtener la lista de cursos del profesor
        ArrayList<Curso> cursosDelAlumno = obtenerCursosDelAlumno(alumnoLogueado);

        System.out.println("Cursos: " + cursosDelAlumno.size());

        // Crear un panel para mostrar los mosaicos de cursos
        JPanel mosaicosPanel = new JPanel();

        // Configura un FlowLayout para colocar los mosaicos uno al lado del otro
        mosaicosPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // 10 es el espacio horizontal y vertical entre mosaicos

        // Crear y agregar mosaicos para cada curso
        for (Curso curso : cursosDelAlumno) {
            JPanel cursoPanel = crearMosaicoCurso(curso);
            // Establece un tamaño fijo de 200x100 para los mosaicos
            cursoPanel.setPreferredSize(new Dimension(200, 100));
            mosaicosPanel.add(cursoPanel);
        }

        // Agregar el panel de mosaicos al contenido principal de la ventana
        getContentPane().add(mosaicosPanel);
    }
    
    private JPanel crearMosaicoCurso(Curso curso) {
        JPanel mosaico = new JPanel();
        mosaico.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borde para resaltar el mosaico

        // Genera un color aleatorio pastel claro
        Random rand = new Random();
        int red = rand.nextInt(191) + 64;   // Rango de 64 a 255 para un color pastel claro
        int green = rand.nextInt(191) + 64; // Rango de 64 a 255 para un color pastel claro
        int blue = rand.nextInt(191) + 64;  // Rango de 64 a 255 para un color pastel claro
        Color randomColor = new Color(red, green, blue);

        // Aplica el color aleatorio al fondo del mosaico
        mosaico.setBackground(randomColor);

        // Establece un diseño BorderLayout para el mosaico
        mosaico.setLayout(new BorderLayout());

        // Personaliza el contenido del mosaico según tus necesidades
        JLabel nombreCursoLabel = new JLabel(curso.getNombre());
        nombreCursoLabel.setHorizontalAlignment(JLabel.CENTER); // Centra el texto horizontalmente
        nombreCursoLabel.setFont(nombreCursoLabel.getFont().deriveFont(16.0f)); // Cambia el tamaño de la fuente

        JLabel profesorLabel = new JLabel(curso.getProfesor().getNombre() + " " + curso.getProfesor().getApellido());
        profesorLabel.setHorizontalAlignment(JLabel.CENTER); // Centra el texto horizontalmente
        profesorLabel.setFont(profesorLabel.getFont().deriveFont(12.0f)); // Cambia el tamaño de la fuente

          // Agrega un evento de clic al mosaico
            mosaico.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Al hacer clic en el mosaico, abre la nueva ventana de detalle del curso
                    //abrirVentanaDetalleCurso(curso.getCodigo());
                }
            });
        // Agrega los componentes al mosaico
        mosaico.add(nombreCursoLabel, BorderLayout.CENTER); // Nombre centrado en el centro
        mosaico.add(profesorLabel, BorderLayout.SOUTH); // Créditos en la parte inferior

        return mosaico;
    }

    private ArrayList<Curso> obtenerCursosDelAlumno(Usuario alumno) {
         ArrayList<Curso> cursos = gestorCursos.getCursosDelAlumno(alumno);
         return cursos;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ModuloEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModuloEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModuloEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModuloEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModuloEstudiante().setVisible(true);
            }
        });
    }
    
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {                                                
        int confirmacion = JOptionPane.showConfirmDialog(
            null,
            "¿Estás seguro de que deseas cerrar la sesión?",
            "Confirmación de cierre de sesión",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            this.dispose();
            gestorUsuarios.cerrarSesion();
        }
    }                                               

    private void btnActualizarDatosActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        Usuario profesor = gestorUsuarios.obtenerUsuarioByCodigo(gestorUsuarios.getUsuarioLogueado().getCodigo());
        VentanaActualizarDatosProfesor vtnActualizar = new VentanaActualizarDatosProfesor();
        vtnActualizar.llenarTextField(profesor.getCodigo(), profesor.getNombre(), profesor.getApellido(),
            profesor.getCorreo(), String.valueOf(profesor.getGenero()), profesor.getContrasena());
        vtnActualizar.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
