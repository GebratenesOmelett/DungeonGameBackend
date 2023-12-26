package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.SimplePlayer;
import game.backend.dungeongamebackend.player.dto.SimplePlayerSnapshot;
import org.springframework.stereotype.Service;

@Service
class PlayerMapper {
    SimplePlayer toSimplePlayer(PlayerSnapshot playerSnapshot) {
        return SimplePlayer.restore(SimplePlayerSnapshot.builder()
                .id(playerSnapshot.getId())
                .userName(playerSnapshot.getUserName())
                .build());
    }
}
