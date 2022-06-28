package mx.com.yh.huntinghome.modelos;

import android.widget.Button;
import android.widget.CheckBox;

public class EntidadListaReidencia {

    private int imgUsr, imgRes;
    private String munRes,estRes,colRes,tipoRes,precioRes, btnNomUsr;
    private boolean meGusta;

    public EntidadListaReidencia() {
    }

    public EntidadListaReidencia(int imgUsr, int imgRes, String munRes, String estRes,
                                 String colRes, String tipoRes, String precioRes, String btnNomUsr,
                                 boolean meGusta) {
        this.imgUsr = imgUsr;
        this.imgRes = imgRes;
        this.munRes = munRes;
        this.estRes = estRes;
        this.colRes = colRes;
        this.tipoRes = tipoRes;
        this.precioRes = precioRes;
        this.btnNomUsr = btnNomUsr;
        this.meGusta = meGusta;
    }

    public int getImgUsr() {
        return imgUsr;
    }

    public void setImgUsr(int imgUsr) {
        this.imgUsr = imgUsr;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getMunRes() {
        return munRes;
    }

    public void setMunRes(String munRes) {
        this.munRes = munRes;
    }

    public String getEstRes() {
        return estRes;
    }

    public void setEstRes(String estRes) {
        this.estRes = estRes;
    }

    public String getColRes() {
        return colRes;
    }

    public void setColRes(String colRes) {
        this.colRes = colRes;
    }

    public String getTipoRes() {
        return tipoRes;
    }

    public void setTipoRes(String tipoRes) {
        this.tipoRes = tipoRes;
    }

    public String getPrecioRes() {
        return precioRes;
    }

    public void setPrecioRes(String precioRes) {
        this.precioRes = precioRes;
    }

    public String getBtnNomUsr() {
        return btnNomUsr;
    }

    public void setBtnNomUsr(String btnNomUsr) {
        this.btnNomUsr = btnNomUsr;
    }

    public boolean isMeGusta() {
        return meGusta;
    }

    public void setMeGusta(boolean meGusta) {
        this.meGusta = meGusta;
    }
}
