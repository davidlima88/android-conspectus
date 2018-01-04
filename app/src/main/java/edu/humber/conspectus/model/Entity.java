package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Entity{
    private Integer id;
    private String name;
    private Integer bookmarks_id;

    private Entity() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getBookmarks_id() {
        return bookmarks_id;
    }

    public void setBookmarks_id(Integer bookmarks_id) {
        this.bookmarks_id = bookmarks_id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public static List<Entity> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Entity> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Entity entity = new Entity();
            entity.setName(json_data.getString("fish_img"));
            entity.setId(json_data.getInt("price"));
            data.add(entity);
        }
        return data;
    }
}
