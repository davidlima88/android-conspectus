package edu.humber.conspectus.model;

/**
 * Created by Osheen on 30-12-2017.
 */

public class Concept {
    Integer id;
    String name;
    Integer bookmarks_id;

    public Concept() { }

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
        return "Concept{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
