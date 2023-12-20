package game.backend.dungeongamebackend.auth.dto;

public class AuthenticationResponse {
    private final String token;
    private final String userName;
    private final String email;

    public AuthenticationResponse(String token, String userName, String email) {
        this.token = token;
        this.userName = userName;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
}
