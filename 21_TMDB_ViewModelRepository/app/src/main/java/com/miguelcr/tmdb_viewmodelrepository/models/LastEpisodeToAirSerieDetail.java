package com.miguelcr.tmdb_viewmodelrepository.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LastEpisodeToAirSerieDetail {
    @SerializedName("air_date")
    @Expose
    public String airDate;
    @SerializedName("episode_number")
    @Expose
    public Integer episodeNumber;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("production_code")
    @Expose
    public String productionCode;
    @SerializedName("season_number")
    @Expose
    public Integer seasonNumber;
    @SerializedName("show_id")
    @Expose
    public Integer showId;
    @SerializedName("still_path")
    @Expose
    public String stillPath;
    @SerializedName("vote_average")
    @Expose
    public Integer voteAverage;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;

    public LastEpisodeToAirSerieDetail(String airDate, Integer episodeNumber, Integer id, String name, String overview, String productionCode, Integer seasonNumber, Integer showId, String stillPath, Integer voteAverage, Integer voteCount) {
        this.airDate = airDate;
        this.episodeNumber = episodeNumber;
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.productionCode = productionCode;
        this.seasonNumber = seasonNumber;
        this.showId = showId;
        this.stillPath = stillPath;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getProductionCode() {
        return productionCode;
    }

    public void setProductionCode(String productionCode) {
        this.productionCode = productionCode;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public String getStillPath() {
        return stillPath;
    }

    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
