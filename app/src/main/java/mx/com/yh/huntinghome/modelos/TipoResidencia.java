package mx.com.yh.huntinghome.modelos;

import java.io.Serializable;

public class TipoResidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idTipoResidencia,numHabitaciones;
    private String tipoResidencia;

    public TipoResidencia() {
    }

    public TipoResidencia(int idTipoResidencia, int numHabitaciones,
                          String tipoResidencia) {
        this.idTipoResidencia = idTipoResidencia;
        this.numHabitaciones = numHabitaciones;
        this.tipoResidencia = tipoResidencia;
    }

    public int getIdTipoResidencia() {
        return idTipoResidencia;
    }

    public void setIdTipoResidencia(int idTipoResidencia) {
        this.idTipoResidencia = idTipoResidencia;
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }
}
