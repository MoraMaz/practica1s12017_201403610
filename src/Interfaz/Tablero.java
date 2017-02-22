package Interfaz;

import java.awt.*;
import javax.swing.*;
import Estructuras.*;
import java.awt.event.*;
import java.util.logging.*;

/**
 *
 * @author Lenovo
 */
public class Tablero extends JFrame implements ActionListener {
    
    private final ListaDiccionario Diccionario;
    private final ListaCircular Jugadores;
    private final JButton[][] Tablero;
    private NodoCircular JActual;
    private final Matriz Matriz;
    private final Cola Fichas;
    public Thread Graficando;
    
    public Tablero(Matriz Matriz, ListaCircular Jugadores, Cola Fichas, ListaDiccionario Diccionario) {
        initComponents();
        this.Tablero = new JButton[Matriz.getDimension()][Matriz.getDimension()];
        this.lblJugador.setText(Jugadores.Inicial.getNombre());
        this.JActual = Jugadores.Inicial;
        this.Diccionario = Diccionario;
        this.Jugadores = Jugadores;
        this.CrearMatriz(Matriz);
        this.Fichas = Fichas;
        this.Matriz = Matriz;
        this.Graficar();
    }
    
    private void EstablecerImagenes(){
        ImageIcon Establecida;
        Diccionario.Graficar();
        Establecida = new ImageIcon((new ImageIcon("src/Reportes/LD.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
        imgDiccionario.setIcon(Establecida);
        imgDiccionario.repaint();
        spanDiccionario.repaint();
        JActual.getFichas().Graficar();
        Establecida = new ImageIcon((new ImageIcon("src/Reportes/LS.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
        imgLista.setIcon(Establecida);
        imgLista.repaint();
        spanListaSimple.repaint();
        Fichas.Graficar();
        Establecida = new ImageIcon((new ImageIcon("src/Reportes/C.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
        imgCola.setIcon(Establecida);
        imgCola.repaint();
        spanCola.repaint();
        Jugadores.Graficar();
        Establecida = new ImageIcon((new ImageIcon("src/Reportes/LC.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
        imgJugadores.setIcon(Establecida);
        imgJugadores.repaint();
        spanJugadores.repaint();
        Matriz.Graficar();
        Establecida = new ImageIcon((new ImageIcon("src/Reportes/M.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
        imgMatriz.setIcon(Establecida);
        imgMatriz.repaint();
        spanCola.repaint();
        repaint();
    }
    
    private void CrearMatriz(Matriz matriz){
        int tamano = panMatriz.getWidth() / (matriz.getDimension() + 1);
        for (int j = 0; j < matriz.getDimension(); j++) {
            for (int i = 0; i < matriz.getDimension(); i++) {
                Tablero[i][j] = new JButton("            " + matriz.Buscar(i, j).getBonus());
                Tablero[i][j].setMargin(new Insets(1,1,1,1));
                Tablero[i][j].addActionListener(this);
                Tablero[i][j].setBounds(i * tamano, j * tamano, tamano, tamano);
                panMatriz.add(Tablero[i][j]);
            }
        }
        ActualizarLetras();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMatriz = new javax.swing.JPanel();
        panTurnos = new javax.swing.JPanel();
        lblTurno = new javax.swing.JLabel();
        lblJugador = new javax.swing.JLabel();
        panNuevaPalabra = new javax.swing.JPanel();
        lblNuevaPalabra = new javax.swing.JLabel();
        txtPalabraNueva = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        panPuntuaciones = new javax.swing.JPanel();
        lblPuntuaciones = new javax.swing.JLabel();
        panCambiar = new javax.swing.JPanel();
        lblCambiar = new javax.swing.JLabel();
        panLetras = new javax.swing.JPanel();
        btnLetra1 = new javax.swing.JButton();
        btnLetra2 = new javax.swing.JButton();
        btnLetra3 = new javax.swing.JButton();
        btnLetra4 = new javax.swing.JButton();
        btnLetra5 = new javax.swing.JButton();
        btnLetra6 = new javax.swing.JButton();
        btnLetra7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        panReportes = new javax.swing.JPanel();
        tabReportes = new javax.swing.JTabbedPane();
        spanDiccionario = new javax.swing.JScrollPane();
        imgDiccionario = new javax.swing.JLabel();
        spanCola = new javax.swing.JScrollPane();
        imgCola = new javax.swing.JLabel();
        spanListaSimple = new javax.swing.JScrollPane();
        imgLista = new javax.swing.JLabel();
        spanMatriz = new javax.swing.JScrollPane();
        imgMatriz = new javax.swing.JLabel();
        spanJugadores = new javax.swing.JScrollPane();
        imgJugadores = new javax.swing.JLabel();
        lblReportes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panMatrizLayout = new javax.swing.GroupLayout(panMatriz);
        panMatriz.setLayout(panMatrizLayout);
        panMatrizLayout.setHorizontalGroup(
            panMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        panMatrizLayout.setVerticalGroup(
            panMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
        );

        panTurnos.setMinimumSize(new java.awt.Dimension(125, 0));

        lblTurno.setText("Turno:");

        lblJugador.setText("jLabel2");

        javax.swing.GroupLayout panTurnosLayout = new javax.swing.GroupLayout(panTurnos);
        panTurnos.setLayout(panTurnosLayout);
        panTurnosLayout.setHorizontalGroup(
            panTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panTurnosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panTurnosLayout.createSequentialGroup()
                        .addComponent(lblTurno)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panTurnosLayout.setVerticalGroup(
            panTurnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTurnosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panNuevaPalabra.setMinimumSize(new java.awt.Dimension(125, 125));

        lblNuevaPalabra.setText("Nueva Palabra:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panNuevaPalabraLayout = new javax.swing.GroupLayout(panNuevaPalabra);
        panNuevaPalabra.setLayout(panNuevaPalabraLayout);
        panNuevaPalabraLayout.setHorizontalGroup(
            panNuevaPalabraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panNuevaPalabraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panNuevaPalabraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panNuevaPalabraLayout.createSequentialGroup()
                        .addComponent(lblNuevaPalabra)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtPalabraNueva))
                .addContainerGap())
            .addGroup(panNuevaPalabraLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnAgregar)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panNuevaPalabraLayout.setVerticalGroup(
            panNuevaPalabraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panNuevaPalabraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNuevaPalabra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPalabraNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblPuntuaciones.setText("Puntuaciones:");

        javax.swing.GroupLayout panPuntuacionesLayout = new javax.swing.GroupLayout(panPuntuaciones);
        panPuntuaciones.setLayout(panPuntuacionesLayout);
        panPuntuacionesLayout.setHorizontalGroup(
            panPuntuacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPuntuacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPuntuaciones)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panPuntuacionesLayout.setVerticalGroup(
            panPuntuacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPuntuacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPuntuaciones)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        panCambiar.setMinimumSize(new java.awt.Dimension(125, 125));

        lblCambiar.setText("Cambiar Letras:");

        javax.swing.GroupLayout panCambiarLayout = new javax.swing.GroupLayout(panCambiar);
        panCambiar.setLayout(panCambiarLayout);
        panCambiarLayout.setHorizontalGroup(
            panCambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCambiarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCambiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panCambiarLayout.setVerticalGroup(
            panCambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panCambiarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCambiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnLetra1.setText("L1");

        btnLetra2.setText("L2");

        btnLetra3.setText("L3");

        btnLetra4.setText("L4");

        btnLetra5.setText("L5");

        btnLetra6.setText("L6");

        btnLetra7.setText("L7");

        jButton2.setText("Cancelar tiro");

        jButton1.setText("Validar tiro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panLetrasLayout = new javax.swing.GroupLayout(panLetras);
        panLetras.setLayout(panLetrasLayout);
        panLetrasLayout.setHorizontalGroup(
            panLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLetrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLetra1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panLetrasLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panLetrasLayout.createSequentialGroup()
                        .addComponent(btnLetra2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetra3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetra4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetra5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetra6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLetra7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panLetrasLayout.setVerticalGroup(
            panLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLetrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLetra1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLetra2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLetra3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLetra4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLetra5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLetra6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLetra7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addContainerGap())
        );

        spanDiccionario.setViewportView(imgDiccionario);

        tabReportes.addTab("Diccionario de palabras", spanDiccionario);

        spanCola.setViewportView(imgCola);

        tabReportes.addTab("Cola de fichas", spanCola);

        spanListaSimple.setViewportView(imgLista);

        tabReportes.addTab("Fichas activas del jugador", spanListaSimple);

        spanMatriz.setViewportView(imgMatriz);

        tabReportes.addTab("Matriz", spanMatriz);

        spanJugadores.setViewportView(imgJugadores);

        tabReportes.addTab("Jugadores", spanJugadores);

        lblReportes.setText("Área de Reportes");

        javax.swing.GroupLayout panReportesLayout = new javax.swing.GroupLayout(panReportes);
        panReportes.setLayout(panReportesLayout);
        panReportesLayout.setHorizontalGroup(
            panReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabReportes, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addGroup(panReportesLayout.createSequentialGroup()
                        .addComponent(lblReportes)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panReportesLayout.setVerticalGroup(
            panReportesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panReportesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReportes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabReportes)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panMatriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panPuntuaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panNuevaPalabra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panLetras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panTurnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panPuntuaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panNuevaPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panCambiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Graficar(){
        Diccionario.Graficar();
        JActual.getFichas().Graficar();
        Fichas.Graficar();
        Jugadores.Graficar();
        Matriz.Graficar();
        Graficando = new Thread(){
            public void run() {
                try {
                    ImageIcon Establecida;
                    Establecida = new ImageIcon((new ImageIcon("src/Reportes/LD.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
                    imgDiccionario.setIcon(Establecida);
                    imgDiccionario.repaint();
                    spanDiccionario.repaint();
                    Establecida = new ImageIcon((new ImageIcon("src/Reportes/LS.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
                    imgLista.setIcon(Establecida);
                    imgLista.repaint();
                    spanListaSimple.repaint();
                    Establecida = new ImageIcon((new ImageIcon("src/Reportes/C.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
                    imgCola.setIcon(Establecida);
                    imgCola.repaint();
                    spanCola.repaint();
                    Establecida = new ImageIcon((new ImageIcon("src/Reportes/LC.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
                    imgJugadores.setIcon(Establecida);
                    imgJugadores.repaint();
                    spanJugadores.repaint();
                    Establecida = new ImageIcon((new ImageIcon("src/Reportes/M.jpg")).getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
                    imgMatriz.setIcon(Establecida);
                    imgMatriz.repaint();
                    spanCola.repaint();
                    repaint();
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception e) {}
            }
        };
        Graficando.start();
    }
    
    private void ActualizarLetras(){
        NodoSimple actual = JActual.getFichas().getInicio();
        btnLetra1.setText(actual.getFicha().getLetra());
        actual = actual.getSiguiente();
        btnLetra2.setText(actual.getFicha().getLetra());
        actual = actual.getSiguiente();
        btnLetra3.setText(actual.getFicha().getLetra());
        actual = actual.getSiguiente();
        btnLetra4.setText(actual.getFicha().getLetra());
        actual = actual.getSiguiente();
        btnLetra5.setText(actual.getFicha().getLetra());
        actual = actual.getSiguiente();
        btnLetra6.setText(actual.getFicha().getLetra());
        actual = actual.getSiguiente();
        btnLetra7.setText(actual.getFicha().getLetra());
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(txtPalabraNueva.getText().length() > 0){
            Diccionario.Insertar(txtPalabraNueva.getText(), -1);
            txtPalabraNueva.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "Escribí algo home ¬¬");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JActual = JActual.getSiguiente();
        lblJugador.setText(JActual.getNombre());
        ActualizarLetras();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnLetra1;
    private javax.swing.JButton btnLetra2;
    private javax.swing.JButton btnLetra3;
    private javax.swing.JButton btnLetra4;
    private javax.swing.JButton btnLetra5;
    private javax.swing.JButton btnLetra6;
    private javax.swing.JButton btnLetra7;
    private javax.swing.JLabel imgCola;
    private javax.swing.JLabel imgDiccionario;
    private javax.swing.JLabel imgJugadores;
    private javax.swing.JLabel imgLista;
    private javax.swing.JLabel imgMatriz;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblCambiar;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblNuevaPalabra;
    private javax.swing.JLabel lblPuntuaciones;
    private javax.swing.JLabel lblReportes;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JPanel panCambiar;
    private javax.swing.JPanel panLetras;
    private javax.swing.JPanel panMatriz;
    private javax.swing.JPanel panNuevaPalabra;
    private javax.swing.JPanel panPuntuaciones;
    private javax.swing.JPanel panReportes;
    private javax.swing.JPanel panTurnos;
    private javax.swing.JScrollPane spanCola;
    private javax.swing.JScrollPane spanDiccionario;
    private javax.swing.JScrollPane spanJugadores;
    private javax.swing.JScrollPane spanListaSimple;
    private javax.swing.JScrollPane spanMatriz;
    private javax.swing.JTabbedPane tabReportes;
    private javax.swing.JTextField txtPalabraNueva;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(((JButton) e.getSource()).getText());
        System.out.println(((JButton) e.getSource()).getName());
    }
}