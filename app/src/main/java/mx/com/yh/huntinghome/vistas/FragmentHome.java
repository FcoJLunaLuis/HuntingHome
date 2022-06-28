package mx.com.yh.huntinghome.vistas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.EntidadListaReidencia;

public class FragmentHome extends Fragment {

    ListView listView;
    EntidadListaReidencia elr[]=new EntidadListaReidencia[]{
            new EntidadListaReidencia(R.drawable.img_usr1,R.drawable.img_res1,
                    "Guadalupe","Zacatecas","Casa Blanca",
                    "Habitación","1000","Gabriel Cerbantes",true),
            new EntidadListaReidencia(R.drawable.img_usr2,R.drawable.img_res2,
                    "Guadalupe","Zacatecas","Villas",
                    "habitacion","1300","Rafael",false),
            new EntidadListaReidencia(R.drawable.img_usr3,R.drawable.img_res3,
                    "Guadalupe","Zacatecas","Villas",
                    "habitacion","1300","Rafael",true)
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = (ListView)getView().findViewById(R.id.lvShowResidences);
        ListaResidenciasAdapter adapter = new ListaResidenciasAdapter(getActivity().getApplicationContext(), R.layout.activity_list_item_residencias,elr);
        listView.setAdapter(adapter);
    }
}