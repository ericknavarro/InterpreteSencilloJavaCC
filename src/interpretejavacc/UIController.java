package interpretejavacc;

import Analizador.Gramatica;
import Analizador.ParseException;
import Analizador.TokenMgrError;
import Excepciones.Excepcion;
import TablaSimbolos.Arbol;
import TablaSimbolos.Tabla;
import java.io.BufferedReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

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
        Tabla tabla = new Tabla(null);
        
        tree.getInstrucciones().forEach(m -> {
            Object result = m.interpretar(tabla, tree);
            if(result instanceof Excepcion){
                ((Excepcion)result).imprimir(tree.getConsola());
            }
        });
    }
}
