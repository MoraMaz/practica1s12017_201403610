package Estructuras;

/**
 *
 * @author Lenovo
 */
public class NodoMatriz {
    private String Letra;
    private int Bonus, Posx, Poxy;
    private NodoMatriz Izquierda, Derecha, Arriba, Abajo;

    public NodoMatriz(String Letra, int Bonus, int Posx, int Poxy, NodoMatriz Izquierda, NodoMatriz Derecha, NodoMatriz Arriba, NodoMatriz Abajo) {
        this.Letra = Letra;
        this.Bonus = Bonus;
        this.Posx = Posx;
        this.Poxy = Poxy;
        this.Izquierda = Izquierda;
        this.Derecha = Derecha;
        this.Arriba = Arriba;
        this.Abajo = Abajo;
    }

    /**
     * @return the Letra
     */
    public String getLetra() {
        return Letra;
    }

    /**
     * @param Letra the Letra to set
     */
    public void setLetra(String Letra) {
        this.Letra = Letra;
    }

    /**
     * @return the Bonus
     */
    public int getBonus() {
        return Bonus;
    }

    /**
     * @param Bonus the Bonus to set
     */
    public void setBonus(int Bonus) {
        this.Bonus = Bonus;
    }

    /**
     * @return the Posx
     */
    public int getPosx() {
        return Posx;
    }

    /**
     * @param Posx the Posx to set
     */
    public void setPosx(int Posx) {
        this.Posx = Posx;
    }

    /**
     * @return the Poxy
     */
    public int getPoxy() {
        return Poxy;
    }

    /**
     * @param Poxy the Poxy to set
     */
    public void setPoxy(int Poxy) {
        this.Poxy = Poxy;
    }

    /**
     * @return the Izquierda
     */
    public NodoMatriz getIzquierda() {
        return Izquierda;
    }

    /**
     * @param Izquierda the Izquierda to set
     */
    public void setIzquierda(NodoMatriz Izquierda) {
        this.Izquierda = Izquierda;
    }

    /**
     * @return the Derecha
     */
    public NodoMatriz getDerecha() {
        return Derecha;
    }

    /**
     * @param Derecha the Derecha to set
     */
    public void setDerecha(NodoMatriz Derecha) {
        this.Derecha = Derecha;
    }

    /**
     * @return the Arriba
     */
    public NodoMatriz getArriba() {
        return Arriba;
    }

    /**
     * @param Arriba the Arriba to set
     */
    public void setArriba(NodoMatriz Arriba) {
        this.Arriba = Arriba;
    }

    /**
     * @return the Abajo
     */
    public NodoMatriz getAbajo() {
        return Abajo;
    }

    /**
     * @param Abajo the Abajo to set
     */
    public void setAbajo(NodoMatriz Abajo) {
        this.Abajo = Abajo;
    }

    
   
}
