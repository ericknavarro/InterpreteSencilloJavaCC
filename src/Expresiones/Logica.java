package Expresiones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import TablaSimbolos.Tipo.Tipos;

/**
 *
 * @author Pavel
 */
public class Logica extends AST {

    public static enum OperadorLogico {

        AND,
        OR,
        NOT
    }

    private AST operando1;
    private AST operando2;
    private AST operandoU;
    private OperadorLogico operador;

    public Logica(AST operando1, AST operando2, OperadorLogico operador, int fila, int columna) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
        this.fila = fila;
        this.columna = columna;
    }

    public Logica(AST operandoU, OperadorLogico operador, int fila, int columna) {
        this.operandoU = operandoU;
        this.operador = operador;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Object izquierdo = null, derecho = null, unario = null;

        if (this.operandoU == null) {
            izquierdo = this.operando1.interpretar(tabla, tree);
            if (izquierdo instanceof Excepcion) return izquierdo;

            derecho = this.operando2.interpretar(tabla, tree);
            if (derecho instanceof Excepcion) return derecho; 
        } else {
            unario = this.operandoU.interpretar(tabla, tree);
            if (unario instanceof Excepcion) return unario;
        }
        this.tipo = new Tipo(Tipos.BOOLEANO);
        if (this.operador == OperadorLogico.AND) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.BOOLEANO
                    && operando2.tipo.getTipos() == Tipo.Tipos.BOOLEANO) {
                return (boolean) izquierdo && (boolean) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador AND", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorLogico.OR) {
            if (operando1.tipo.getTipos() == Tipo.Tipos.BOOLEANO
                    && operando2.tipo.getTipos() == Tipo.Tipos.BOOLEANO) {
                return (boolean) izquierdo || (boolean) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador OR", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorLogico.NOT) {
            if (operandoU.tipo.getTipos() == Tipo.Tipos.BOOLEANO) {
                return !((boolean) unario);
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador NOT", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        }
        return null;
    }
}
