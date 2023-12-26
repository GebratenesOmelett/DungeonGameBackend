package game.backend.dungeongamebackend.hero.dto;

public class HeroDto {
    private int hp;
    private int defence;
    private int attackPower;
    private String userName;

    public HeroDto(int hp, int defence, int attackPower, String userName) {
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
    }

    public int getHp() {
        return hp;
    }

    public int getDefence() {
        return defence;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getUserName() {
        return userName;
    }
}
