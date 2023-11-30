package game.backend.dungeongamebackend.player.dto;

public class PlayerLoginDto {
    private final String email;
    private final String password;

    PlayerLoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }


}
