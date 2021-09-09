package br.edu.unirriter.mobile.projatividadejson.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.unirriter.mobile.projatividadejson.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoTodos = findViewById(R.id.btTodos);
        botaoTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TodosActivity.class);
                startActivity(intent);
            }
        });

        Button botaoPosts = findViewById(R.id.btPosts);
        botaoPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PostsActivity.class);
                startActivity(intent);
            }
        });

        Button botaoAlbums = findViewById(R.id.btAlbums);
        botaoAlbums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AlbumsActivity.class);
                startActivity(intent);
            }
        });
    }
}