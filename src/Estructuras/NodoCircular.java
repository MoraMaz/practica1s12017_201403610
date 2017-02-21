package Estructuras;

/**
 *
 * @author Lenovo
 */
public class NodoCircular {
    private String Nombre;
    private NodoCircular Siguiente;
    private ListaSimple Fichas;

    public NodoCircular(String Nombre, NodoCircular Siguiente) {
        this.Nombre = Nombre;
        this.Siguiente = Siguiente;
        this.Fichas = null;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Siguiente
     */
    public NodoCircular getSiguiente() {
        return Siguiente;
    }

    /**
     * @param Siguiente the Siguiente to set
     */
    public void setSiguiente(NodoCircular Siguiente) {
        this.Siguiente = Siguiente;
    }

    /**
     * @return the Fichas
     */
    public ListaSimple getFichas() {
        return Fichas;
    }

    /**
     * @param Fichas the Fichas to set
     */
    public void setFichas(ListaSimple Fichas) {
        this.Fichas = Fichas;
    }
    
}