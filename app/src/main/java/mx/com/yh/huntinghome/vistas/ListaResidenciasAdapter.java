package mx.com.yh.huntinghome.vistas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.EntidadListaReidencia;

public class ListaResidenciasAdapter extends ArrayAdapter<EntidadListaReidencia> {

    Context context;
    int layoutResource;
    EntidadListaReidencia datos[]=null;


    public ListaResidenciasAdapter(Context context, int layoutResource, EntidadListaReidencia[] datos) {
        super(context, layoutResource,datos);
        this.context = context;
        this.layoutResource = layoutResource;
        this.datos = datos;
    }

    public View getView(int poscion, View convertView, ViewGroup parent){
        View row=convertView;
        ResidenciasHolder resHold=new ResidenciasHolder();

        if(row==null){
            row=LayoutInflater.from(this.context).inflate(R.layout.activity_list_item_residencias,parent,false);

            resHold.cv=(CardView) row.findViewById(R.id.cvRes);
            resHold.imgUsr=(ImageView) row.findViewById(R.id.ivImgUsr);
            resHold.imgRes=(ImageButton) row.findViewById(R.id.ivImgResidencia);
            resHold.btnNomUsr=(Button) row.findViewById(R.id.btnNameUsr);
            resHold.munRes=(TextView) row.findViewById(R.id.tvMunicipioRes);
            resHold.estRes=(TextView) row.findViewById(R.id.tvEstadoRes);
            resHold.colRes=(TextView) row.findViewById(R.id.tvComunidadRes);
            resHold.tipoRes=(TextView) row.findViewById(R.id.tvTipoRes);
            resHold.precioRes=(TextView) row.findViewById(R.id.tvPrecioRes);
            resHold.meGusta=(CheckBox) row.findViewById(R.id.cbMeGusta);
            row.setTag(resHold);
        }else {
            resHold=(ResidenciasHolder)row.getTag();
        }
        EntidadListaReidencia res=null;
        setListRes(resHold,res,poscion);
        return row;
    }

    static class ResidenciasHolder{
        CardView cv;
        ImageView imgUsr;
        ImageButton imgRes;
        Button btnNomUsr;
        TextView munRes, estRes, colRes, tipoRes, precioRes;
        CheckBox meGusta;
    }

    public void setListRes(ResidenciasHolder holder, EntidadListaReidencia res, int posicion){
        res=datos[posicion];
        holder.cv.setRadius(20);
        holder.cv.setCardBackgroundColor(Color.WHITE);
        holder.imgUsr.setImageResource(res.getImgUsr());
        holder.imgRes.setImageResource(res.getImgRes());
        holder.btnNomUsr.setText(res.getBtnNomUsr());
        holder.munRes.setText(res.getMunRes());
        holder.estRes.setText(res.getEstRes());
        holder.colRes.setText(res.getColRes());
        holder.tipoRes.setText(res.getTipoRes());
        holder.precioRes.setText(res.getPrecioRes());
        holder.meGusta.setChecked(res.isMeGusta());
    }

}