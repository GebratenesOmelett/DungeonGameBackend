package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/monsters")
class MonsterController {
    MonsterFacade monsterFacade;

    MonsterController(MonsterFacade monsterFacade) {
        this.monsterFacade = monsterFacade;
    }

    @GetMapping("/getAmount")
    ResponseEntity<Long> getAmountOfMonsters(){
        return new ResponseEntity<>(monsterFacade.getCountOfMonster(), HttpStatus.OK);
    }
    @GetMapping("/getRandom")
    ResponseEntity<MonsterDto> getRandomMonster(){
        return new ResponseEntity<>(monsterFacade.getRandomMonster(), HttpStatus.OK);
    }
}
