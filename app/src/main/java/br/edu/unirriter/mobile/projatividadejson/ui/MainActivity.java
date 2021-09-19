package br.edu.unirriter.mobile.projatividadejson.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import br.edu.unirriter.mobile.projatividadejson.R;
import br.edu.unirriter.mobile.projatividadejson.adapters.AlbumsAdapter;
import br.edu.unirriter.mobile.projatividadejson.adapters.PostsAdapter;
import br.edu.unirriter.mobile.projatividadejson.adapters.TodoAdapter;
import br.edu.unirriter.mobile.projatividadejson.model.Albums;
import br.edu.unirriter.mobile.projatividadejson.model.Posts;
import br.edu.unirriter.mobile.projatividadejson.model.Todo;
import br.edu.unirriter.mobile.projatividadejson.presenter.AlbumsPresenter;
import br.edu.unirriter.mobile.projatividadejson.presenter.PostsPresenter;
import br.edu.unirriter.mobile.projatividadejson.presenter.TodoPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoPresenter presenterTodo;
        PostsPresenter presenterPosts;
        AlbumsPresenter presenterAlbums;

        presenterTodo = new TodoPresenter(this);
        presenterPosts = new PostsPresenter(this);
        presenterAlbums = new AlbumsPresenter(this);

        Button btn = findViewById(R.id.btTodos);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterTodo.buscaJsons();
            }
        });

        btn = findViewById(R.id.btPosts);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterPosts.buscaJsons();

            }
        });

        btn = findViewById(R.id.btAlbums);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenterAlbums.buscaJsons();
            }
        });

    }

    public void preparaRecyclerView(RecyclerView.Adapter adapter){
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }
}