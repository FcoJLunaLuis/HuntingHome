package mx.com.yh.huntinghome.modelos;

import java.io.Serializable;

public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idEstado;
    private String nombreEstado;

    public Estado() {
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
