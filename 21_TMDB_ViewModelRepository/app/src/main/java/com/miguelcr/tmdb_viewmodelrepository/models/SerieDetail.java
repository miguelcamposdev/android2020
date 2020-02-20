package com.miguelcr.tmdb_viewmodelrepository.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class SerieDetail {
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("created_by")
    @Expose
    public List<CreatedBySerieDetail> createdBy = null;
    @SerializedName("episode_run_time")
    @Expose
    public List<Integer> episodeRunTime = null;
    @SerializedName("first_air_date")
    @Expose
    public String firstAirDate;
    @SerializedName("genres")
    @Expose
    public List<GenreSerieDetail> genres = null;
    @SerializedName("homepage")
    @Expose
    public String homepage;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("in_production")
    @Expose
    public Boolean inProduction;
    @SerializedName("languages")
    @Expose
    public List<String> languages = null;
    @SerializedName("last_air_date")
    @Expose
    public String lastAirDate;
    @SerializedName("last_episode_to_air")
    @Expose
    public LastEpisodeToAirSerieDetail lastEpisodeToAir;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("next_episode_to_air")
    @Expose
    public Object nextEpisodeToAir;
    @SerializedName("networks")
    @Expose
    public List<Object> networks = null;
    @SerializedName("number_of_episodes")
    @Expose
    public Integer numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    public Integer numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    public List<String> originCountry = null;
    @SerializedName("original_language")
    @Expose
    public String originalLanguage;
    @SerializedName("original_name")
    @Expose
    public String originalName;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("popularity")
    @Expose
    public Double popularity;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName("production_companies")
    @Expose
    public List<ProductionCompanySerieDetail> productionCompanies = null;
    @SerializedName("seasons")
    @Expose
    public List<SeasonSerieDetail> seasons = null;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;
}
