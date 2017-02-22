package Interfaz;

import Otros.*;
import javax.swing.*;
import Estructuras.*;
import java.awt.event.*;
import java.io.*;

/**
 *
 * @author Lenovo
 */
public class VentanitaPrincipal extends JFrame implements ActionListener {

    private final JFrame VentanitaInicial;
    private JButton Cargar, Jugar;
    private Matriz Matriz;
    private Cola Fichas;
    private ListaDiccionario Diccionario;
    private ListaCircular Jugadores;
    private int TotalJugadores;
    
    public VentanitaPrincipal() {
        VentanitaInicial = new JFrame("Elija una opción.");
        VentanitaInicial.setSize(600, 300);
        VentanitaInicial.setLocationRelativeTo(null);
        VentanitaInicial.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        VentanitaInicial.setLayout(null);
        CrearBotones();
        VentanitaInicial.add(Cargar);
        VentanitaInicial.add(Jugar);
        VentanitaInicial.setVisible(true);
        Matriz = null;
        Fichas = null;
        Diccionario = null;
        TotalJugadores = 0;
    }

    private void CrearBotones(){
        Jugar = new JButton("Jugar!");
        Cargar = new JButton("Cargar Archivo...");
        Jugar.setBounds(320, 10, 225, 235);
        Cargar.setBounds(35, 10, 225, 235);
        Jugar.setVisible(true);
        Cargar.setVisible(true);
        Jugar.addActionListener(this);
        Cargar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cargar) {
            ObjetoArchivo MatDicCol;
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
            MatDicCol = nuevoArchivo.agregarAtributos(Texto);
            if(MatDicCol != null){
                Matriz = MatDicCol.getLogica();
                Diccionario = MatDicCol.getPalabras();
                Fichas = MatDicCol.getBolsa();
                Jugadores = new ListaCircular(Fichas);
                Matriz.Graficar();
                Diccionario.Graficar();
                Fichas.Graficar();
            }
        } else if (e.getSource() == Jugar) {
            if(Matriz == null){
                JOptionPane.showMessageDialog(rootPane, "Para poder jugar, primero debe cargar un archivo.");
            }else{
                VentanitaInicial.setVisible(false);
                initComponents();
                setLocationRelativeTo(null);
                setVisible(true);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INGRESO DE JUGADORES");

        jLabel2.setText("Nombre de usuario:");

        btnAgregar.setText("Agregar jugador");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnSiguiente.setText(">");
        btnSiguiente.setEnabled(false);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(241, 241, 241))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSiguiente)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(txtNombre.getText().length() > 0){
            if(Jugadores.Insertar(txtNombre.getText())){
                TotalJugadores++;
                txtNombre.setText("");
                Jugadores.Inicial.getFichas().Graficar();
                Jugadores.Graficar();
            }else{
                JOptionPane.showMessageDialog(rootPane, "El nombre de usuario ya existe.");
            }
            if(2 <= TotalJugadores || TotalJugadores < 13){
                btnSiguiente.setEnabled(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ingrese un nombre primero.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        Tablero nuevoTablero = new Tablero(Matriz, Jugadores, Fichas, Diccionario);
        nuevoTablero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSiguienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
