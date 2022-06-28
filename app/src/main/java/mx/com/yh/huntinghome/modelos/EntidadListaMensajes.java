package mx.com.yh.huntinghome.modelos;

public class EntidadListaMensajes {

    private String nombreUsrMsg;
    private int imgUsrMsg;

    public EntidadListaMensajes() {
    }

    public EntidadListaMensajes(String nombreUsrMsg, int imgUsrMsg) {
        this.nombreUsrMsg = nombreUsrMsg;
        this.imgUsrMsg = imgUsrMsg;
    }

    public String getNombreUsrMsg() {
        return nombreUsrMsg;
    }

    public void setNombreUsrMsg(String nombreUsrMsg) {
        this.nombreUsrMsg = nombreUsrMsg;
    }

    public int getImgUsrMsg() {
        return imgUsrMsg;
    }

    public void setImgUsrMsg(int imgUsrMsg) {
        this.imgUsrMsg = imgUsrMsg;
    }
}
