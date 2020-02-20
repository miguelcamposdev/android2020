package com.miguelcr.tmdb_viewmodelrepository.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreSerieDetail {
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;

    public GenreSerieDetail(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
