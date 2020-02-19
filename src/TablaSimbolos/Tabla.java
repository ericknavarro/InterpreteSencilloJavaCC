package TablaSimbolos;

import Expresiones.Funcion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pavel
 */
public class Tabla {

    private Map<String, Simbolo> Table;
    private Tabla Anterior;
    private ArrayList<Funcion> funciones;

    public Tabla(Tabla Anterior) {
        this.Table = new HashMap<>();
        this.Anterior = Anterior;
        this.funciones = new ArrayList<>();
    }

    public String setVariable(Simbolo simbolo) {
        for (Tabla e = this; e != null; e = e.getAnterior()) {
            Simbolo encontro = (Simbolo) (e.getTable().get(simbolo.getIdentificador()));
            if (encontro != null) {
                return "La variable con el identificador"
                        + simbolo.getIdentificador() + " ya existe.";
            }
        }
        this.Table.put(simbolo.getIdentificador(), simbolo);
        return null;
    }

    public Simbolo getVariable(String id) {
        for (Tabla e = this; e != null; e = e.getAnterior()) {
            Simbolo encontro = (Simbolo) (e.getTable().get(id));
            if (encontro != null) {
                return encontro;
            }
        }
        return null;
    }

    public String setFuncion(Funcion f) {
        for (Funcion i : funciones) {
            if (f.getNombre().equalsIgnoreCase(i.getNombre())) {
                return "La funcion con el identificador"
                        + f.getNombre() + " ya existe.";
            }
        }
        this.funciones.add(f);
        return null;
    }

    public Funcion getFuncion(String nombre) {
        for (Tabla e = this; e != null; e = e.getAnterior()) {
            for (Funcion f : e.getFunciones()) {
                if (f.getNombre().equalsIgnoreCase(nombre)) {
                    return f;
                }
            }
        }
        return null;
    }

    public Map<String, Simbolo> getTable() {
        return Table;
    }

    public void setTable(Map<String, Simbolo> Table) {
        this.Table = Table;
    }

    public Tabla getAnterior() {
        return Anterior;
    }

    public void setAnterior(Tabla Anterior) {
        this.Anterior = Anterior;
    }

    public ArrayList<Funcion> getFunciones() {
        return funciones;
    }
}
