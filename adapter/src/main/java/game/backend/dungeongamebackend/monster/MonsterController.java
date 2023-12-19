package game.backend.dungeongamebackend.monster;

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
    MonsterQueryRepository monsterQueryRepository;

    MonsterController(MonsterFacade monsterFacade, MonsterQueryRepository monsterQueryRepository) {
        this.monsterFacade = monsterFacade;
        this.monsterQueryRepository = monsterQueryRepository;
    }

    @GetMapping("/get")
    ResponseEntity<Long> getMonster(){
        return new ResponseEntity<>(monsterQueryRepository.countAllMonsters(), HttpStatus.OK);
    }
}
