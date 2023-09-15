/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administracion.controladores;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author dg551
 */
public class GestorCampos {
    
    public boolean camposVacios(ArrayList<String> arrCampos){
        for(String text : arrCampos){
            if(text == null || text.equals("")) return true;
        }
        return false;
    }
    
    public static int validarEntradaNumerica(String input) {
       try {
            int number = Integer.parseInt(input);
            return number;
       }
       catch (NumberFormatException e) {
            //Not an integer
            return -1;
       }
    }
}
