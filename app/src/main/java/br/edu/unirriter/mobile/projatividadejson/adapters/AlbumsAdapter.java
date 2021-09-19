package br.edu.unirriter.mobile.projatividadejson.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.unirriter.mobile.projatividadejson.R;
import br.edu.unirriter.mobile.projatividadejson.model.Albums;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {


    private List<Albums> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public AlbumsAdapter(List<Albums> albums) {
        this.dados = albums;
    }

    @NonNull
    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.json_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumsAdapter.ViewHolder holder, int position) {
        Albums albums = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTitulo);
        tv.setText(albums.getTitle());
        tv = holder.view.findViewById(R.id.tvIdUser);
        tv.setText(""+albums.getUser_id());

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

}