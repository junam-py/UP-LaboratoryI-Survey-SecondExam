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

    public void setID(int iD) {
        ID = iD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
