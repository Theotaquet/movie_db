
package be.helha.projet.model.movie;

public class BelongsToCollection {


    private int id;

    private String name;

    private String posterPath;

    private String backdropPath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BelongsToCollection() {
    }

    /**
     * 
     * @param id
     * @param posterPath
     * @param name
     * @param backdropPath
     */
    public BelongsToCollection(int id, String name, String posterPath, String backdropPath) {
        super();
        this.id = id;
        this.name = name;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }


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


    public String getPosterPath() {
        return posterPath;
    }


    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

}
