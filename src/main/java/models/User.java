package models;

public class User {
    private long id;
    private String username;
    private String email;
    private String password;

    public User(){

    }

    public User(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
