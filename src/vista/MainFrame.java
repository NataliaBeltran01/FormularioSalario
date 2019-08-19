/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import controlador.CustomListModel;
import modelo.Person;
/**
 * Clase MainFrame desde donde estan alojada la vista del proyecto 
 * @author Natalia Beltran
 * @version 1.0
 */
public class MainFrame extends JFrame {
 /**
 * Estos son los botones del Jframe 
 * @since version 1.0
 */
    protected JButton buttonAdd = new JButton("Añadir Nueva Persona");
    protected JButton buttonSearch = new JButton("Buscar Personas");
    protected JButton buttonSort = new JButton("Ordenar Personas");
 /**
 * Estas son las listas de los botones del Jframe 
 * @since version 1.0
 */
    protected JList<Person> listPerson = new JList<>();
    protected CustomListModel<Person> listModel;
    protected java.util.List<Person> persons = new ArrayList<>();
 
 /**
 * Este metodo muestra y ejecuta las caracteristicas basicas del programa 
 * @since version 1.0
 */
    public MainFrame() {
 
        super("Busqueda Simple");
 
        initComponents();
        iniciarComponentes();
 
        setSize(600, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
/**
 * Este metodo inicializa los componentes puestos en el JFrame 
 * @since version 1.0
 */
    protected void iniciarComponentes() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
 
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addPerson();
            }
        });
 
        buttonSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                sortPersons();
            }
        });
 
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                searchPersons();
            }
        });
 
        panelButton.add(buttonAdd);
        panelButton.add(buttonSearch);
        panelButton.add(buttonSort);
 
        add(panelButton);
 
        listPerson.setPreferredSize(new Dimension(400, 360));
 
        listModel = new CustomListModel<>(persons);
        listPerson.setModel(listModel);
 
        listModel.addElement(new Person("Natalia Beltrán"));
 
        add(listPerson);
    }
 /**
 * Este metodo añade nombres nuevos a la lista 
 * @since version 1.0
 */
    private void addPerson() {
        String personName = JOptionPane.showInputDialog(this, "Ingresar Nombre");
        if (personName != null) {
            listModel.addElement(new Person(personName));
        }
    }
 /**
 * Este metodo busca nombres en la lista 
 * @since version 1.0
 */
    private void sortPersons() {
        Collections.sort(persons);
        listModel.fireDataChanged();
    }
 /**
 * Este metodo busca nombres en la lista 
 * @since version 1.0
 */
    private void searchPersons() {
        String personName = JOptionPane.showInputDialog(this, "Ingresar Nombre o Buscar Por:");
 
        if (personName == null) {
            return;
        }
 
        Collections.sort(persons);
 
        int foundIndex = Collections.binarySearch(persons, new Person(personName));
 
        if (foundIndex >= 0) {
            listPerson.setSelectedIndex(foundIndex);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha encontrado a la persona " + personName);
        }
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables