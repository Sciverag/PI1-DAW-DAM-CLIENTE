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
import es.ieslavereda.base.ImageDownloader;

public class MiRecyclerViewCarrito extends RecyclerView.Adapter<MiRecyclerViewCarrito.ViewHolder> {

    private List<Contenido> contenidos;
    private Context context;

    public MiRecyclerViewCarrito(List<Contenido> contenidos, Context context) {
        this.contenidos = contenidos;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple_element_carrito, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contenido contenido = contenidos.get(position);
        holder.textViewNombre.setText(contenido.getTitulo());
        holder.textViewPrecio.setText("8");
        ImageDownloader.downloadImage(contenido.getUrl_image(), holder.imageViewProducto);
    }

    @Override
    public int getItemCount() {
        return contenidos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewNombre;
        TextView textViewPrecio;
        ImageView imageViewProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
            textViewPrecio = itemView.findViewById(R.id.textViewPrecio);
            imageViewProducto = itemView.findViewById(R.id.imageViewImagen);
        }
    }
}