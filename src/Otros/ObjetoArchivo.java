package Otros;

import Estructuras.ListaDiccionario;
import Estructuras.Matriz;

/**
 *
 * @author Lenovo
 */
public class ObjetoArchivo {
    
    private Matriz logica;
    private ListaDiccionario palabras;
    
    public ObjetoArchivo() {
    }

    public ObjetoArchivo(Matriz logica, ListaDiccionario palabras) {
        this.logica = logica;
        this.palabras = palabras;
    }
    
    /**
     * @return the logica
     */
    public Matriz getLogica() {
        return logica;
    }

    /**
     * @param logica the logica to set
     */
    public void setLogica(Matriz logica) {
        this.logica = logica;
    }

    /**
     * @return the palabras
     */
    public ListaDiccionario getPalabras() {
        return palabras;
    }

    /**
     * @param palabras the palabras to set
     */
    public void setPalabras(ListaDiccionario palabras) {
        this.palabras = palabras;
    }
    
}
