package Models;

/**
 * Created by TOSHIBA1 on 19/04/2018.
 */

public class User {

    private String name;
    private String username;
    private String email;

    public User(String name, String username, String email, String street) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.street = street;
    }

    private String street;

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
