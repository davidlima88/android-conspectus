package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Entity{
    private Integer id;
    private String type;
    private String text;
    private Double relevance;
    private Integer bookmarks_id;

    private Entity() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getRelevance() {
        return relevance;
    }

    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }

    public Integer getBookmarks_id() {
        return bookmarks_id;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", text='" + text + '\'' +
                ", relevance=" + relevance +
                ", bookmarks_id=" + bookmarks_id +
                '}';
    }

    public void setBookmarks_id(Integer bookmarks_id) {
        this.bookmarks_id = bookmarks_id;
    }

    public static List<Entity> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Entity> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Entity entity = new Entity();
            entity.setText(json_data.getString("text"));
            entity.setType(json_data.getString("type"));
            entity.setRelevance(json_data.getDouble("relevance"));
            entity.setId(json_data.getInt("id"));
            data.add(entity);
        }
        return data;
    }
}
