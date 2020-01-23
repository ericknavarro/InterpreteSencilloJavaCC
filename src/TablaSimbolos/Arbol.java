package TablaSimbolos;

import Excepciones.Excepcion;
import Abstract.AST;
import java.util.ArrayList;
import javafx.scene.control.TextArea;

/**
 *
 * @author Pavel
 */
public class Arbol {

    private ArrayList<AST> instrucciones;
    private ArrayList<Excepcion> excepciones;
    private TextArea consola;

    public Arbol(ArrayList<AST> instrucciones) {
        this.instrucciones = instrucciones;
        this.excepciones = new ArrayList<>();
    }

    public ArrayList<AST> getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(ArrayList<AST> instrucciones) {
        this.instrucciones = instrucciones;
    }

    public ArrayList<Excepcion> getExcepciones() {
        return excepciones;
    }

    public void setExcepciones(ArrayList<Excepcion> excepciones) {
        this.excepciones = excepciones;
    }
    
    public TextArea getConsola() {
        return consola;
    }

    public void setConsola(TextArea consola) {
        this.consola = consola;
    }
}
