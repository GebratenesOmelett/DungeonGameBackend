package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import game.backend.dungeongamebackend.player.dto.PlayerLoginDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    ResponseEntity<Boolean> login(@RequestBody PlayerLoginDto playerLoginDto){
        return new ResponseEntity<>(playerFacade.login(playerLoginDto), HttpStatus.OK);
    }

}
