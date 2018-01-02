package edu.humber.conspectus.model;

/**
 * Created by Osheen on 30-12-2017.
 */

public class Category {
    Integer id;
    Integer bookmarks_id;

    public Category(Integer id, Integer bookmarks_id) {
        this.id = id;
        this.bookmarks_id = bookmarks_id;
    }

    public Category(Integer bookmarks_id) {
        this.bookmarks_id = bookmarks_id;
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
        return "Category{" +
                "id=" + id +
                ", bookmarks_id=" + bookmarks_id +
                '}';
    }
}