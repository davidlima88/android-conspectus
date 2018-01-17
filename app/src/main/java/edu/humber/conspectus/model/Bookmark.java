package edu.humber.conspectus.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Bookmark{
    private Integer id;
    private String title;
    private String url;
    private Double sentiment;
    private Double joy;
    private Double fear;
    private Double anger;
    private Double disgust;
    private Double sadness;
    private JSONArray concepts;
    private JSONArray categories;
    private JSONArray entities;
    private JSONArray keywords;


    private Bookmark() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getSentiment() {
        return sentiment;
    }

    public void setSentiment(Double sentiment) {
        this.sentiment = sentiment;
    }

    public Double getJoy() {
        return joy;
    }

    public void setJoy(Double joy) {
        this.joy = joy;
    }

    public Double getFear() {
        return fear;
    }

    public void setFear(Double fear) {
        this.fear = fear;
    }

    public Double getAnger() {
        return anger;
    }

    public void setAnger(Double anger) {
        this.anger = anger;
    }

    public Double getDisgust() {
        return disgust;
    }

    public void setDisgust(Double disgust) {
        this.disgust = disgust;
    }

    public Double getSadness() {
        return sadness;
    }

    public void setSadness(Double sadness) {
        this.sadness = sadness;
    }

    public JSONArray getConcepts() {
        return concepts;
    }

    public void setConcepts(JSONArray concepts) {
        this.concepts = concepts;
    }

    public JSONArray getCategories() {
        return categories;
    }

    public void setCategories(JSONArray categories) {
        this.categories = categories;
    }

    public JSONArray getEntities() {
        return entities;
    }

    public void setEntities(JSONArray entities) {
        this.entities = entities;
    }

    public JSONArray getKeywords() {
        return keywords;
    }

    public void setKeywords(JSONArray keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", sentiment=" + sentiment +
                ", joy=" + joy +
                ", fear=" + fear +
                ", anger=" + anger +
                ", disgust=" + disgust +
                ", sadness=" + sadness +
                '}';
    }

    public static List<Bookmark> parseJSONArray(JSONArray jsonArray) throws JSONException {
        List<Bookmark> data = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Bookmark bookmark = new Bookmark();
            bookmark.setId(json_data.getInt("id"));
            bookmark.setUrl(json_data.getString("url"));
            bookmark.setTitle(json_data.getString("title"));
            bookmark.setSentiment(json_data.getDouble("sentiment"));
            bookmark.setAnger(json_data.getDouble("anger"));
            bookmark.setDisgust(json_data.getDouble("disgust"));
            bookmark.setFear(json_data.getDouble("fear"));
            bookmark.setJoy(json_data.getDouble("joy"));
            bookmark.setSadness(json_data.getDouble("sadness"));
            try {
                bookmark.setCategories(json_data.getJSONArray("categories"));
            } catch (JSONException e){

            }
            try {
                bookmark.setConcepts(json_data.getJSONArray("concepts"));
            } catch (JSONException e){

            }
            try {
                bookmark.setKeywords(json_data.getJSONArray("keywords"));
            } catch (JSONException e){

            }
            try {
                bookmark.setEntities(json_data.getJSONArray("entities"));
            } catch (JSONException e){

            }
            data.add(bookmark);
        }
        return data;
    }
}
