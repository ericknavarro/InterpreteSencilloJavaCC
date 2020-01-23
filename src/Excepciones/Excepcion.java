package Excepciones;

import javafx.scene.control.TextArea;

/**
 *
 * @author Pavel
 */
public class Excepcion {
    private String tipo;
    private String descripcion;
    private int fila;
    private int columna;

    public Excepcion(String tipo, String descripcion, int fila, int columna) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fila = fila;
        this.columna = columna;
    }

    @Override
    public String toString() {
        return tipo + " - " + descripcion + " [" + fila + ", " + columna + "]";
    }
    
    public void imprimir(TextArea consola){
        consola.setText(consola.getText() + this.toString() + "\n");
    }
}
