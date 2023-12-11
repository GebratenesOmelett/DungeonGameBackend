package game.backend.dungeongamebackend.player.dto;

public class PlayerLoginDto {
    private final String email;
    private final String password;

    public PlayerLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
