package Interfaz;

import Otros.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Lenovo
 */
public class VentanitaPrincipal extends JFrame implements ActionListener {

    private final JFrame VentanitaInicial;
    private JButton Cargar, Jugar;
    private ObjetoArchivo objMatrizDiccionario;
    
    public VentanitaPrincipal() {
        VentanitaInicial = new JFrame("Elija una opción.");
        VentanitaInicial.setSize(600, 350);
        VentanitaInicial.setLocationRelativeTo(null);
        VentanitaInicial.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        VentanitaInicial.setLayout(null);
        CrearBotones();
        VentanitaInicial.add(Cargar);
        VentanitaInicial.add(Jugar);
        VentanitaInicial.setVisible(true);
        //initComponents();
        //setLocationRelativeTo(null);
    }

    private void CrearBotones(){
        Cargar = new JButton("Cargar Archivo...");
        Jugar = new JButton("Jugar!");
        Cargar.setBounds(10, 10, 275, 285);
        Jugar.setBounds(295, 10, 275, 285);
        Cargar.setVisible(true);
        Jugar.setVisible(true);
        Cargar.addActionListener(this);
        Jugar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cargar) {
            Archivo nuevoArchivo = new Archivo();
            System.out.println("Cargando...\n\n");
            JFileChooser EscogerArchivo = new JFileChooser();
            EscogerArchivo.setFileFilter(new Filtro("XML"));
            EscogerArchivo.setDialogTitle("Escoja el archivo...");
            EscogerArchivo.setFileSelectionMode(0);
            int opcion = EscogerArchivo.showOpenDialog(EscogerArchivo);
            EscogerArchivo.setVisible(true);
            File archivo = EscogerArchivo.getSelectedFile();
            String Texto = "";
            if (opcion == JFileChooser.APPROVE_OPTION) {
                try {
                    FileReader lector = new FileReader(archivo);
                    BufferedReader lectorCaracter = new BufferedReader(lector);
                    String Linea = lectorCaracter.readLine();
                    while (Linea != null) {
                        Texto += Linea;
                        Linea = lectorCaracter.readLine();
                    }
                } catch (Exception ex) {}
            }
            objMatrizDiccionario = nuevoArchivo.agregarAtributos(Texto);
        } else if (e.getSource() == Jugar) {
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
