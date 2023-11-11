package game.backend.dungeongamebackend.monster;

import jakarta.persistence.*;

@Entity
@Table(name = "monsters")
class MonsterSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int health;
    private int attackPower;

    protected MonsterSnapshot() {
    }

    MonsterSnapshot(int id, String name, int health, int attackPower) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getHealth() {
        return health;
    }

    int getAttackPower() {
        return attackPower;
    }
}
