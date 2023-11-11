package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import org.springframework.stereotype.Service;
@Service
class PlayerFactory {
    Player from(PlayerCreateDto playerCreateDto){
        return Player.restore(new PlayerSnapshot.PlayerSnapshotBuilder()
                .setEmail(playerCreateDto.getEmail())
                .setPassword(playerCreateDto.getPassword())
                .setUserName(playerCreateDto.getUserName())
                .build());
    }
}
