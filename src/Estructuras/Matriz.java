package Estructuras;

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
        NodoMatriz aux, vecino;
        aux = new NodoMatriz();
        for(int j = 0; j < getDimension(); j++){
            for (int i = 0; i < getDimension(); i++) {
                vecino = new NodoMatriz(i, j);
                if(i == 0 && j == 0){
                    NodoCeroCero = vecino;
                    aux = NodoCeroCero;
                }else if(i == aux.getPosx()){
                    vecino.setArriba(aux);
                    aux.setAbajo(vecino);
                    aux = vecino;
                }else if(j == aux.getPosy()){
                    vecino.setIzquierda(aux);
                    aux.setDerecha(vecino);
                    aux = vecino;
                }
                if(i == getDimension() - 1){
                    int k = getDimension() - 1;
                    while(k != 0){
                        aux = aux.getIzquierda();
                        k--;
                    }
                }
            }
        }
    }

    private NodoMatriz Buscar(int Posx, int Posy) {
        NodoMatriz Recorrido = NodoCeroCero;
        while(Recorrido.getAbajo() != null){
            if(Posy == Recorrido.getPosy()){
                while(Recorrido.getDerecha() != null){
                    if(Posx == Recorrido.getPosx()){
                        return Recorrido;
                    }
                    Recorrido = Recorrido.getDerecha();
                }
            }
            Recorrido = Recorrido.getAbajo();
        }
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

    /**
     * @return the Dimension
     */
    public int getDimension() {
        return Dimension;
    }
}
