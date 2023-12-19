package game.backend.dungeongamebackend.monster;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

@Component
class InitializeMonsters {
    MonsterRepository monsterRepository;
    InitializeMonsters(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }
    @CreationTimestamp
    void createMonsters(){
//        monsterRepository.
    }
}
