package com.lucenesearch.model;
import java.util.List;

// This is basically the Representation of the structure of my Json Document.
// This include fields that correspond to the JSON document's structure.

public class Product {
    private Long id;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isGstIncluded() {
        return gstIncluded;
    }

    public void setGstIncluded(boolean gstIncluded) {
        this.gstIncluded = gstIncluded;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
