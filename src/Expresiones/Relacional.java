package Expresiones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;

/**
 *
 * @author Pavel
 */
public class Relacional extends AST {

    public static enum OperadorRelacional {

        MAYORQUE,
        MENORQUE,
        MAYORIGUAL,
        MENORIGUAL,
        IGUALACION,
        DIFERENCIACION
    }

    private AST operando1;
    private AST operando2;
    private OperadorRelacional operador;

    public Relacional(AST operando1, AST operando2, OperadorRelacional operador, int fila, int columna) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Object izquierdo = null, derecho = null;

        izquierdo = this.operando1.interpretar(tabla, tree);
        if (izquierdo instanceof Excepcion) return izquierdo;

        derecho = this.operando2.interpretar(tabla, tree);
        if (derecho instanceof Excepcion) return derecho;
        
        this.tipo = new Tipo(Tipo.Tipos.BOOLEANO);
        if (this.operador == OperadorRelacional.MENORQUE) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipo.Tipos.NUMERO) {
                return (double) izquierdo < (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador <", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorRelacional.MAYORQUE) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipo.Tipos.NUMERO) {
                return (double) izquierdo > (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador >", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorRelacional.MAYORIGUAL) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipo.Tipos.NUMERO) {
                return (double) izquierdo >= (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador >=", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorRelacional.MENORIGUAL) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipo.Tipos.NUMERO) {
                return (double) izquierdo <= (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador <=", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorRelacional.IGUALACION) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipo.Tipos.NUMERO) {
                return (double) izquierdo == (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador ==", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorRelacional.DIFERENCIACION) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipo.Tipos.NUMERO) {
                return (double) izquierdo != (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador !=", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        }
        return null;
    }
}
