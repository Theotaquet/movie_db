
package be.helha.projet.model.credits;

import java.util.List;

public class Credits {

    private int id;
    private List<Cast> cast = null;
    private List<Crew> crew = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Credits() {
    }

    /**
     * 
     * @param id
     * @param cast
     * @param crew
     */
    public Credits(int id, List<Cast> cast, List<Crew> crew) {
        super();
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

}
