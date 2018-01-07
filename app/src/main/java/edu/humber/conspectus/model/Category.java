package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Category{
    private Integer id;
    private Integer bookmarks_id;
    private Double score;
    private String label;

    private Category() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookmarks_id() {
        return bookmarks_id;
    }

    public void setBookmarks_id(Integer bookmarks_id) {
        this.bookmarks_id = bookmarks_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", bookmarks_id=" + bookmarks_id +
                ", score=" + score +
                ", label='" + label + '\'' +
                '}';
    }

    public static List<Category> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Category> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Category category = new Category();
            category.setLabel(json_data.getString("label"));
            category.setScore(json_data.getDouble("score"));
            category.setId(json_data.getInt("id"));
            data.add(category);
        }
        return data;
    }
}
