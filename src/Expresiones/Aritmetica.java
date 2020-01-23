package Expresiones;

import Excepciones.Excepcion;
import Abstract.AST;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import TablaSimbolos.Tipo.Tipos;

/**
 *
 * @author Pavel
 */
public class Aritmetica extends AST {

    public static enum OperadorAritmetico {

        SUMA,
        RESTA,
        MULTIPLICACION,
        DIVISION,
        MENOSUNARIO
    }

    private AST operando1;
    private AST operando2;
    private AST operandoU;
    private OperadorAritmetico operador;

    public Aritmetica(AST operando1, AST operando2, OperadorAritmetico operador, int fila, int columna) {
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.operador = operador;
        this.fila = fila;
        this.columna = columna;
    }

    public Aritmetica(AST operandoU, OperadorAritmetico operador, int fila, int columna) {
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

        if (this.operador == OperadorAritmetico.SUMA) {
            if (operando1.tipo.getTipos() == Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipos.NUMERO) {
                this.tipo = new Tipo(Tipos.NUMERO);
                return (double) izquierdo + (double) derecho;
            } else if (operando1.tipo.getTipos() == Tipos.CADENA
                    && operando2.tipo.getTipos() == Tipos.NUMERO
                    || operando1.tipo.getTipos() == Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipos.CADENA
                    || operando1.tipo.getTipos() == Tipos.CADENA
                    && operando2.tipo.getTipos() == Tipos.CADENA) {
                this.tipo = new Tipo(Tipos.CADENA);
                return "" + izquierdo + derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador +", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorAritmetico.RESTA) {
            if (operando1.tipo.getTipos() == Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipos.NUMERO) {
                this.tipo = new Tipo(Tipos.NUMERO);
                return (double) izquierdo - (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador -", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorAritmetico.MULTIPLICACION) {
            if (operando1.tipo.getTipos() == Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipos.NUMERO) {
                this.tipo = new Tipo(Tipos.NUMERO);
                return (double) izquierdo * (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador *", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorAritmetico.DIVISION) {
            if (operando1.tipo.getTipos() == Tipos.NUMERO
                    && operando2.tipo.getTipos() == Tipos.NUMERO) {
                if ((double) derecho == 0) {
                    return new Excepcion("Semantico", "Excepcion aritmetica, division por 0.", fila, columna);
                }
                this.tipo = new Tipo(Tipos.NUMERO);
                return (double) izquierdo / (double) derecho;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador /", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        } else if (this.operador == OperadorAritmetico.MENOSUNARIO) {
            if (operandoU.tipo.getTipos() == Tipos.NUMERO) {
                this.tipo = new Tipo(Tipos.NUMERO);
                return (double) unario * -1;
            } else {
                Excepcion ex = new Excepcion("Semantico", "Error de tipos con el operador - Unario", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
        }
        return null;
    }
}
