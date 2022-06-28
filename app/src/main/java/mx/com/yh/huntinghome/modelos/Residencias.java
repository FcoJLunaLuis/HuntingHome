package mx.com.yh.huntinghome.modelos;

import java.io.Serializable;

public class Residencias implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idResidencia,idUuario,idTipo,numInt,
            numExt,idMunicipio,idEstado,precio;
    private String calle ,colonia,detalles;
    private boolean mascotas,deposito;
    private Estado estado;
    private Municipio municipio;
    private TipoResidencia tipoRes;

    public Residencias() {
    }

    public Residencias(int idResidencia, int idUuario, int idTipo,
                       int numInt, int numExt, int idMunicipio, int idEstado,
                       int precio, String calle, String colonia, String detalles,
                       boolean mascotas, boolean deposito) {
        this.idResidencia = idResidencia;
        this.idUuario = idUuario;
        this.idTipo = idTipo;
        this.numInt = numInt;
        this.numExt = numExt;
        this.idMunicipio = idMunicipio;
        this.idEstado = idEstado;
        this.precio = precio;
        this.calle = calle;
        this.colonia = colonia;
        this.detalles = detalles;
        this.mascotas = mascotas;
        this.deposito = deposito;
    }

    public int getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(int idResidencia) {
        this.idResidencia = idResidencia;
    }

    public int getIdUuario() {
        return idUuario;
    }

    public void setIdUuario(int idUuario) {
        this.idUuario = idUuario;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public int getNumInt() {
        return numInt;
    }

    public void setNumInt(int numInt) {
        this.numInt = numInt;
    }

    public int getNumExt() {
        return numExt;
    }

    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public boolean isMascotas() {
        return mascotas;
    }

    public void setMascotas(boolean mascotas) {
        this.mascotas = mascotas;
    }

    public boolean isDeposito() {
        return deposito;
    }

    public void setDeposito(boolean deposito) {
        this.deposito = deposito;
    }
}
