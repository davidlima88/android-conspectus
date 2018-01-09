package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Concept{
    private Integer id;
    private String text;
    private Double relevance;
    private String dbpedia_resource;
    private Integer bookmarks_id;

    private Concept() { }

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

    public String getDbpedia_resource() {
        return dbpedia_resource;
    }

    public void setDbpedia_resource(String dbpedia_resource) {
        this.dbpedia_resource = dbpedia_resource;
    }

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

    @Override
    public String toString() {
        return "Concept{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", relevance=" + relevance +
                ", dbpedia_resource='" + dbpedia_resource + '\'' +
                ", bookmarks_id=" + bookmarks_id +
                '}';
    }

    public static List<Concept> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Concept> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Concept concept = new Concept();
            concept.setText(json_data.getString("text"));
            concept.setRelevance(json_data.getDouble("relevance"));
            concept.setId(json_data.getInt("id"));
            concept.setDbpedia_resource(json_data.getString("dbpedia_resource"));
            concept.setBookmarks_id(json_data.getInt("bookmark_id"));
            data.add(concept);
        }
        return data;
    }
}
