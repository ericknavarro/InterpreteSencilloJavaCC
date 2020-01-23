package Instrucciones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Simbolo;
import TablaSimbolos.Tabla;

/**
 *
 * @author Pavel
 */
public class Asignacion extends AST {

    private String identificador;
    private AST valor;

    public Asignacion(String identificador, AST valor, int fila, int columna) {
        this.identificador = identificador;
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Object value = this.valor.interpretar(tabla, tree);
        if (value instanceof Excepcion) return value;
        
        Simbolo simbolo = tabla.getVariable(identificador);
        if (simbolo == null) {
            Excepcion ex = new Excepcion("Semantico", "No se ha encontrado la variable " + identificador + ".", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }

        if (!simbolo.getTipo().equals(valor.tipo)) {
            Excepcion ex = new Excepcion("Semantico",
                    "El tipo de la variable y el tipo del valor no coinciden.",
                    fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }

        simbolo.setValor(value);
        return null;
    }
}
