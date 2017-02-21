package practica1s12017_201403610;

import Interfaz.*;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Lenovo
 */
public class Practica1s12017_201403610 {
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
            (new VentanitaPrincipal()).setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            (new VentanitaPrincipal()).setVisible(true);
        }
    }    
}