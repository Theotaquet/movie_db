package be.helha.projet.model;


public class Movie {


    private Integer unit;
    private Integer showId;
    private String showTitle;
    private String releaseYear;
    private String rating;
    private String category;
    private String showCast;
    private String director;
    private String summary;
    private String poster;
    private Integer mediatype;
    private String runtime;

    /**
     *
     * @param summary
     * @param unit
     * @param showCast
     * @param category
     * @param poster
     * @param showId
     * @param runtime
     * @param rating
     * @param director
     * @param showTitle
     * @param mediatype
     * @param releaseYear
     */
    public Movie(Integer unit, Integer showId, String showTitle, String releaseYear, String rating, String category, String showCast, String director, String summary, String poster, Integer mediatype, String runtime) {
        super();
        this.unit = unit;
        this.showId = showId;
        this.showTitle = showTitle;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.category = category;
        this.showCast = showCast;
        this.director = director;
        this.summary = summary;
        this.poster = poster;
        this.mediatype = mediatype;
        this.runtime = runtime;
    }

    public Movie() {
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Movie withUnit(Integer unit) {
        this.unit = unit;
        return this;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Movie withShowId(Integer showId) {
        this.showId = showId;
        return this;
    }

    public String getShowTitle() {
        return showTitle;
    }

    public void setShowTitle(String showTitle) {
        this.showTitle = showTitle;
    }

    public Movie withShowTitle(String showTitle) {
        this.showTitle = showTitle;
        return this;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Movie withReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Movie withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Movie withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getShowCast() {
        return showCast;
    }

    public void setShowCast(String showCast) {
        this.showCast = showCast;
    }

    public Movie withShowCast(String showCast) {
        this.showCast = showCast;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie withDirector(String director) {
        this.director = director;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Movie withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Movie withPoster(String poster) {
        this.poster = poster;
        return this;
    }

    public Integer getMediatype() {
        return mediatype;
    }

    public void setMediatype(Integer mediatype) {
        this.mediatype = mediatype;
    }

    public Movie withMediatype(Integer mediatype) {
        this.mediatype = mediatype;
        return this;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public Movie withRuntime(String runtime) {
        this.runtime = runtime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        if (!unit.equals(movie.unit)) return false;
        if (!showId.equals(movie.showId)) return false;
        if (!showTitle.equals(movie.showTitle)) return false;
        if (!releaseYear.equals(movie.releaseYear)) return false;
        if (!rating.equals(movie.rating)) return false;
        if (!category.equals(movie.category)) return false;
        if (!showCast.equals(movie.showCast)) return false;
        if (!director.equals(movie.director)) return false;
        if (!summary.equals(movie.summary)) return false;
        if (!poster.equals(movie.poster)) return false;
        if (!mediatype.equals(movie.mediatype)) return false;
        return runtime.equals(movie.runtime);
    }


}
