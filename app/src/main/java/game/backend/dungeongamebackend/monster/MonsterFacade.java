package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterCreateDto;
import game.backend.dungeongamebackend.monster.dto.MonsterDto;
import org.springframework.stereotype.Service;
@Service
public class MonsterFacade {
    private final MonsterRepository monsterRepository;
    private final MonsterFactory monsterFactory;
    private final MonsterQueryRepository monsterQueryRepository;
    private final int MIN_ID = 1;

    MonsterFacade(MonsterRepository monsterRepository, MonsterFactory monsterFactory, MonsterQueryRepository monsterQueryRepository) {
        this.monsterRepository = monsterRepository;
        this.monsterFactory = monsterFactory;
        this.monsterQueryRepository = monsterQueryRepository;
    }

    public MonsterDto getMonster(){
        long max_id = monsterQueryRepository.countAllMonsters();
        int monsterId = (int)Math.floor(Math.random() * (max_id - MIN_ID + 1) + MIN_ID);
        return monsterRepository.findMonsterSnapshotById(monsterId);
    }
    public void create(MonsterCreateDto monsterCreateDto){
        monsterRepository.save(monsterFactory.from(monsterCreateDto));
    }
    public long getCountOfMonster(){
        return monsterQueryRepository.countAllMonsters();
    }

}
