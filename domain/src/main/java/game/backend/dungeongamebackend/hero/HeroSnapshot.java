package game.backend.dungeongamebackend.hero;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

class HeroSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hp;
    private int defence;
    private int attackPower;
    private String userName;

    public HeroSnapshot() {
    }

    HeroSnapshot(int hp, int defence, int attackPower, String userName) {
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
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
}
