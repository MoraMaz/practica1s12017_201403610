package Estructuras;

import java.io.*;

/**
 *
 * @author Lenovo
 */
public class Matriz {
    private NodoMatriz NodoCeroCero;
    private int Dimension;

    public Matriz() {
        this.NodoCeroCero = null;
    }

    public Matriz(int Dimension) {
        this.Dimension = Dimension;
        this.Generar();
    }
    
    private void Generar(){
        NodoMatriz auxiliar, vecino;
        auxiliar = new NodoMatriz();
        int i, j, k = 0;
        for(j = 0; j < getDimension(); j++){
            for (i = 0; i < getDimension(); i++) {
                vecino = new NodoMatriz(i, j);
                if(i == 0 && j == 0){
                    NodoCeroCero = vecino;
                    auxiliar = NodoCeroCero;
                }else if(i == auxiliar.getPosx()){
                    vecino.setArriba(auxiliar);
                    auxiliar.setAbajo(vecino);
                    auxiliar = vecino;
                    auxiliar.setAbajo(null);
                }else if(j == auxiliar.getPosy()){
                    vecino.setIzquierda(auxiliar);
                    auxiliar.setDerecha(vecino);
                    auxiliar = vecino;
                    auxiliar.setDerecha(null);
                }
                if(i == getDimension() - 1){
                    k = getDimension() - 1;
                    while(k != 0){
                        auxiliar = auxiliar.getIzquierda();
                        k--;
                    }
                }
            }
        }
        i = 0;
        j = 0;
        auxiliar = NodoCeroCero;
        vecino = auxiliar.getAbajo();
        try{
        while(vecino.getAbajo() != null){
            while(auxiliar.getDerecha() != null){
                auxiliar.setAbajo(vecino);
                vecino.setArriba(auxiliar);
                auxiliar = auxiliar.getDerecha();
                vecino = vecino.getDerecha();
                if(auxiliar.getDerecha() == null){
                    while(auxiliar.getIzquierda() != null){
                        auxiliar = auxiliar.getIzquierda();
                        vecino = vecino.getIzquierda();
                    }
                    break;
                }
            }
            auxiliar = auxiliar.getAbajo();
            vecino = auxiliar.getAbajo();
            j++;
        }}catch(Exception e){
            System.out.println("x = " + i + "\ny = " + j + "\nz = " + k);
        }
    }

    public NodoMatriz Buscar(int Posx, int Posy) {
        NodoMatriz Actual = NodoCeroCero;
        int cx = 0, cy = 0;
        while(cy <= getDimension()){
            if(Posy == Actual.getPosy()){
                while(cx <= getDimension()){
                    if(Posx == Actual.getPosx()){
                        return Actual;
                    }
                    if(Actual.getDerecha() != null){
                        Actual = Actual.getDerecha();
                    }
                    cx++;
                }
            }
            if(Actual.getAbajo() != null){
                Actual = Actual.getAbajo();
            }
            cy++;
        }
        System.out.println(Posx + "," + Posy);
        return null;
    }
    
    public void InsertarBonus(int Posx, int Posy, int Bonus){
        NodoMatriz encontrado = Buscar(Posx, Posy);
        if(encontrado != null){
            encontrado.setBonus(Bonus);
        }else{
            System.out.println("Nodo de la matriz no encontrado.");
        }
    }
    
    public void Graficar(){
        StringBuilder Grafo_dot = new StringBuilder("digraph G{\n\trankdir=UD;\n\tnode [shape = box];\n\n");
        try {
            File archivo = new File("src/Reportes/M.graphviz");
            NodoMatriz Actual = NodoCeroCero;
            int cx = 0, cy = 0;
            while(cy <= getDimension() - 1){
                if(cy == 0){
                    Grafo_dot.append("\t{\n\t\trank = min;\n");
                }else if(cy == getDimension()){
                    Grafo_dot.append("\t{\n\t\trank = max;\n");
                }else{
                    Grafo_dot.append("\t{\n\t\trank = same;\n");
                }
                while(cx <= getDimension() - 1){
                    Grafo_dot.append("\tNode").append(Actual.getPosx()).append("_").append(Actual.getPosy()).append("[label=\"").append(Actual.getBonus()).append("\"];\n");
                    if(Actual.getDerecha() != null){
                        Grafo_dot.append("\t\tNode").append(Actual.getPosx()).append("_").append(Actual.getPosy()).append(" -> Node").append(Actual.getDerecha().getPosx()).append("_").append(Actual.getDerecha().getPosy()).append("[rankdir=LR];\n");
                    }
                    if(Actual.getIzquierda() != null){
                        Grafo_dot.append("\t\tNode").append(Actual.getPosx()).append("_").append(Actual.getPosy()).append(" -> Node").append(Actual.getIzquierda().getPosx()).append("_").append(Actual.getIzquierda().getPosy()).append(";\n");
                    }
                    if(Actual.getDerecha() != null){
                        Actual = Actual.getDerecha();
                    }else{
                        int k = getDimension() - 1;
                        while(k != 0){
                            Actual = Actual.getIzquierda();
                            k--;
                        }
                    }
                    cx++;
                }
                if(Actual.getAbajo() != null){
                    Actual = Actual.getAbajo();
                    cx = 0;
                }
                cy++;
                Grafo_dot.append("\t}\n\n");
            }
            Actual = NodoCeroCero;
            cx = 0;
            cy = 0;
            while(cy <= getDimension() - 1){
                while(cx <= getDimension() - 1){
                    if(Actual.getAbajo() != null){
                        Grafo_dot.append("\t\tNode").append(Actual.getPosx()).append("_").append(Actual.getPosy()).append(" -> Node").append(Actual.getAbajo().getPosx()).append("_").append(Actual.getAbajo().getPosy()).append("[rankdir=UD];\n");
                    }
                    if(Actual.getArriba() != null){
                        Grafo_dot.append("\t\tNode").append(Actual.getPosx()).append("_").append(Actual.getPosy()).append(" -> Node").append(Actual.getArriba().getPosx()).append("_").append(Actual.getArriba().getPosy()).append(";\n");
                    }
                    if(Actual.getDerecha() != null){
                        Actual = Actual.getDerecha();
                    }else{
                        int k = getDimension() - 1;
                        while(k != 0){
                            Actual = Actual.getIzquierda();
                            k--;
                        }
                    }
                    cx++;
                }
                if(Actual.getAbajo() != null){
                    Actual = Actual.getAbajo();
                    cx = 0;
                }
                cy++;
            }
            Actual = NodoCeroCero;
            Grafo_dot.append("}");
            FileOutputStream codigo = new FileOutputStream(archivo);
            codigo.write(Grafo_dot.toString().getBytes());
            Runtime.getRuntime().exec("C:/Program Files (x86)/Graphviz 2.28/bin/dot.exe -Tjpg src/Reportes/M.graphviz -o src/Reportes/M.jpg");
        } catch (Exception e) {
            System.out.println("No se ha graficado.");
        }
    }

    /**
     * @return the Dimension
     */
    public int getDimension() {
        return Dimension;
    }
}
