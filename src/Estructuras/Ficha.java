package Estructuras;

/**
 *
 * @author Lenovo
 */
public class Ficha {
    private String Letra;
    private int Cantidad, Puntuacion;

    public Ficha(String Letra, int Cantidad) {
        this.Letra = Letra;
        this.Cantidad = Cantidad;
        this.setPuntuacion(this.Letra);
    }

    private void setPuntuacion(String Letra){
        if((Letra.toLowerCase()).equals("z")){
            this.Puntuacion = 10;
        }else if ((Letra.toLowerCase()).equals("x") | (Letra.toLowerCase()).equals("ñ") | (Letra.toLowerCase()).equals("j")){
            this.Puntuacion = 8;
        }else if ((Letra.toLowerCase()).equals("q")){
            this.Puntuacion = 5;
        }else if ((Letra.toLowerCase()).equals("y") | (Letra.toLowerCase()).equals("v") | (Letra.toLowerCase()).equals("f") | (Letra.toLowerCase()).equals("h")){
            this.Puntuacion = 4;
        }else if ((Letra.toLowerCase()).equals("p") | (Letra.toLowerCase()).equals("m") | (Letra.toLowerCase()).equals("b") | (Letra.toLowerCase()).equals("c")){
            this.Puntuacion = 3;
        }else if ((Letra.toLowerCase()).equals("g") | (Letra.toLowerCase()).equals("d") ){
            this.Puntuacion = 2;
        }else if ((Letra.toLowerCase()).equals("t") | (Letra.toLowerCase()).equals("u") | (Letra.toLowerCase()).equals("r") | (Letra.toLowerCase()).equals("l") | (Letra.toLowerCase()).equals("n") | (Letra.toLowerCase()).equals("s") | (Letra.toLowerCase()).equals("i") | (Letra.toLowerCase()).equals("o") | (Letra.toLowerCase()).equals("e") | (Letra.toLowerCase()).equals("a")){
            this.Puntuacion = 1;
        }
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
     * @return the Cantidad
     */
    public int getCantidad() {
        return Cantidad;
    }

    /**
     * @param Cantidad the Cantidad to set
     */
    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    /**
     * @return the Puntuacion
     */
    public int getPuntuacion() {
        return Puntuacion;
    }

    /**
     * @param Puntuacion the Puntuacion to set
     */
    public void setPuntuacion(int Puntuacion) {
        this.Puntuacion = Puntuacion;
    }
    
}
