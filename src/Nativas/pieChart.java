package Nativas;

import Abstract.AST;
import Excepciones.Excepcion;
import Expresiones.Funcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Simbolo;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import java.util.ArrayList;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Pavel
 */
public class pieChart extends Funcion {

    public pieChart(Tipo tipo, String nombre, ArrayList<AST> parametros, ArrayList<AST> instrucciones, int fila, int columna) {
        super(tipo, nombre, parametros, instrucciones, fila, columna);
    }

    @Override
    public Object interpretar(Tabla tabla, Arbol tree) {
        ArrayList<Object> valores;
        ArrayList<Object> labels;
        String nombrePie;

        Simbolo simbolo = tabla.getVariable("pie%%parametro1");
        if (simbolo == null) {
            Excepcion ex = new Excepcion("Semantico", "No se ha encontrado la variable " + this.nombre + ".", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        valores = (ArrayList<Object>) simbolo.getValor();

        simbolo = tabla.getVariable("pie%%parametro2");
        if (simbolo == null) {
            Excepcion ex = new Excepcion("Semantico", "No se ha encontrado la variable " + this.nombre + ".", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        labels = (ArrayList<Object>) simbolo.getValor();

        simbolo = tabla.getVariable("pie%%parametro3");
        if (simbolo == null) {
            Excepcion ex = new Excepcion("Semantico", "No se ha encontrado la variable " + this.nombre + ".", fila, columna);
            tree.getExcepciones().add(ex);
            return ex;
        }
        nombrePie = simbolo.getValor() + "";
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (int i = 0; i < labels.size(); i++) {
            pieChartData.add(new PieChart.Data(labels.get(i) + "", (Double) valores.get(i)));
        }
        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle(nombrePie);
        tree.getGrupo().getChildren().clear();
        tree.getGrupo().getChildren().add(pieChart);
        pieChart.setPrefSize(360, 315);
        pieChartData.forEach(data
                -> data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), ": ", data.pieValueProperty(), ""
                        )
                )
        );
        return null;
    }
}
