package interpretejavacc;

import Abstract.AST;
import Analizador.Gramatica;
import Analizador.ParseException;
import Analizador.TokenMgrError;
import Excepciones.Excepcion;
import Expresiones.Funcion;
import Expresiones.Retorno;
import Instrucciones.Declaracion;
import Instrucciones.Detener;
import Nativas.aMayuscula;
import Nativas.pieChart;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import TablaSimbolos.Tipo;
import TablaSimbolos.Tipo.Tipos;
import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Pavel
 */
public class UIController implements Initializable {

    @FXML
    private TextArea entrada;
    @FXML
    private Button btnEjecutar;
    @FXML
    private TextArea consola;
    @FXML
    private Group groupChart;

    @FXML
    private void Ejecutar(ActionEvent event) {
        consola.clear();
        if (entrada.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Entrada vacia");
            alert.setHeaderText(null);
            alert.setContentText("La entrada a ejecutar se encuentra vacia!");
            alert.showAndWait();
            return;
        }
        try {
            Gramatica parser = new Gramatica(new BufferedReader(new StringReader(entrada.getText())));
            Arbol arbol = parser.Analizar();
            EjecutarInstrucciones(arbol);
        } catch (ParseException e) {
            consola.setText(consola.getText() + e.getMessage() + "\n");
            System.err.println(e.getMessage());
        } catch (TokenMgrError e) {
            consola.setText(consola.getText() + e.getMessage() + "\n");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void EjecutarInstrucciones(Arbol tree) {
        tree.setConsola(consola);
        tree.setGrupo(groupChart);
        Tabla tabla = new Tabla(null);
        tree.setGlobal(tabla);
        crearNativas(tabla);
        // Recorrido 1 para insertar funciones
        tree.getInstrucciones().forEach(m -> {
            if (m instanceof Funcion) {
                tabla.setFuncion((Funcion) m);
            }
        });
        tree.getInstrucciones().forEach(m -> {
            if (!(m instanceof Funcion)) {
                Object result = m.interpretar(tabla, tree);

                if (result instanceof Excepcion) {
                    ((Excepcion) result).imprimir(tree.getConsola());
                }
                if (result instanceof Detener) {
                    Excepcion ex = new Excepcion("Semantico", "Sentencia break fuera de ciclo.", m.fila, m.columna);
                    tree.getExcepciones().add(ex);
                    ex.imprimir(tree.getConsola());
                } else if (result instanceof Retorno) {
                    Excepcion ex = new Excepcion("Semantico", "Sentencia retorno fuera de funcion.", m.fila, m.columna);
                    tree.getExcepciones().add(ex);
                    ex.imprimir(tree.getConsola());
                }
            }
        });

        tree.getExcepciones().forEach(m -> {
            System.out.println("" + m.toString());
        });
    }
    
    public void crearNativas(Tabla t){
        Tipo tipo = new Tipo(Tipo.Tipos.CADENA);
        String nombre = "toUpper";
        ArrayList<AST> parametros = new ArrayList<>();
        parametros.add(new Declaracion(tipo, "toUpper%%parametro1", null, -1, -1));
        ArrayList<AST> instrucciones = new ArrayList<>();
        aMayuscula am = new aMayuscula(tipo, nombre, parametros, instrucciones, -1, -1);
        t.setFuncion(am);
        
        tipo = new Tipo(Tipo.Tipos.CADENA);
        nombre = "pie";
        parametros = new ArrayList<>();
        parametros.add(new Declaracion(new Tipo(Tipos.LISTA), "pie%%parametro1", null, -1, -1));
        parametros.add(new Declaracion(new Tipo(Tipos.LISTA), "pie%%parametro2", null, -1, -1));
        parametros.add(new Declaracion(new Tipo(Tipos.CADENA), "pie%%parametro3", null, -1, -1));
        instrucciones = new ArrayList<>();
        pieChart pc = new pieChart(tipo, nombre, parametros, instrucciones, -1, -1);
        t.setFuncion(pc);
    }
}
