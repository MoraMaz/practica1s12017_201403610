package Estructuras;

/**
 *
 * @author Lenovo
 */
public class NodoDiccionario {
    private ListaSimple Palabra;
    private NodoDiccionario Siguiente;

    public NodoDiccionario(String Palabra, NodoDiccionario Siguiente) {
        this.Palabra = new ListaSimple();
        this.GenerarPalabra(Palabra);
        this.Siguiente = Siguiente;
    }
    
    private void GenerarPalabra(String Palabra){
        int Longitud = Palabra.length();
        Ficha NuevaFicha;
        for (int i = 0; i < Longitud; i++) {
            NuevaFicha = new Ficha(Palabra.charAt(i) + "", 1);
            this.Palabra.Insertar(NuevaFicha);
        }
    }

    /**
     * @return the Palabra
     */
    public String getPalabra() {
        String StringPalabra = "";
        NodoSimple Actual = Palabra.getInicio();
        while(Actual != null){
            StringPalabra += Actual.getFicha().getLetra();
            Actual = Actual.getSiguiente();
        }
        return StringPalabra;
    }

    /**
     * @param Palabra the Palabra to set
     */
    public void setPalabra(String Palabra) {
        this.GenerarPalabra(Palabra);
    }

    /**
     * @return the Palabra
     */
    public ListaSimple getListaPalabra() {
        return Palabra;
    }

    /**
     * @param Palabra the Palabra to set
     */
    public void setListaPalabra(ListaSimple Palabra) {
        this.Palabra = Palabra;
    }

    /**
     * @return the Siguiente
     */
    public NodoDiccionario getSiguiente() {
        return Siguiente;
    }

    /**
     * @param Siguiente the Siguiente to set
     */
    public void setSiguiente(NodoDiccionario Siguiente) {
        this.Siguiente = Siguiente;
    }
}
