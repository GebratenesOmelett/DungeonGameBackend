package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
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
}
