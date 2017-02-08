package Estructuras;

/**
 *
 * @author Lenovo
 */
public class NodoSimple {
    private String Ficha;
    private NodoSimple Siguiente;

    public NodoSimple(String Ficha, NodoSimple Siguiente) {
        this.Ficha = Ficha;
        this.Siguiente = Siguiente;
    }

    /**
     * @return the Ficha
     */
    public String getFicha() {
        return Ficha;
    }

    /**
     * @param Ficha the Ficha to set
     */
    public void setFicha(String Ficha) {
        this.Ficha = Ficha;
    }

    /**
     * @return the Siguiente
     */
    public NodoSimple getSiguiente() {
        return Siguiente;
    }

    /**
     * @param Siguiente the Siguiente to set
     */
    public void setSiguiente(NodoSimple Siguiente) {
        this.Siguiente = Siguiente;
    }
    
}