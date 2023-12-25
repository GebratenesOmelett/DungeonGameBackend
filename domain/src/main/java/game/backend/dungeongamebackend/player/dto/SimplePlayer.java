package game.backend.dungeongamebackend.player.dto;


public class SimplePlayer {
    public static SimplePlayer restore(SimplePlayerSnapshot simplePlayerSnapshot) {
        return new SimplePlayer(simplePlayerSnapshot.getId(), simplePlayerSnapshot.getUserName());
    }

    private int id;
    private final String userName;

    SimplePlayer(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public SimplePlayerSnapshot getSnapshot() {
        return SimplePlayerSnapshot.builder()
                .id(id)
                .userName(userName)
                .build();
    }

}
