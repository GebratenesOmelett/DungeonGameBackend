package game.backend.dungeongamebackend.monster;

import game.backend.dungeongamebackend.monster.dto.MonsterCreateDto;
import org.springframework.stereotype.Service;

@Service
class MonsterFactory {
    Monster from(MonsterCreateDto monsterCreateDto) {
        return Monster.restore(new MonsterSnapshot.MonsterSnapshotBuilder()
                .setName(monsterCreateDto.getName())
                .setAttackPower(monsterCreateDto.getAttackPower())
                .setHealth(monsterCreateDto.getHealth())
                .build());
    }
}
