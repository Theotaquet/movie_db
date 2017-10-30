
package be.helha.projet.model.credits;


public class Crew {

    private String creditId;
    private String department;
    private int gender;
    private int id;
    private String job;
    private String name;
    private Object profilePath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Crew() {
    }

    /**
     * 
     * @param id
     * @param profilePath
     * @param department
     * @param name
     * @param job
     * @param gender
     * @param creditId
     */
    public Crew(String creditId, String department, int gender, int id, String job, String name, Object profilePath) {
        super();
        this.creditId = creditId;
        this.department = department;
        this.gender = gender;
        this.id = id;
        this.job = job;
        this.name = name;
        this.profilePath = profilePath;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(Object profilePath) {
        this.profilePath = profilePath;
    }

}
