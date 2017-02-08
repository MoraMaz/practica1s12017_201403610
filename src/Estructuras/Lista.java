package Estructuras;

/**
 *
 * @author Lenovo
 */
public class Lista {
    private NodoSimple Inicio;
    private int Tamano;

    public Lista() {
        Inicio = null;
        Tamano = 0;
    }
    
    public void Insertar (String Ficha, int Posicion){
        if(getTamano() != 7){
            if(getTamano() == 0){
                Inicio = new NodoSimple(Ficha, null);
            }else{
                NodoSimple n;
                switch (Posicion) {
                    case -1: //Agregar al final
                        n = Inicio;
                        while(n.getSiguiente() != null){
                            n = n.getSiguiente();
                        }
                        n.setSiguiente(new NodoSimple(Ficha, null));
                        break;
                    case 0: //Agregar al inicio
                        n = new NodoSimple(Ficha, Inicio);
                        Inicio = n;
                        break;
                    default: //Agregar en una posición específica
                        NodoSimple x = Inicio;
                        n = new NodoSimple(Ficha, null);
                        for(int i = 1; i < Posicion; i++){
                            x = x.getSiguiente();
                        }
                        n.setSiguiente(x.getSiguiente());
                        x.setSiguiente(n);
                        break;
                }
            }
            Tamano++;
        }
    }
    
    public boolean Existe(String Ficha){
        NodoSimple x = Inicio;
        for(int i = 1; i <= getTamano(); i++){
            if(x.getFicha().equals(Ficha)){
                return true;
            }
        }
        return false;
    }
    
    public NodoSimple Obtener(String Ficha){
        if(Existe(Ficha)){
            NodoSimple x = Inicio;
            for(int i = 1; i <= getTamano(); i++){
                if(x.getFicha().equals(Ficha)){
                    return x;
                }
            }
        }
        return null;
    }
    
    public void Eliminar(String Ficha){
        if(Existe(Ficha)){
            NodoSimple x = Inicio;
            while(!x.getSiguiente().getFicha().equals(Ficha)){
                x = x.getSiguiente();
            }
            x.setSiguiente(x.getSiguiente().getSiguiente());
            Tamano--;
        }
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