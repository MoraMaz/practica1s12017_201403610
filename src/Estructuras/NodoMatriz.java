package Estructuras;

import javax.swing.JButton;

/**
 *
 * @author Lenovo
 */
public class NodoMatriz extends JButton {
    private Ficha Letra;
    private int Bonus, Posx, Posy;
    private NodoMatriz Izquierda, Derecha, Arriba, Abajo;

    public NodoMatriz() {
        this.Letra = null;
        this.Bonus = 1;
        this.Posx = -1;
        this.Posy = -1;
        this.Izquierda = null;
        this.Derecha = null;
        this.Arriba = null;
        this.Abajo = null;
    }

    public NodoMatriz(int x, int y) {
        this.Letra = null;
        this.Bonus = 1;
        this.Posx = x;
        this.Posy = y;
        this.Izquierda = null;
        this.Derecha = null;
        this.Arriba = null;
        this.Abajo = null;
    }
    
    public NodoMatriz(Ficha Letra, int Bonus, int Posx, int Posy, NodoMatriz Izquierda, NodoMatriz Derecha, NodoMatriz Arriba, NodoMatriz Abajo) {
        this.Letra = Letra;
        this.Bonus = Bonus;
        this.Posx = Posx;
        this.Posy = Posy;
        this.Izquierda = Izquierda;
        this.Derecha = Derecha;
        this.Arriba = Arriba;
        this.Abajo = Abajo;
    }

    /**
     * @return the Letra
     */
    public Ficha getLetra() {
        return Letra;
    }

    /**
     * @param Letra the Letra to set
     */
    public void setLetra(Ficha Letra) {
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
     * @return the Posy
     */
    public int getPosy() {
        return Posy;
    }

    /**
     * @param Posy the Poxy to set
     */
    public void setPosy(int Posy) {
        this.Posy = Posy;
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