package br.edu.unirriter.mobile.projatividadejson.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Posts implements Parcelable {
    private int id;
    private int user_id;
    private String title;
    private String body;

    public Posts(int id, int user_id, String title, String body) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.body = body;
    }
    public Posts(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.user_id = json.getInt("userId");
            this.title = json.getString("title");
            this.body = json.getString("body");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Posts(Parcel in) {
        id = in.readInt();
        user_id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<Posts> CREATOR = new Creator<Posts>() {
        @Override
        public Posts createFromParcel(Parcel in) {
            return new Posts(in);
        }

        @Override
        public Posts[] newArray(int size) {
            return new Posts[size];
        }
    };

    @Override
    public String toString() {
        return "id: "+id+"\n"+
                "Id usuário: "+user_id+"\n"+
                "Título: " + title+"\n"+
                "Conteudo: " + body+ "\n------------\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return id == posts.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.user_id);
        parcel.writeString(this.title);
        parcel.writeString(this.body);
    }
}
