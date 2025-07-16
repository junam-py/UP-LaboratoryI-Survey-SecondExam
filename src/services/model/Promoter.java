package services.model;

public class Promoter extends User {
    private String location;  // e.g. store or branch

    public Promoter() { }

    public Promoter(Long id, String username, String password, String role, String location) {
        super(id, username, password, role);
        this.location = location;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "Promoter{" +
               "id=" + getId() +
               ", username='" + getUsername() + '\'' +
               ", location='" + location + '\'' +
               '}';
    }
}
