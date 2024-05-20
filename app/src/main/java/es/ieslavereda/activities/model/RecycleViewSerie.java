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
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.base.ImageDownloader;


public class RecycleViewSerie extends RecyclerView.Adapter<RecycleViewSerie.ViewHolder> {

    private LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;

    private List<Serie> contenido;

    public RecycleViewSerie(Context context, List contenido){
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.contenido = contenido;
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
        //Titulo
        holder.titulo.setText(contenido.get(position).getTitulo());
        //Posicion en lista
        holder.numero.setText((position+1)>10 ? position+1+"" : "0"+position+1+"");
    }

    @Override
    public int getItemCount() {
        return contenido.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titulo, numero;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textViewNombrePelicula);
            numero = itemView.findViewById(R.id.textViewNumero);
        }
    }
}
