
package be.helha.projet.model.credits;


public class Cast {

    private int castId;
    private String character;
    private String creditId;
    private int gender;
    private int id;
    private String name;
    private int order;
    private Object profilePath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cast() {
    }

    /**
     * 
     * @param id
     * @param profilePath
     * @param order
     * @param castId
     * @param name
     * @param gender
     * @param creditId
     * @param character
     */
    public Cast(int castId, String character, String creditId, int gender, int id, String name, int order, Object profilePath) {
        super();
        this.castId = castId;
        this.character = character;
        this.creditId = creditId;
        this.gender = gender;
        this.id = id;
        this.name = name;
        this.order = order;
        this.profilePath = profilePath;
    }

    public int getCastId() {
        return castId;
    }

    public void setCastId(int castId) {
        this.castId = castId;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Object getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(Object profilePath) {
        this.profilePath = profilePath;
    }

}
