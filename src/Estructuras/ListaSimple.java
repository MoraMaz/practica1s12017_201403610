package Estructuras;

import java.io.*;

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
                setInicio(new NodoSimple(Ficha, null));
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
                        setInicio(n);
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
            setInicio(new NodoSimple(Ficha, null));
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
                setInicio(getInicio().getSiguiente());
            }else{
                while(!x.getSiguiente().getFicha().getLetra().equalsIgnoreCase(Letra)){
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
            File archivo = new File("src/Reportes/LS.graphviz");
            NodoSimple aux = getInicio();
            int contador = 0;
            do{
                Grafo_dot.append("\tNode").append(contador).append("[label=\"").append(aux.getFicha().getLetra()).append("\"];\n");
                aux = aux.getSiguiente();
                contador++;
            }while(aux != null);
            Grafo_dot.append("\n");
            aux = getInicio();
            contador = 0;
            do{
                Grafo_dot.append("\tNode").append(contador).append(" -> Node").append(contador + 1).append(" [label=\"Siguiente\"];\n");
                aux = aux.getSiguiente();
                contador++;
            }while(aux.getSiguiente() != null);
            Grafo_dot.append("}");
            FileOutputStream codigo = new FileOutputStream(archivo);
            codigo.write(Grafo_dot.toString().getBytes());
            Runtime.getRuntime().exec("C:/Program Files (x86)/Graphviz 2.28/bin/dot.exe -Tjpg src/Reportes/LS.graphviz -o src/Reportes/LS.jpg");
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
    public NodoSimple getInicio() {
        return Inicio;
    }

    /**
     * @param Inicio the Inicio to set
     */
    public void setInicio(NodoSimple Inicio) {
        this.Inicio = Inicio;
    }
}