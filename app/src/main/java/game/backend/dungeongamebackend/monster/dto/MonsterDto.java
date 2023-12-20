package game.backend.dungeongamebackend.monster.dto;

public class MonsterDto {
    private int id;
    private String name;
    private int health;
    private int attackPower;

    public MonsterDto(int id, String name, int health, int attackPower) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getId() {
        return id;
    }

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
