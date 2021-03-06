package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Keyword{
    private Integer id;
    private Integer bookmarks_id;
    private String text;
    private Double relevance;

    private Keyword() { }

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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "id=" + id +
                ", bookmarks_id=" + bookmarks_id +
                ", text='" + text + '\'' +
                ", relevance=" + relevance +
                '}';
    }

    public Double getRelevance() {
        return relevance;
    }

    public void setRelevance(Double relevance) {
        this.relevance = relevance;
    }

    public static List<Keyword> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Keyword> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Keyword keyword = new Keyword();
            keyword.setId(json_data.getInt("id"));
            keyword.setRelevance(json_data.getDouble("relevance"));
            keyword.setText(json_data.getString("text"));
            keyword.setBookmarks_id(json_data.getInt("bookmark_id"));
            data.add(keyword);
        }
        return data;
    }
}
