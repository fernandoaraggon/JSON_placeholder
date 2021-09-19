package br.edu.unirriter.mobile.projatividadejson.presenter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import br.edu.unirriter.mobile.projatividadejson.adapters.PostsAdapter;
import br.edu.unirriter.mobile.projatividadejson.model.Posts;
import br.edu.unirriter.mobile.projatividadejson.ui.MainActivity;

public class PostsPresenter implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    private List<Posts> posts = new ArrayList<>();
    private MainActivity activity;

    public PostsPresenter(MainActivity act) {
        this.activity = act;
    }
    public void buscaJsons() {
        RequestQueue queue = Volley.newRequestQueue(activity.getApplicationContext());

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", null, this, this);
        queue.add(requisicao);
    }

        @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONArray response) {
        posts.clear();
        try {
            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    posts.add(new Posts(response.getJSONObject(i)));
                }
            }
            PostsAdapter adapter = new PostsAdapter(posts);
            activity.preparaRecyclerView(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
