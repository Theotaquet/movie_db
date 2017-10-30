
package be.helha.projet.model.movie;


public class ProductionCompany {


    private String name;

    private int id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductionCompany() {
    }

    /**
     * 
     * @param id
     * @param name
     */
    public ProductionCompany(String name, int id) {
        super();
        this.name = name;
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
