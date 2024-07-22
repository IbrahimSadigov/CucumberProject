package Models;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 20 July, 2024
 **/
public class Token {

    private String username;
    private String password;

    public Token() {
    }

    public Token(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Token setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Token setPassword(String password) {
        this.password = password;
        return this;
    }
}
