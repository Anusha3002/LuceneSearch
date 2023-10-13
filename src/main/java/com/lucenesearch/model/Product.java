package com.lucenesearch.model;
import java.util.List;

// This is basically the Representation of the structure of my Json Document.
// This include fields that correspond to the JSON document's structure.

public class Product {
    private int id;
    private String name;
    private String code;
    private String description;
    private Category category;
    private Brand brand;
    private List<Model> models;
    private boolean status;
    private boolean gstIncluded;
    private Media media;
    private String created;
    private String updated;
    private String createdby;
    private String updatedby;
    private double rate;
    private double gst;
    private double discount;
    private double rating;

    // I have to yet generate Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static class Category {
        private String name;
        private boolean status;
        private int id;

        // Getters and setters
        // ...
    }

    public static class Brand {
        private String name;
        private String createdby;
        private String updatedby;
        private boolean status;
        private boolean visibleOnDashboard;
        private Media media;
        private int id;

        // Getters and setters
        // ...
    }

    public static class Model {
        private int id;
        private String name;
        private String variant;
        private boolean status;
        private Media media;
        private Brand brand;
        private String created;
        private String updated;
        private String createdby;
        private String updatedby;

        // Getters and setters
        // ...
    }

    public static class Media {
        private int id;
        private String name;
        private String fileType;
        private String imgUrl;
        private int type;

        // Getters and setters
        // ...
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", brand=" + brand +
                ", models=" + models +
                ", status=" + status +
                ", gstIncluded=" + gstIncluded +
                ", media=" + media +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", createdby='" + createdby + '\'' +
                ", updatedby='" + updatedby + '\'' +
                ", rate=" + rate +
                ", gst=" + gst +
                ", discount=" + discount +
                ", rating=" + rating +
                '}';
    }
}
