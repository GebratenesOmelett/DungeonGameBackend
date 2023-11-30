package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import game.backend.dungeongamebackend.player.dto.PlayerLoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerFacade {
    private final PlayerRepository playerRepository;
    private final PlayerFactory playerFactory;

    PlayerFacade(PlayerRepository playerRepository, PlayerFactory playerFactory) {
        this.playerRepository = playerRepository;
        this.playerFactory = playerFactory;
    }

    public void create(PlayerCreateDto playerCreateDto) {
        playerRepository.save(playerFactory.from(playerCreateDto));
    }

    Boolean login(PlayerLoginDto playerLoginDto) {
        return true;
    }
}
