package Instrucciones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Simbolo;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;

/**
 *
 * @author Pavel
 */
public class Declaracion extends AST {

    private String identificador;
    private AST valor;

    public Declaracion(Tipo tipo, String identificador, AST valor, int fila, int columna) {
        this.tipo = tipo;
        this.identificador = identificador;
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Object value = null;
        if (valor != null) {
            value = this.valor.interpretar(tabla, tree);
            if (value instanceof Excepcion) return value;

            if (!this.tipo.equals(this.valor.tipo)) {
                Excepcion ex = new Excepcion("Semantico",
                        "El tipo de la variable y el tipo del valor no coinciden.",
                        fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        }
        Simbolo simbolo = new Simbolo(this.tipo, this.identificador, value);
        Object result = tabla.setVariable(simbolo);
        if (result != null) {
            Excepcion ex = new Excepcion("Semantico", result.toString(), fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        return null;
    }
}
