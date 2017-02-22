package Estructuras;

import java.io.*;

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
    
    public void Graficar(){
        StringBuilder Grafo_dot = new StringBuilder("digraph G\n{\n");
        try {
            File archivo = new File("src/Reportes/LD.graphviz");
            NodoDiccionario aux = Inicio;
            int contador = 0;
            do{
                Grafo_dot.append("\tNode").append(contador).append("[label=\"").append(aux.getPalabra()).append("\"];\n");
                aux = aux.getSiguiente();
                contador++;
            }while(aux != null);
            Grafo_dot.append("\n");
            aux = Inicio;
            contador = 0;
            do{
                Grafo_dot.append("\tNode").append(contador).append(" -> Node").append(contador + 1).append(" [label=\"Siguiente\"];\n");
                aux = aux.getSiguiente();
                contador++;
            }while(aux.getSiguiente() != null);
            Grafo_dot.append("}");
            FileOutputStream codigo = new FileOutputStream(archivo);
            codigo.write(Grafo_dot.toString().getBytes());
            Runtime.getRuntime().exec("C:/Program Files (x86)/Graphviz 2.28/bin/dot.exe -Tjpg src/Reportes/LD.graphviz -o src/Reportes/LD.jpg");
        } catch (Exception e) {
            System.out.println("No se ha graficado.");
        }
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