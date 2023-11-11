package game.backend.dungeongamebackend.player;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
class PlayerSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String userName;

    protected PlayerSnapshot() {
    }

    PlayerSnapshot(PlayerSnapshotBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.userName = builder.userName;
    }

    int getId() {
        return id;
    }

    String getEmail() {
        return email;
    }

    String getPassword() {
        return password;
    }

    String getUserName() {
        return userName;
    }


    static class PlayerSnapshotBuilder{
        private int id;
        private String email;
        private String password;
        private String userName;
        PlayerSnapshotBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        PlayerSnapshotBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        PlayerSnapshotBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        PlayerSnapshotBuilder setId(int id) {
            this.id = id;
            return this;
        }

        PlayerSnapshot build(){
            return new PlayerSnapshot(this);
        }
    }
}
