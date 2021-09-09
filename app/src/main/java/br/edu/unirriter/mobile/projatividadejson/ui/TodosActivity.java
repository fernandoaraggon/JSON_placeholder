package br.edu.unirriter.mobile.projatividadejson.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import br.edu.unirriter.mobile.projatividadejson.R;

public class TodosActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
        Response.ErrorListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos",null,
                this,this);
        queue.add(requisicao);
    }


    @Override
    public void onResponse(JSONArray response) {
        EditText ed = findViewById(R.id.todos);
        ed.setText(response.toString());
        /*
        try {
            ed.setText(response.length()+"\n"+response.getJSONObject(50).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        EditText ed = findViewById(R.id.todos);
        ed.setText(error.getMessage());
    }
}