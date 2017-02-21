package Otros;

import Estructuras.Matriz;
import Estructuras.ListaDiccionario;

/**
 *
 * @author Lenovo
 */
public class Archivo {

    private ObjetoArchivo MatrizDiccionario; //Objeto que contiene la matriz y el diccionario obtenido del archivo
    
    public Archivo() {
        MatrizDiccionario = new ObjetoArchivo();
    }

    public ObjetoArchivo agregarAtributos(String Texto) {
        Texto = Texto.replace("\t", ""); //Se eliminan los espacios en blanco y los tabuladores
        Texto = Texto.replace(" ", ""); //para el mejor manejo de la entrada
        Matriz Matriz = new Matriz(); //Objeto para devolver al terminar
        ListaDiccionario Diccionario = new ListaDiccionario(); //Objeto para devolver al terminar
        int puntero = 0;
        int x = -1, y = -1, Dimension = -1;
        boolean CasillasDobles = false;
        boolean CasillasTriples = false;
        boolean PalabrasDiccionario = false;
        String Palabra = "";
        String Letra;
        while (puntero < Texto.length()) {
            Letra = "" + Texto.charAt(puntero);
            if (CasillasDobles || CasillasTriples) {
                if (Palabra.equalsIgnoreCase("<casilla>") || Palabra.equalsIgnoreCase("</x>") || Palabra.equalsIgnoreCase("</y>") || Palabra.equalsIgnoreCase("</casilla>")) {
                    Palabra = ""; //Etiquetas que se ignoran
                } else if(Palabra.equalsIgnoreCase("<x>")){
                    Palabra = "";
                    for (int i = puntero; i < puntero + 100; i++) {
                        try {
                            Palabra += Integer.parseInt(Texto.charAt(i) + "");
                        } catch (Exception e) {
                            x = Integer.parseInt(Palabra);
                            puntero += Palabra.length();
                            break;
                        }
                    }
                    Palabra = "";
                    puntero += "</x>".length();
                    if(Texto.charAt(puntero) == '<' && Texto.charAt(puntero + 1) == 'y' && Texto.charAt(puntero + 2) == '>'){
                        puntero += "<y>".length();
                        Palabra = "";
                        for (int i = puntero; i < puntero + 100; i++) {
                            try {
                                Palabra += Integer.parseInt(Texto.charAt(i) + "");
                            } catch (Exception e) {
                                y = Integer.parseInt(Palabra);
                                puntero += Palabra.length();
                                break;
                            }
                        }
                        Palabra = "";
                        puntero += "</y>".length() - 1;
                        Letra = "";
                    }
                    if(CasillasDobles){
                        Matriz.InsertarBonus(x, y, 2);
                    }else{
                        Matriz.InsertarBonus(x, y, 3);
                    }
                }else if(Palabra.equalsIgnoreCase("<y>")){
                    Palabra = "";
                    for (int i = puntero; i < puntero + 100; i++) {
                        try {
                            Palabra += Integer.parseInt(Texto.charAt(i) + "");
                        } catch (Exception e) {
                            x = Integer.parseInt(Palabra);
                            puntero += Palabra.length();
                            break;
                        }
                    }
                    Palabra = "";
                    puntero += "</y>".length();
                    if(Texto.charAt(puntero) == '<' && Texto.charAt(puntero + 1) == 'x' && Texto.charAt(puntero + 2) == '>'){
                        Palabra = "";
                        for (int i = puntero; i < puntero + 100; i++) {
                            try {
                                Palabra += Integer.parseInt(Texto.charAt(i) + "");
                            } catch (Exception e) {
                                y = Integer.parseInt(Palabra);
                                puntero += Palabra.length();
                                break;
                            }
                        }
                        Palabra = "";
                        Letra = "";
                        puntero += "</x>".length() - 1;
                    }
                    if(CasillasDobles){
                        Matriz.InsertarBonus(x, y, 2);
                    }else{
                        Matriz.InsertarBonus(x, y, 3);
                    }
                }else if (Palabra.equalsIgnoreCase("</dobles>")) {
                    Palabra = ""; //Etiqueta que marca el fin de las casillas dobles
                    CasillasDobles = false;
                }else if (Palabra.equalsIgnoreCase("</triples>")){
                    Palabra = ""; //Etiqueta que marca el fin de las casillas triples
                    CasillasTriples = false;
                }
            } else if (PalabrasDiccionario) {
                if(Palabra.equalsIgnoreCase("<palabra>")){
                    Palabra = "";
                    char Caracter = Texto.charAt(puntero);
                    while(Caracter != '<'){
                        Palabra += Caracter;
                        puntero ++;
                        Caracter = Texto.charAt(puntero);
                    }
                    Diccionario.Insertar(Palabra, -1);
                    Palabra = "";
                    Letra = "";
                    puntero += "</palabra>".length() - 1;
                }else if(Palabra.equalsIgnoreCase("</diccionario>")){
                    Palabra = ""; //Etiqueta que marca el fin del diccionario de palabras
                    PalabrasDiccionario = false;
                }
            } else if (Palabra.equalsIgnoreCase("<dimension>")) {
                Palabra = "";
                for (int i = puntero; i < puntero + 100; i++) {
                    try {
                        Palabra += Integer.parseInt(Texto.charAt(i) + "");
                    } catch (Exception e) {
                        Dimension = Integer.parseInt(Palabra);
                        Matriz = new Matriz(Dimension);
                        puntero += Palabra.length();
                        break;
                    }
                }
                Palabra = "";
                Letra = "";
                puntero += "</dimension>".length() - 1;
            } else if (Palabra.equalsIgnoreCase("<dobles>")) {
                CasillasDobles = true;
                Palabra = "";
            } else if (Palabra.equalsIgnoreCase("<triples>")) {
                CasillasTriples = true;
                Palabra = "";
            } else if (Palabra.equalsIgnoreCase("<diccionario>")) {
                PalabrasDiccionario = true;
                Palabra = "";
            } else if (Palabra.equalsIgnoreCase("<scrabble>") || Palabra.equalsIgnoreCase("</scrabble>")) {
                Palabra = ""; //Se ignoran las etiquetas de inicio y fin del archivo
            }
            Palabra += Letra;
            puntero++;
        }
        MatrizDiccionario = new ObjetoArchivo(Matriz, Diccionario);
        return MatrizDiccionario;
    }
}
