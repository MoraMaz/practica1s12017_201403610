package Estructuras;

/**
 *
 * @author Lenovo
 */
public class ListaSimple {
    private NodoSimple Inicio;
    private int Tamano;

    public ListaSimple() {
        Inicio = null;
        Tamano = 0;
    }
    
    public void Insertar(Ficha Ficha, int Posicion){
        if(getTamano() != 7){
            if(getTamano() == 0){
                Inicio = new NodoSimple(Ficha, null);
            }else{
                NodoSimple n;
                switch (Posicion) {
                    case -1: //Agregar al final
                        n = getInicio();
                        while(n.getSiguiente() != null){
                            n = n.getSiguiente();
                        }
                        n.setSiguiente(new NodoSimple(Ficha, null));
                        break;
                    case 0: //Agregar al inicio
                        n = new NodoSimple(Ficha, getInicio());
                        Inicio = n;
                        break;
                    default: //Agregar en una posición específica
                        NodoSimple x = getInicio();
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
    
    public void Insertar(Ficha Ficha){
        if(getTamano() == 0){
            Inicio = new NodoSimple(Ficha, null);
        }else{
            NodoSimple n = getInicio();
            while(n.getSiguiente() != null){
                n = n.getSiguiente();
            }
            n.setSiguiente(new NodoSimple(Ficha, null));
        }
        Tamano++;
    }
    
    public boolean Existe(String Letra){
        NodoSimple x = getInicio();
        for(int i = 1; i <= getTamano(); i++){
            if(x.getFicha().getLetra().equalsIgnoreCase(Letra)){
                return true;
            }
        }
        return false;
    }
    
    public NodoSimple Obtener(String Letra){
        if(Existe(Letra)){
            NodoSimple x = getInicio();
            for(int i = 1; i <= getTamano(); i++){
                if(x.getFicha().getLetra().equalsIgnoreCase(Letra)){
                    return x;
                }
            }
        }
        return null;
    }
    
    public void Eliminar(String Letra){
        if(Existe(Letra)){
            NodoSimple x = getInicio();
            if(x.getFicha().getLetra().equalsIgnoreCase(Letra)){
                Inicio = getInicio().getSiguiente();
            }else{
                while(!x.getSiguiente().getFicha().getLetra().equalsIgnoreCase(Letra)){
                    x = x.getSiguiente();
                }
                x.setSiguiente(x.getSiguiente().getSiguiente());
            }
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

    /**
     * @return the Inicio
     */
    public NodoSimple getInicio() {
        return Inicio;
    }
}