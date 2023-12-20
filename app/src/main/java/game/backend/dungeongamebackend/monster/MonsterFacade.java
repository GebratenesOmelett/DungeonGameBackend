package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterCreateDto;
import game.backend.dungeongamebackend.monster.dto.MonsterDto;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MonsterFacade {
    private final MonsterRepository monsterRepository;
    private final MonsterFactory monsterFactory;
    private final MonsterQueryRepository monsterQueryRepository;
    private final MonsterMapper monsterMapper;
    private final int MIN_ID = 1;

    MonsterFacade(MonsterRepository monsterRepository, MonsterFactory monsterFactory, MonsterQueryRepository monsterQueryRepository, MonsterMapper monsterMapper) {
        this.monsterRepository = monsterRepository;
        this.monsterFactory = monsterFactory;
        this.monsterQueryRepository = monsterQueryRepository;
        this.monsterMapper = monsterMapper;
    }
    public MonsterSnapshot getMonsterById(int id){
        return monsterRepository.findMonsterSnapshotById(id)
                .orElseThrow(() -> new UsernameNotFoundException("sfasfa")).getSnapshot();//ToDo
    }

    public MonsterDto getRandomMonster(){
        long max_id = monsterQueryRepository.countAllMonsters();
        int monsterId = (int)Math.floor(Math.random() * (max_id - MIN_ID + 1) + MIN_ID);
        return monsterMapper.toMonsterDto(getMonsterById(monsterId));
    }
    public void create(MonsterCreateDto monsterCreateDto){
        monsterRepository.save(monsterFactory.from(monsterCreateDto));
    }
    public long getCountOfMonster(){
        return monsterQueryRepository.countAllMonsters();
    }

}
