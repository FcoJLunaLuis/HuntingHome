package mx.com.yh.huntinghome.modelos;

public class Constantes {
    private static final String REGISTRO_USUARIO = "http://18.222.157.105/api.hh.com/v1/usuarios/registro";
    private static final String LOGIN_USUARIO = "http://18.222.157.105/api.hh.com/v1/usuarios/login";
    private static final String REGISTRO_RESIDECIA = "http://18.222.157.105/api.hh.com/v1/residencias/";
    private static final String EMAILPATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public Constantes() {
    }

    public String getRegistroUsuario() {
        return REGISTRO_USUARIO;
    }

    public String getLoginUsuario() {
        return LOGIN_USUARIO;
    }

    public String getRegistroResidecia() {
        return REGISTRO_RESIDECIA;
    }

    public String getEmailPattern() {
        return EMAILPATTERN;
    }
}
