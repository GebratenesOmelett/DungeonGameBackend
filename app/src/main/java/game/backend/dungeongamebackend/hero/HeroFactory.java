package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.player.dto.SimplePlayerSnapshot;
import org.springframework.stereotype.Service;

@Service
class HeroFactory {
    private final int HEALTH = 100;
    private final int ATTACK_POWER = 10;
    private final int DEFENCE = 10;

    Hero from(SimplePlayerSnapshot simplePlayerSnapshot) {
        return Hero.restore(HeroSnapshot.builder()
                .hp(HEALTH)
                .attackPower(ATTACK_POWER)
                .defence(DEFENCE)
                .userName(simplePlayerSnapshot.getUserName())
                .player(simplePlayerSnapshot)
                .level(1)
                .experience(0)
                .build());
    }
}
