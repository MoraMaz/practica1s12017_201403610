package Estructuras;

/**
 *
 * @author Lenovo
 */
public class ListaCircular {
    public NodoCircular Inicial;
    private int Tamano;
    public ListaCircular() {
        Inicial = null;
        Tamano = 0;
    }
    
    public void Insertar(String nombre){
        if(getTamano() == 0){
            Inicial = new NodoCircular(nombre, null);
            Inicial.setSiguiente(Inicial);
        }else{
            NodoCircular x, n;
            n = new NodoCircular(nombre, Inicial);
            x = Inicial;
            while(x.getSiguiente() != Inicial){
                x = x.getSiguiente();
            }
            x.setSiguiente(n);
            x.setSiguiente(Inicial);
        }
        Tamano++;
    }
    
    public boolean Existe(String nombre){
        NodoCircular x = Inicial;
        for(int i = 1; i <= getTamano(); i++){
            if(x.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
    public NodoCircular Obtener(String nombre){
        if(Existe(nombre)){
            NodoCircular x = Inicial;
            for(int i = 1; i <= getTamano(); i++){
                if(x.getNombre().equals(nombre)){
                    return x;
                }
            }
        }
        return null;
    }
    
    public void Eliminar(String nombre){
        if(Existe(nombre)){
            NodoCircular x = Inicial;
            while(!x.getSiguiente().getNombre().equals(nombre)){
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