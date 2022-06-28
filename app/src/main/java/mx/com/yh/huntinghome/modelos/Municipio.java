package mx.com.yh.huntinghome.modelos;

import java.io.Serializable;

public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idMunicipio;
    private String nombreMunicipio;

    public Municipio() {
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }
}
