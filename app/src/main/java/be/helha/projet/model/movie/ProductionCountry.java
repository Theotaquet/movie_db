
package be.helha.projet.model.movie;


public class ProductionCountry {


    private String iso31661;

    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ProductionCountry() {
    }

    /**
     * 
     * @param iso31661
     * @param name
     */
    public ProductionCountry(String iso31661, String name) {
        super();
        this.iso31661 = iso31661;
        this.name = name;
    }


    public String getIso31661() {
        return iso31661;
    }


    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
