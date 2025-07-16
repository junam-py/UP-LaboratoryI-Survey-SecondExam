package services.model;

/**
 * Modelo de Administrator con el campo role.
 */
public class Administrator {
    private Long id;
    private String username;
    private String password;
    private String role;

    public Administrator() { }

    /**
     * Constructor usado en AdministratorDAOH2.findById().
     *
     * @param id       identificador
     * @param username nombre de usuario
     * @param password contraseña
     * @param role     rol del administrador
     */
    public Administrator(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Constructor para creación/edición en el panel (sin role).
     *
     * @param id       identificador (puede ser null para nuevos)
     * @param username nombre de usuario
     * @param password contraseña
     */
    public Administrator(Long id, String username, String password) {
        this(id, username, password, null);
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
