package Instrucciones;

import Abstract.AST;
import Excepciones.Excepcion;
import Expresiones.Continue;
import Expresiones.Retorno;
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
        Object result = null;
        if ((Boolean) valorCondicion) {
            for (AST m : instruccionesIf) {
                result = m.interpretar(t, tree);
                if (result instanceof Retorno || result instanceof Excepcion 
                        || result instanceof Detener || result instanceof Continue) {
                    return result;
                }
            }
        } else {
            for (AST m : instruccionesElse) {
                result = m.interpretar(t, tree);
                if (result instanceof Retorno || result instanceof Excepcion 
                        || result instanceof Detener || result instanceof Continue) {
                    return result;
                }
            }
        }
        
        return null;
    }
}
