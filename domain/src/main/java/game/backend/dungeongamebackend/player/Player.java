package game.backend.dungeongamebackend.player;

import lombok.ToString;

@ToString
class Player {
    static Player restore(PlayerSnapshot playerSnapshot){
        return new Player(playerSnapshot.getId(),
                playerSnapshot.getEmail(),
                playerSnapshot.getPassword(),
                playerSnapshot.getUserName());
    }
    private final int id;
    private final String email;
    private final String password;
    private final String userName;

    Player(int id, String email, String password, String userName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
    PlayerSnapshot getSnapshot(){
        return new PlayerSnapshot.PlayerSnapshotBuilder()
                .setId(id)
                .setEmail(email)
                .setPassword(password)
                .setUserName(userName)
                .build();
    }
}