package game.backend.dungeongamebackend.auth.dto;

public class AuthenticationResponse {
    private final String token;
    private final String userName;
    private final String email;
    private final String expiresIn;
    public AuthenticationResponse(String token, String userName, String email, String expiresIn) {
        this.token = token;
        this.userName = userName;
        this.email = email;
        this.expiresIn = expiresIn;
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

    public String getExpiresIn() {
        return expiresIn;
    }
}
