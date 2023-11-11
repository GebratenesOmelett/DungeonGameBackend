package game.backend.dungeongamebackend.player.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "player")
public class SimplePlayerSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected SimplePlayerSnapshot() {
    }
    SimplePlayerSnapshot(int id) {
        this.id = id;
    }
    int getId() {
        return id;
    }
}
