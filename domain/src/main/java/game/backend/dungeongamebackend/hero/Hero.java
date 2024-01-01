package game.backend.dungeongamebackend.hero;


import game.backend.dungeongamebackend.player.dto.SimplePlayer;

class Hero {
    static Hero restore(HeroSnapshot heroSnapshot){
        return new Hero(heroSnapshot.getId(),
                heroSnapshot.getHp(),
                heroSnapshot.getDefence(),
                heroSnapshot.getAttackPower(),
                heroSnapshot.getUserName(),
                SimplePlayer.restore(heroSnapshot.getPlayer()),
                heroSnapshot.getLevel(),
                heroSnapshot.getExperience());
    }
    private final int id;
    private final int hp;
    private final int defence;
    private final int attackPower;
    private final String userName;
    private final SimplePlayer player;
    private final int level;
    private final int experience;

    private Hero(int id, int hp, int defence, int attackPower,
                 String userName, SimplePlayer player, int level, int experience) {
        this.id = id;
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
        this.player = player;
        this.level = level;
        this.experience = experience;
    }

    HeroSnapshot getSnapshot(){
        return HeroSnapshot.builder()
                .id(id)
                .hp(hp)
                .defence(defence)
                .attackPower(attackPower)
                .userName(userName)
                .player(player.getSnapshot())
                .level(level)
                .experience(experience)
                .build();


    }
}
