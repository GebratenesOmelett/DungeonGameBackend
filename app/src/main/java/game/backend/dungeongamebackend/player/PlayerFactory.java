package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
class PlayerFactory {
    private PasswordEncoder passwordEncoder;

    PlayerFactory(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    Player from(PlayerCreateDto playerCreateDto){
        return Player.restore(new PlayerSnapshot.PlayerSnapshotBuilder()
                .setEmail(playerCreateDto.getEmail())
                .setPassword(passwordEncoder.encode(playerCreateDto.getPassword()))
                .setUserName(playerCreateDto.getUserName())
                .build());
    }
}
