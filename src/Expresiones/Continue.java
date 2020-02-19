/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Expresiones;

import Abstract.AST;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;

/**
 *
 * @author Pavel
 */
public class Continue extends AST {

    public Continue() {
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        return this;

    }

}
