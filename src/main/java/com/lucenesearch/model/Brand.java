package com.lucenesearch.model;

public class Brand {
    private String name;
    private String createdby;
    private String updatedby;
    private boolean status;
    private boolean visibleOnDashboard;
    private Media media;
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isVisibleOnDashboard() {
        return visibleOnDashboard;
    }

    public void setVisibleOnDashboard(boolean visibleOnDashboard) {
        this.visibleOnDashboard = visibleOnDashboard;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
