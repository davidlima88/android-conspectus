package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Keyword{
    private Integer id;
    private String name;
    private Integer bookmarks_id;

    private Keyword() { }

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
        return "Keyword{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public static List<Keyword> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Keyword> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Keyword keyword = new Keyword();
            keyword.setName(json_data.getString("fish_img"));
            keyword.setId(json_data.getInt("price"));
            data.add(keyword);
        }
        return data;
    }
}
