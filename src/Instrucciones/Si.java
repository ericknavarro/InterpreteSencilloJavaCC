package Instrucciones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class Si extends AST {

    private AST condicion;
    private ArrayList<AST> instruccionesIf;
    private ArrayList<AST> instruccionesElse;

    public Si(AST condicion, ArrayList<AST> instruccionesIf, ArrayList<AST> instruccionesElse, int fila, int columna) {
        this.condicion = condicion;
        this.instruccionesIf = instruccionesIf;
        this.instruccionesElse = instruccionesElse;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Tabla t = new Tabla(tabla);
        Object valorCondicion = condicion.interpretar(t, tree);
        if (valorCondicion instanceof Excepcion) {
            return valorCondicion;
        }
        
        if (!(valorCondicion instanceof Boolean)) {
            Excepcion ex = new Excepcion("Semantico", "Se esperaba un valor booleano para la condicion", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }

        if ((Boolean) valorCondicion) {
            instruccionesIf.forEach(m -> {
                m.interpretar(t, tree);
            });
        } else {
            instruccionesElse.forEach(m -> {
                m.interpretar(t, tree);
            });
        }
        return null;
    }
}
