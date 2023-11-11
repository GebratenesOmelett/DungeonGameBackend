package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.player.dto.SimplePlayerSnapshot;
import jakarta.persistence.*;

@Entity
@Table(name = "hero")
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

    protected HeroSnapshot() {
    }

    HeroSnapshot(int id, int hp, int defence, int attackPower, String userName, SimplePlayerSnapshot player) {
        this.id = id;
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
        this.player = player;
    }

    int getId() {
        return id;
    }

    int getHp() {
        return hp;
    }

    int getDefence() {
        return defence;
    }

    int getAttackPower() {
        return attackPower;
    }

    String getUserName() {
        return userName;
    }

    SimplePlayerSnapshot getPlayer() {
        return player;
    }
}
