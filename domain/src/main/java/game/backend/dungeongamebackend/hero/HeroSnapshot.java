package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.player.dto.SimplePlayerSnapshot;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Table(name = "hero")
@Builder
@Getter
class HeroSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int hp;
    private int defence;
    private int attackPower;
    private String userName;
    @OneToOne
    private SimplePlayerSnapshot player;
    private int level;
    private int experience;

    protected HeroSnapshot() {
    }

    HeroSnapshot(int id, int hp, int defence, int attackPower, String userName, SimplePlayerSnapshot player, int level, int experience) {
        this.id = id;
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
        this.player = player;
        this.level = level;
        this.experience = experience;
    }
}
