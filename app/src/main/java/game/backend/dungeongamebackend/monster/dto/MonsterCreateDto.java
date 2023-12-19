package game.backend.dungeongamebackend.monster.dto;

public class MonsterCreateDto {
    private String name;
    private int health;
    private int attackPower;
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
