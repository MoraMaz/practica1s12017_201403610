package Estructuras;

/**
 *
 * @author Lenovo
 */
public class Matriz {
    private NodoMatriz NodoCeroCero;
    private int Dimension;

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
                    vecino.setIzquierda(aux);
                    aux.setDerecha(vecino);
                    aux = vecino;
                }else if(j == aux.getPosy()){
                    vecino.setArriba(aux);
                    aux.setAbajo(vecino);
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

    /**
     * @return the Dimension
     */
    public int getDimension() {
        return Dimension;
    }
}
