package mx.com.yh.huntinghome.vistas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.EntidadListaMensajes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListaMensajes extends Fragment {
    ListView listView;

    EntidadListaMensajes elm[]=new EntidadListaMensajes[]{
            new EntidadListaMensajes("Rafael Hernández",R.drawable.img_usr1),
            new EntidadListaMensajes("Enrrique Gutiérrez",R.drawable.img_usr2),
            new EntidadListaMensajes("Gabriel Cervantes",R.drawable.img_usr3)
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_mensajes, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)getView().findViewById(R.id.lvListMessages);
        ListaMensajesAdapter adapter = new ListaMensajesAdapter(getActivity().getApplicationContext(), R.layout.fragment_lista_mensajes,elm);
        listView.setAdapter(adapter);
    }
}
