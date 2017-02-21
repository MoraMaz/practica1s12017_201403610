package Estructuras;

/**
 *
 * @author Lenovo
 */
public class ListaDiccionario {
    private NodoDiccionario Inicio;
    private int Tamano;

    public ListaDiccionario() {
        Inicio = null;
        Tamano = 0;
    }
    
    public void Insertar(String Palabra, int Posicion){
            if(getTamano() == 0){
                Inicio = new NodoDiccionario(Palabra, null);
            }else{
                NodoDiccionario n;
                switch (Posicion) {
                    case -1: //Agregar al final
                        n = getInicio();
                        while(n.getSiguiente() != null){
                            n = n.getSiguiente();
                        }
                        n.setSiguiente(new NodoDiccionario(Palabra, null));
                        break;
                    case 0: //Agregar al inicio
                        n = new NodoDiccionario(Palabra, getInicio());
                        Inicio = n;
                        break;
                    default: //Agregar en una posición específica
                        NodoDiccionario x = getInicio();
                        n = new NodoDiccionario(Palabra, null);
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
    
    public boolean Existe(String Palabra){
        NodoDiccionario x = getInicio();
        for(int i = 1; i <= getTamano(); i++){
            if(x.getPalabra().equalsIgnoreCase(Palabra)){
                return true;
            }
        }
        return false;
    }
    
    public NodoDiccionario Obtener(String Palabra){
        if(Existe(Palabra)){
            NodoDiccionario x = getInicio();
            for(int i = 1; i <= getTamano(); i++){
                if(x.getPalabra().equalsIgnoreCase(Palabra)){
                    return x;
                }
            }
        }
        return null;
    }
    
    public void Eliminar(String Ficha){
        if(Existe(Ficha)){
            NodoDiccionario x = getInicio();
            if(x.getPalabra().equalsIgnoreCase(Ficha)){
                Inicio = getInicio().getSiguiente();
            }else{
                while(!x.getSiguiente().getPalabra().equalsIgnoreCase(Ficha)){
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
    public NodoDiccionario getInicio() {
        return Inicio;
    }
}