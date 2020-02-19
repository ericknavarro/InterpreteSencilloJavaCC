package Nativas;

import Abstract.AST;
import Excepciones.Excepcion;
import Expresiones.Funcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Simbolo;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class aMayuscula extends Funcion {

    public aMayuscula(Tipo tipo, String nombre, ArrayList<AST> parametros, ArrayList<AST> instrucciones, int fila, int columna) {
        super(tipo, nombre, parametros, instrucciones, fila, columna);
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Simbolo simbolo = tabla.getVariable("toUpper%%parametro1");
        if (simbolo == null) {
            Excepcion ex = new Excepcion("Semantico", "No se ha encontrado la variable " + this.nombre + ".", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        if (!simbolo.getTipo().equals(new Tipo(Tipo.Tipos.CADENA))) {
            Excepcion ex = new Excepcion("Semantico", "El tipo de los parametros no coinciden.", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        return (simbolo.getValor() + "").toUpperCase();
    }

}
