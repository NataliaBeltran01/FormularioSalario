/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscadorsimple;

import javax.swing.*;
import vista.MainFrame;
/**
 * Clase principal del proyecto la cual es creada por defecto con el proyecto
 * @author Natalia Beltran
 * @version 1.0
 */

public class BuscadorSimple {

 /**
 *Metodo que permite visualizar el JFrame Main Frame
     * @param args
 *@since version 1.0
 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
}
