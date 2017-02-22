package Main;

import Interfaz.*;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Lenovo
 */
public class Main {
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
            VentanitaPrincipal Nueva = new VentanitaPrincipal();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
    }    
}