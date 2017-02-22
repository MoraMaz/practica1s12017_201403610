package Estructuras;

import java.io.*;

/**
 *
 * @author Lenovo
 */
public class ListaCircular {
    
    private final Cola TodasLasFichas;
    public NodoCircular Inicial;
    private int Tamano;
    
    public ListaCircular(Cola TodasLasFichas) {
        this.TodasLasFichas = TodasLasFichas;
        this.Inicial = null;
        this.Tamano = 0;
    }
    
    public boolean Insertar(String nombre){
        if(getTamano() == 0){
            Inicial = new NodoCircular(nombre, null);
            Inicial.setSiguiente(Inicial);
            Tamano++;
            ObtenerFichas(Inicial);
            return true;
        }else if(!Existe(nombre)){
            NodoCircular x, n;
            n = new NodoCircular(nombre, Inicial);
            ObtenerFichas(n);
            x = Inicial;
            while(x.getSiguiente() != Inicial){
                x = x.getSiguiente();
            }
            x.setSiguiente(n);
            Tamano++;
            return true;
        }
        return false;
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

    private void ObtenerFichas(NodoCircular Jugador) {
        ListaSimple Fichas = new ListaSimple();
        for (int i = 0; i < 7; i++) {
            Fichas.Insertar(TodasLasFichas.Sacar().getFicha());
        }
        Jugador.setFichas(Fichas);
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
    
    public void Graficar(){
        StringBuilder Grafo_dot = new StringBuilder("digraph G\n{\n");
        try {
            File archivo = new File("src/Reportes/LC.graphviz");
            NodoCircular aux = Inicial;
            int contador = 0;
            do{
                Grafo_dot.append("\tNode").append(contador).append("[label=\"").append(aux.getNombre()).append("\"];\n");
                aux = aux.getSiguiente();
                contador++;
            }while(aux != Inicial);
            Grafo_dot.append("\n");
            aux = Inicial;
            contador = 0;
            do{
                if(aux.getSiguiente() == Inicial){
                    Grafo_dot.append("\tNode").append(contador).append(" -> Node").append(0).append(" [label=\"Siguiente\"];\n");
                }else {
                    Grafo_dot.append("\tNode").append(contador).append(" -> Node").append(contador + 1).append(" [label=\"Siguiente\"];\n");
                }
                aux = aux.getSiguiente();
                contador++;
            }while(aux != Inicial);
            Grafo_dot.append("}");
            FileOutputStream codigo = new FileOutputStream(archivo);
            codigo.write(Grafo_dot.toString().getBytes());
            Runtime.getRuntime().exec("C:/Program Files (x86)/Graphviz 2.28/bin/dot.exe -Tjpg src/Reportes/LC.graphviz -o src/Reportes/LC.jpg");
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
}