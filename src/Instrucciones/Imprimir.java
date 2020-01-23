package Instrucciones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import javafx.scene.control.TextArea;

/**
 *
 * @author Pavel
 */
public class Imprimir extends AST {

    private AST expresion;

    public Imprimir(AST expresion, int fila, int columna) {
        this.expresion = expresion;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Object value = expresion.interpretar(tabla, tree);
        if (value instanceof Excepcion) return value;
        TextArea ta = tree.getConsola();
        ta.setText(ta.getText() + value + "\n");
        return null;
    }
}
