package mx.com.yh.huntinghome.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.Usuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class PerfilUsr extends Fragment {

    Usuario user;
    private ImageView ivImgUser,ivEditPerfil, ivResMeGusta, ivVerMisRes;
    private TextView tvNomUser;
    private Button btnEditPerfil, btnResMeGusta, btnVermisRes;

    public PerfilUsr() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perfil_usr, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ivImgUser=(ImageView)getView().findViewById(R.id.ivImgUsrPerfil);
        tvNomUser=(TextView)getView().findViewById(R.id.tvNomUsrPerfil);
        ivEditPerfil=(ImageView)getView().findViewById(R.id.ivEdtPerfil);
        btnEditPerfil=(Button)getView().findViewById(R.id.btnEdtPerfil);
        ivResMeGusta=(ImageView)getView().findViewById(R.id.ivResMeGusta);
        btnResMeGusta=(Button)getView().findViewById(R.id.btnResMeGusta);
        ivVerMisRes=(ImageView)getView().findViewById(R.id.ivVerMisRes);
        btnVermisRes=(Button)getView().findViewById(R.id.btnVerMisRes);
        cambiaEstiloImagen();
    }

    public void cambiaEstiloImagen(){
        ivImgUser.setImageResource(R.drawable.img_usr1);
        ivEditPerfil.setImageResource(R.drawable.ic_edit);
        ivEditPerfil.setColorFilter(getContext().getColor(R.color.gray));
        ivResMeGusta.setImageResource(R.drawable.ic_favorite_black_24dp);
        ivResMeGusta.setColorFilter(getContext().getColor(R.color.gray));
        ivVerMisRes.setImageResource(R.drawable.ic_home_black);
        ivVerMisRes.setColorFilter(getContext().getColor(R.color.gray));
    }
}
