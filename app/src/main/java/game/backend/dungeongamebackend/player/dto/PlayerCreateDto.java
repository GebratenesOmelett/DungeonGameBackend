package game.backend.dungeongamebackend.player.dto;

public class PlayerCreateDto {
    private String email;
    private String password;
    private String userName;

    public PlayerCreateDto(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
    @Override
    public String toString() {
        return "PlayerCreateDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
