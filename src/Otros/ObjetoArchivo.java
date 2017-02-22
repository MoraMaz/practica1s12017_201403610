package Otros;

import Estructuras.Cola;
import Estructuras.ListaDiccionario;
import Estructuras.Matriz;

/**
 *
 * @author Lenovo
 */
public class ObjetoArchivo {
    
    private Matriz logica;
    private ListaDiccionario palabras;
    private Cola bolsa;
    
    public ObjetoArchivo() {
        bolsa = new Cola();
    }

    public ObjetoArchivo(Matriz logica, ListaDiccionario palabras) {
        this.logica = logica;
        this.palabras = palabras;
        this.bolsa = new Cola();
        this.GenerarBolsa();
    }
    
    private void GenerarBolsa(){
        int A = 12, E = 12, O = 9 , I = 6, S = 6, N = 5, R = 5, U = 5, D = 5, L = 4, T = 4, C = 4, G = 2, B = 2, M = 2, P = 2, H = 2, F = 1, V = 1, Y = 1, Q = 1, J = 1, Ñ = 1, X = 1, Z = 1;
        int Total = 95;
        int Aleatorio;
        while (Total != 0){
            Aleatorio = (int) (Math.random() * Total + 1);
            if (Aleatorio <= A){
                bolsa.Insertar("A");
                A--;
            }else if (Aleatorio <= A + E){
                bolsa.Insertar("E");
                E--;
            }else if (Aleatorio <= A + E + O){
                bolsa.Insertar("O");
                O--;
            }else if (Aleatorio <= A + E + O + I){
                bolsa.Insertar("I");
                I--;
            }else if (Aleatorio <= A + E + O + I + S){
                bolsa.Insertar("S");
                S--;
            }else if (Aleatorio <= A + E + O + I + S + N){
                bolsa.Insertar("N");
                N--;
            }else if (Aleatorio <= A + E + O + I + S + N + R){
                bolsa.Insertar("R");
                R--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U){
                bolsa.Insertar("U");
                U--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D){
                bolsa.Insertar("D");
                D--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L){
                bolsa.Insertar("L");
                L--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T){
                bolsa.Insertar("T");
                T--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C){
                bolsa.Insertar("C");
                C--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G){
                bolsa.Insertar("G");
                G--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B){
                bolsa.Insertar("B");
                B--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M){
                bolsa.Insertar("M");
                M--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P){
                bolsa.Insertar("P");
                P--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H){
                bolsa.Insertar("H");
                H--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F){
                bolsa.Insertar("F");
                F--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V){
                bolsa.Insertar("V");
                V--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V + Y){
                bolsa.Insertar("Y");
                Y--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V + Y + Q){
                bolsa.Insertar("Q");
                Q--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V + Y + Q + J){
                bolsa.Insertar("J");
                J--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V + Y + Q + J + Ñ){
                bolsa.Insertar("Ñ");
                Ñ--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V + Y + Q + J + Ñ + X){
                bolsa.Insertar("X");
                X--;
            }else if (Aleatorio <= A + E + O + I + S + N + R + U + D + L + T + C + G + B + M + P + H + F + V + Y + Q + J + Ñ + X + Z){
                bolsa.Insertar("Z");
                Z--;
            }
            Total--;
        }
    }
    
    /**
     * @return the logica
     */
    public Matriz getLogica() {
        return logica;
    }

    /**
     * @param logica the logica to set
     */
    public void setLogica(Matriz logica) {
        this.logica = logica;
    }

    /**
     * @return the palabras
     */
    public ListaDiccionario getPalabras() {
        return palabras;
    }

    /**
     * @param palabras the palabras to set
     */
    public void setPalabras(ListaDiccionario palabras) {
        this.palabras = palabras;
    }

    /**
     * @return the bolsa
     */
    public Cola getBolsa() {
        return bolsa;
    }

    /**
     * @param bolsa the bolsa to set
     */
    public void setBolsa(Cola bolsa) {
        this.bolsa = bolsa;
    }
    
}
