package game.backend.dungeongamebackend.player.dto;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "player")
@Builder
public class SimplePlayerSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    protected SimplePlayerSnapshot() {
    }

    private SimplePlayerSnapshot(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
}
