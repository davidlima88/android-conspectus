package edu.humber.conspectus;

/**
 * Created by Osheen on 30-12-2017.
 */

public class Bookmark {
    Integer id;
    String title;
    String url;
    String sentiment;
    Integer folders_id;

    public Bookmark(String title, String url, String sentiment, Integer folders_id) {
        this.title = title;
        this.url = url;
        this.sentiment = sentiment;
        this.folders_id = folders_id;
    }

    public Bookmark(Integer id, String title, String url, String sentiment, Integer folders_id) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.sentiment = sentiment;
        this.folders_id = folders_id;
    }

    public Bookmark(Integer id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

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

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public Integer getFolders_id() {
        return folders_id;
    }

    public void setFolders_id(Integer folders_id) {
        this.folders_id = folders_id;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", sentiment='" + sentiment + '\'' +
                ", folders_id=" + folders_id +
                '}';
    }
}
