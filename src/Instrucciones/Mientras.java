package Instrucciones;

import Abstract.AST;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import java.util.ArrayList;

/**
 *
 * @author Pavel
 */
public class Mientras extends AST {

    private AST condicion;
    private ArrayList<AST> instrucciones;

    public Mientras(AST condicion, ArrayList<AST> instrucciones, int fila, int columna) {
        this.condicion = condicion;
        this.instrucciones = instrucciones;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        Object valorCondicion = false;
        do {
            Tabla t = new Tabla(tabla);
            valorCondicion = condicion.interpretar(t, tree);
            if (valorCondicion instanceof Excepcion) return valorCondicion;

            if (!(valorCondicion instanceof Boolean)) {
                Excepcion ex = new Excepcion("Semantico", "Se esperaba un valor booleano para la condicion", fila, columna);
                tree.getExcepciones().add(ex);
                return ex;
            }
            if((Boolean) valorCondicion){
                instrucciones.forEach(m -> {
                    m.interpretar(t, tree);
                });
            }
        } while ((Boolean) valorCondicion);

        return null;
    }
}
