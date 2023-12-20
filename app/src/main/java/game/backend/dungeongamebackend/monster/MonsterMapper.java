package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterDto;
import org.springframework.stereotype.Service;
@Service
public class MonsterMapper {
    public MonsterDto toMonsterDto(MonsterSnapshot monsterSnapshot){
        return new MonsterDto(monsterSnapshot.getId(),
                monsterSnapshot.getName(),
                monsterSnapshot.getHealth(),
                monsterSnapshot.getAttackPower());
    }
}
