package edu.humber.conspectus.model;

/**
 * Created by Osheen on 30-12-2017.
 */

public class Emotion {
    Integer id;
    Integer bookmarks_id;

    public Emotion(Integer id, Integer bookmarks_id) {
        this.id = id;
        this.bookmarks_id = bookmarks_id;
    }

    public Emotion(Integer bookmarks_id) {
        this.bookmarks_id = bookmarks_id;
    }

    @Override
    public String toString() {
        return "Emotion{" +
                "id=" + id +
                ", bookmarks_id=" + bookmarks_id +
                '}';
    }
}
