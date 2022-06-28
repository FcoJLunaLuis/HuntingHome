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

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.EntidadListaMensajes;

public class ListaMensajesAdapter extends ArrayAdapter<EntidadListaMensajes> {

    Context context;
    int layoutResource;
    EntidadListaMensajes datos[]=null;


    public ListaMensajesAdapter(Context context, int layoutResource, EntidadListaMensajes[] datos) {
        super(context, layoutResource,datos);
        this.context = context;
        this.layoutResource = layoutResource;
        this.datos = datos;
    }

    public View getView(int poscion, View convertView, ViewGroup parent){
        View row=convertView;
        ResidenciasHolder resHold=new ResidenciasHolder();

        if(row==null){
            row= LayoutInflater.from(this.context).inflate(R.layout.fragment_list_message_items,parent,false);
            resHold.cv=(CardView) row.findViewById(R.id.cvMsg);
            resHold.imgUsrMsg=(ImageView) row.findViewById(R.id.ivUsrMsgImg);
            resHold.btnNomUsrMsg=(Button) row.findViewById(R.id.btnUsrMsgName);
            row.setTag(resHold);
        }else {
            resHold=(ResidenciasHolder)row.getTag();
        }
        EntidadListaMensajes res=null;
        setListRes(resHold,res,poscion);
        return row;
    }

    static class ResidenciasHolder{
        CardView cv;
        ImageView imgUsrMsg;
        Button btnNomUsrMsg;
    }

    public void setListRes(ResidenciasHolder holder,EntidadListaMensajes res,int posicion){
        res=datos[posicion];
        holder.cv.setRadius(20);
        holder.cv.setCardBackgroundColor(Color.WHITE);
        holder.imgUsrMsg.setImageResource(res.getImgUsrMsg());
        holder.btnNomUsrMsg.setText(res.getNombreUsrMsg());
    }
}
