package com.miguelcr.tmdb_viewmodelrepository.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreatedBySerieDetail {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("credit_id")
    @Expose
    public String creditId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("gender")
    @Expose
    public Integer gender;
    @SerializedName("profile_path")
    @Expose
    public String profilePath;

    public CreatedBySerieDetail(Integer id, String creditId, String name, Integer gender, String profilePath) {
        this.id = id;
        this.creditId = creditId;
        this.name = name;
        this.gender = gender;
        this.profilePath = profilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
}
