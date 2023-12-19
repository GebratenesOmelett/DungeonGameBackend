package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterCreateDto;
import org.springframework.stereotype.Service;
@Service
public class MonsterFacade {
    MonsterRepository monsterRepository;
    MonsterFactory monsterFactory;

    MonsterFacade(MonsterRepository monsterRepository, MonsterFactory monsterFactory) {
        this.monsterRepository = monsterRepository;
        this.monsterFactory = monsterFactory;
    }

    public boolean getMonster(){
        return true;
    }
    public void create(MonsterCreateDto monsterCreateDto){
        monsterRepository.save(monsterFactory.from(monsterCreateDto));
    }

}
