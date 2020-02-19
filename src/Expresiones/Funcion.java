package Expresiones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class Funcion extends AST {
    protected String nombre;
    protected ArrayList<AST> parametros;
    private ArrayList<AST> instrucciones;

    public Funcion(Tipo tipo, String nombre, ArrayList<AST> parametros, ArrayList<AST> instrucciones, int fila, int columna) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.parametros = parametros;
        this.instrucciones = instrucciones;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        for (AST ins : instrucciones) {
            Object result = ins.interpretar(tabla, tree);
            if (result instanceof Excepcion) {
                return result;
            }
            if (result instanceof Retorno) {
                Retorno r = (Retorno) result;
                if (r.getExpresion() == null) {
                    return null;
                }
                result = r.getExpresion().interpretar(tabla, tree);
                return result;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<AST> getParametros() {
        return parametros;
    }
}
