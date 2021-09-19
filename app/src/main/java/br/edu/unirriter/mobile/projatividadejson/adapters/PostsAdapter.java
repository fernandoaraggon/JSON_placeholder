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
import br.edu.unirriter.mobile.projatividadejson.model.Posts;


public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Posts> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public PostsAdapter(List<Posts> posts) {
        this.dados = posts;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.json_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        Posts posts = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTitulo);
        tv.setText(posts.getTitle());
        tv = holder.view.findViewById(R.id.tvIdUser);
        tv.setText(""+posts.getUser_id());

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}