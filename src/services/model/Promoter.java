package services.model;

public class Promoter {
    private int ID;
    private String name;
    private String secondName;
    private String email;
    private int age;

    
    public Promoter(int ID, String name, String secondName, String email, int age) {
        this.ID = ID;
        this.name = name;
        this.secondName = secondName;
        this.email = email;
        this.age = age;
    }

    
    /** 
     * @param ID setter
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /** 
     * @param name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param secondName setter
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    
    /** 
     * @param email setter
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @param age setter
     */
    public void setAge(int age) {
        this.age = age;
    }

    
    /** 
     * @return int getter
     */
    public int getID() {
        return ID;
    }

    
    /** 
     * @return String getter
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @return String getter
     */
    public String getSecondName() {
        return secondName;
    }

    /** 
     * @return String getter
     */
    public String getEmail() {
        return email;
    }

    /** 
     * @return int getter
     */
    public int getAge() {
        return age;
    }

}