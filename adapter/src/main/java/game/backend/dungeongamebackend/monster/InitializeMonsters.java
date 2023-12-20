package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterCreateDto;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
class InitializeMonsters implements ApplicationListener<ContextRefreshedEvent> {
    private final MonsterFacade monsterFacade;

    InitializeMonsters(MonsterFacade monsterFacade) {
        this.monsterFacade = monsterFacade;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        monsterFacade.create(new MonsterCreateDto("skeleton", 20 , 50));
        monsterFacade.create(new MonsterCreateDto("slime", 100 , 10));
    }
}
