package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.player.dto.SimplePlayer;
import org.springframework.stereotype.Service;

@Service
public class HeroFacade {
    private final HeroRepository heroRepository;
    private final HeroFactory heroFactory;

    HeroFacade(HeroRepository heroRepository, HeroFactory heroFactory) {
        this.heroRepository = heroRepository;
        this.heroFactory = heroFactory;
    }

    public void create(SimplePlayer simplePlayer) {
        heroRepository.save(heroFactory.from(simplePlayer.getSnapshot()));
    }
}
