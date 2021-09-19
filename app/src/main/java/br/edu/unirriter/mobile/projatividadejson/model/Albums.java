package br.edu.unirriter.mobile.projatividadejson.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Albums implements Parcelable {
    private int id;
    private int user_id;
    private String title;
    private boolean completed;

    public Albums(int id, int user_id, String title) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
    }
    public Albums(JSONObject json) {
        super();
        try {
            this.id = json.getInt("id");
            this.user_id = json.getInt("userId");
            this.title = json.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected Albums(Parcel in) {
        id = in.readInt();
        user_id = in.readInt();
        title = in.readString();
    }

    public static final Creator<Albums> CREATOR = new Creator<Albums>() {
        @Override
        public Albums createFromParcel(Parcel in) {
            return new Albums(in);
        }

        @Override
        public Albums[] newArray(int size) {
            return new Albums[size];
        }
    };

    @Override
    public String toString() {
        return "id: "+id+"\n"+
                "Id usuário: "+user_id+"\n"+
                "Título: " + title+"\n------------\n";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Albums albums = (Albums) o;
        return id == albums.id;
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
    }
}
