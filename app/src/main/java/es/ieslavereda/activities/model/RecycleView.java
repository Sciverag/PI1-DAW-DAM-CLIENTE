package es.ieslavereda.activities.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.base.ImageDownloader;
import es.ieslavereda.base.Parameters;


public class RecycleView extends RecyclerView.Adapter<RecycleView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;
    private Root root;

    public RecycleView(Context context, Root root){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.root = root;
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.simple_element,parent,false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contenido contenido = root.list.get(position);
        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + contenido.imagen + Parameters.ICON_URL_POST, holder.imagen);
        holder.titulo.setText(contenido.titulo);
        holder.valoracion.setText(contenido.puntuacioMedia+"★");
        holder.descripcion.setText(contenido.descripcion);
    }

    @Override
    public int getItemCount() {
        return root.list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView titulo, valoracion, descripcion;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenPelicula);
            titulo = itemView.findViewById(R.id.textViewNombrePelicula);
            valoracion = itemView.findViewById(R.id.textViewPuntuacionPelicula);
            descripcion = itemView.findViewById(R.id.textViewDescripcionPelicula);
        }
    }



}
