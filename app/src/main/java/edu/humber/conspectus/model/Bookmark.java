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
            data.add(bookmark);
        }
        return data;
    }
}
