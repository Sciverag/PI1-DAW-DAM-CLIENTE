package es.ieslavereda.activities.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.contenido.Capitulo;
import es.ieslavereda.base.ImageDownloader;


public class MiRecyclerViewCapitulos extends RecyclerView.Adapter<MiRecyclerViewCapitulos.ViewHolder> {

    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;

    private List<Capitulo> capitulos;

    public MiRecyclerViewCapitulos(Context context, List<Capitulo> capitulos){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.capitulos = capitulos;
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
        //Imagen
        ImageDownloader.downloadImage(capitulos.get(position).getUrl_image(), holder.imagen);
        //Titulo
        holder.titulo.setText(capitulos.get(position).getTitulo());
        //Valoracion media
        holder.valoracion.setText(estrellasPuntuacion(capitulos.get(position).getPuntMedia()));
        //Fecha
        holder.fecha.setVisibility(View.GONE);
        //Posicion en lista
        holder.numero.setText((position+1)>10 ? position+1+"" : "0"+position+1+"");
    }

    @Override
    public int getItemCount() {
        return capitulos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagen;
        private TextView titulo, valoracion, fecha, numero;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenPelicula);
            titulo = itemView.findViewById(R.id.textViewNombrePelicula);
            valoracion = itemView.findViewById(R.id.textViewPuntuacionPelicula);
            fecha = itemView.findViewById(R.id.textViewAnyo);
            numero = itemView.findViewById(R.id.textViewNumero);
        }
    }

    private String estrellasPuntuacion(float puntMedia) {
        String estrellas = "";
        float decimal = (puntMedia - (int) puntMedia);
        for (int i=0; i<(int)puntMedia; i++) {
            estrellas += "★";
        }
        if (decimal>=0.5f) {
            estrellas += "★";
        }
        if (puntMedia<0.5f) {
            return "★";
        }
        return estrellas;
    }


}
