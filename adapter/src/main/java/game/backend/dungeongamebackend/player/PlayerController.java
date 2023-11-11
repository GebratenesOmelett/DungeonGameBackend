package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/players")
class PlayerController {
    private PlayerFacade playerFacade;

    PlayerController(PlayerFacade playerFacade) {
        this.playerFacade = playerFacade;
    }

    @PostMapping
    void create(@RequestBody PlayerCreateDto playerCreateDto){
        playerFacade.create(playerCreateDto);
    }


}