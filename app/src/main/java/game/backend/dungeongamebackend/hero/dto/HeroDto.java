package game.backend.dungeongamebackend.hero.dto;

public class HeroDto {
    private final int hp;
    private final int defence;
    private final int attackPower;
    private final String userName;
    private final int level;
    private final int experience;

    public HeroDto(int hp, int defence, int attackPower, String userName, int level, int experience) {
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
        this.level = level;
        this.experience = experience;
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

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }
}
