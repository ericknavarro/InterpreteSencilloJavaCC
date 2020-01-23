/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresiones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Simbolo;
import TablaSimbolos.Tabla;

/**
 *
 * @author Pavel
 */
public class Identificador extends AST {
    private String identificador;
    
    public Identificador(String identificador, int fila, int columna){
        this.identificador = identificador;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Simbolo simbolo = tabla.getVariable(identificador);
        if (simbolo == null) {
            Excepcion ex = new Excepcion("Semantico", "No se ha encontrado la variable " + identificador + ".", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        this.tipo = simbolo.getTipo();
        return simbolo.getValor();
    }
}
