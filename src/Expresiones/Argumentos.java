/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresiones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import TablaSimbolos.Tipo.Tipos;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class Argumentos extends AST {

    ArrayList<AST> expresiones;

    public Argumentos(ArrayList<AST> expresiones, int fila, int columna) {
        this.expresiones = expresiones;
        this.fila = fila;
        this.columna = columna;
        this.tipo = new Tipo(Tipos.LISTA);
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        ArrayList<Object> valoresExplicitos = new ArrayList<>();
        for(AST ast : expresiones){
            Object result = ast.interpretar(tabla, tree);
            if(result instanceof Excepcion){
                return result;
            }
            valoresExplicitos.add(result);
        }
        return valoresExplicitos;
    }
}
