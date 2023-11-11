package game.backend.dungeongamebackend.player.dto;

public class SimplePlayer {
    public static SimplePlayer restore(SimplePlayerSnapshot simplePlayerSnapshot){
        return new SimplePlayer(simplePlayerSnapshot.getId());
    }
    private int id;
    SimplePlayer(int id) {
        this.id = id;
    }
}
