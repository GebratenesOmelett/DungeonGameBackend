package game.backend.dungeongamebackend.hero;


import game.backend.dungeongamebackend.player.dto.SimplePlayer;

class Hero {
    static Hero restore(HeroSnapshot heroSnapshot){
        return new Hero(heroSnapshot.getId(),
                heroSnapshot.getHp(),
                heroSnapshot.getDefence(),
                heroSnapshot.getAttackPower(),
                heroSnapshot.getUserName(),
                SimplePlayer.restore(heroSnapshot.getPlayer()));
    }
    private int id;
    private int hp;
    private int defence;
    private int attackPower;
    private String userName;
    private SimplePlayer player;

    private Hero(int id, int hp, int defence, int attackPower, String userName, SimplePlayer player) {
        this.id = id;
        this.hp = hp;
        this.defence = defence;
        this.attackPower = attackPower;
        this.userName = userName;
        this.player = player;
    }

    HeroSnapshot getSnapshot(){
        return HeroSnapshot.builder()
                .id(id)
                .hp(hp)
                .defence(defence)
                .attackPower(attackPower)
                .userName(userName)
                .player(player.getSnapshot())
                .build();


    }
}
