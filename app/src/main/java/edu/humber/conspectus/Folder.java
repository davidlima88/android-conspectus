package edu.humber.conspectus;

/**
 * Created by Osheen on 30-12-2017.
 */

public class Folder {
    Integer id;
    String name;
    Integer users_id;
    Integer parent_id;

    public Folder(String name, Integer users_id, Integer parent_id) {
        this.name = name;
        this.users_id = users_id;
        this.parent_id = parent_id;
    }

    public Folder(Integer id, String name, Integer users_id, Integer parent_id) {
        this.id = id;
        this.name = name;
        this.users_id = users_id;
        this.parent_id = parent_id;
    }

    public Folder(Integer id, String name, Integer users_id) {
        this.id = id;
        this.name = name;
        this.users_id = users_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUsers_id() {
        return users_id;
    }

    public void setUsers_id(Integer users_id) {
        this.users_id = users_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users_id=" + users_id +
                ", parent_id=" + parent_id +
                '}';
    }
}
