package Estructuras;

/**
 *
 * @author Lenovo
 */
public class Cola {

    private NodoSimple Inicio, Fin;
    private int Tamano;

    public Cola() {
        Inicio = null;
        Fin = null;
        Tamano = 0;
    }

    public void Insertar(String Ficha, int Posicion) {
        if (getTamano() == 0) {
            Inicio = new NodoSimple(Ficha, null);
            Fin = Inicio;
        } else {
            Fin.setSiguiente(new NodoSimple(Ficha, null));
            Fin = Fin.getSiguiente();
        }
        Tamano++;
    }

    public boolean Existe(String Ficha) {
        NodoSimple x = Inicio;
        for (int i = 1; i <= getTamano(); i++) {
            if (x.getFicha().equals(Ficha)) {
                return true;
            }
        }
        return false;
    }

    public NodoSimple Obtener(String Ficha) {
        if (Existe(Ficha)) {
            NodoSimple x = Inicio;
            for (int i = 1; i <= getTamano(); i++) {
                if (x.getFicha().equals(Ficha)) {
                    return x;
                }
            }
        }
        return null;
    }

    public NodoSimple SacarInico(String Ficha) {
        if (Existe(Ficha)) {
            NodoSimple aC = Inicio;
            Inicio = Inicio.getSiguiente();
            Tamano--;
            return aC;
        }
        return null;
    }
    
    public String Graficar(){
        StringBuilder Grafo_dot = new StringBuilder("");
        Grafo_dot.append("");
        return Grafo_dot.toString();
    }

    /**
     * @return the Tamano
     */
    public int getTamano() {
        return Tamano;
    }
}