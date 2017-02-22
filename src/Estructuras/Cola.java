package Estructuras;

import java.io.*;

/**
 *
 * @author Lenovo
 */
public class Cola {

    private NodoSimple Inicio, Fin;
    private int Tamano;

    public Cola() {
        this.Inicio = null;
        this.Fin = null;
        this.Tamano = 0;
    }

    public void Insertar(String Letra) {
        Ficha Ficha = new Ficha(Letra, 1);
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
            if (x.getFicha().getLetra().equals(Ficha)) {
                return true;
            }
        }
        return false;
    }

    public NodoSimple Obtener(String Ficha) {
        if (Existe(Ficha)) {
            NodoSimple x = Inicio;
            for (int i = 1; i <= getTamano(); i++) {
                if (x.getFicha().getLetra().equals(Ficha)) {
                    return x;
                }
            }
        }
        return null;
    }

    public NodoSimple Sacar() {
        if (getTamano() != 0) {
            NodoSimple aC = Inicio;
            Inicio = aC.getSiguiente();
            Tamano--;
            return aC;
        }
        return null;
    }
    
    public void Graficar(){
        StringBuilder Grafo_dot = new StringBuilder("digraph G\n{\n");
        try {
            File archivo = new File("src/Reportes/C.graphviz");
            NodoSimple aux = Inicio;
            int contador = 0;
            do{
                Grafo_dot.append("\tNode").append(contador).append("[label=\"").append(aux.getFicha().getLetra()).append("\"];\n");
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
            Runtime.getRuntime().exec( "C:/Program Files (x86)/Graphviz 2.28/bin/dot.exe -Tjpg src/Reportes/C.graphviz -o src/Reportes/C.jpg" );
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