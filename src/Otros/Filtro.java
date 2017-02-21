package Otros;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Lenovo
 */
public class Filtro extends FileFilter {

    private final String Extension;

    public Filtro(String Extension) {
        this.Extension = Extension;
    }

    @Override
    public boolean accept(File archivo) {
        if (archivo.isDirectory()) {
            return true;
        }
        if (archivo.getName().endsWith(Extension)) {
            return true;
        } else if (archivo.getName().endsWith(Extension.toLowerCase())) {
            return true;
        } else if (archivo.getName().endsWith(Extension.toUpperCase())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return ("*." + Extension.toLowerCase());
    }
}
