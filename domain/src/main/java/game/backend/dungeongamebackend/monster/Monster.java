package game.backend.dungeongamebackend.monster;



class Monster {
    static Monster restore(MonsterSnapshot monsterSnapshot){
        return new Monster(monsterSnapshot.getId(),
                monsterSnapshot.getName(),
                monsterSnapshot.getHealth(),
                monsterSnapshot.getAttackPower());
    }
    int id;
    String name;
    private int health;
    private int attackPower;

    Monster(int id, String name, int health, int attackPower) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    MonsterSnapshot getSnapshot(){
        return new MonsterSnapshot.MonsterSnapshotBuilder()
                .setId(id)
                .setName(name)
                .setHealth(health)
                .setAttackPower(attackPower)
                .build();
    }
}
