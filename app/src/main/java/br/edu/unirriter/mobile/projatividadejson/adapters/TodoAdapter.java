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
import br.edu.unirriter.mobile.projatividadejson.model.Todo;


public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Todo> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public TodoAdapter(List<Todo> todos) {
        this.dados = todos;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.json_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewHolder holder, int position) {
        Todo todo = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTitulo);
        tv.setText(todo.getTitle());
        tv = holder.view.findViewById(R.id.tvIdUser);
        tv.setText(""+todo.getUser_id());
        Switch sw = holder.view.findViewById(R.id.swTodoCompleto);
        sw.setChecked(todo.isCompleted());

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}