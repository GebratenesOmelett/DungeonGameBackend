package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.hero.dto.HeroDto;
import game.backend.dungeongamebackend.hero.dto.HeroExpAdd;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heroes")
@CrossOrigin
class HeroController {
    private final HeroFacade heroFacade;

    HeroController(HeroFacade heroFacade) {
        this.heroFacade = heroFacade;
    }
    @GetMapping("/get/{userName}")
    ResponseEntity<HeroDto> get(@PathVariable String userName){
        return new ResponseEntity<>(heroFacade.getDtoByUserName(userName), HttpStatus.OK);
    }
    @PostMapping("/addExp")
    ResponseEntity<HeroDto> get(@RequestBody HeroExpAdd heroExpAdd){
        System.out.println(heroExpAdd);
        return new ResponseEntity<>(heroFacade.addExperience(heroExpAdd), HttpStatus.OK);
    }
}
