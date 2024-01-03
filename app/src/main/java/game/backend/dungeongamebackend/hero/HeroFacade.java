package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.hero.dto.HeroDto;
import game.backend.dungeongamebackend.hero.dto.HeroExpAdd;
import game.backend.dungeongamebackend.player.dto.SimplePlayer;
import org.springframework.stereotype.Service;

@Service
public class HeroFacade {
    private final HeroRepository heroRepository;
    private final HeroQueryRepository heroQueryRepository;
    private final HeroFactory heroFactory;
    private final HeroMapper heroMapper;

    HeroFacade(HeroRepository heroRepository, HeroQueryRepository heroQueryRepository, HeroFactory heroFactory, HeroMapper heroMapper) {
        this.heroRepository = heroRepository;
        this.heroQueryRepository = heroQueryRepository;
        this.heroFactory = heroFactory;
        this.heroMapper = heroMapper;
    }

    public HeroSnapshot getHeroByUserName(String userName) {
        return heroQueryRepository.getHeroSnapshotByUserName(userName).
                orElseThrow();
    }

    public HeroDto getDtoByUserName(String userName) {
        return heroMapper.toDto(getHeroByUserName(userName));
    }

    public void create(SimplePlayer simplePlayer) {
        heroRepository.save(heroFactory.from(simplePlayer.getSnapshot()));
    }

    public HeroSnapshot update(HeroSnapshot heroSnapshot) {
        return heroRepository.save(Hero.restore(heroSnapshot)).getSnapshot();
    }

    public HeroDto addExperience(HeroExpAdd heroExpAdd) {
        HeroSnapshot heroByUserName = getHeroByUserName(heroExpAdd.userName());
        return heroMapper.toDto(update(HeroSnapshot.builder()
                .id(heroByUserName.getId())
                .userName(heroByUserName.getUserName())
                .hp(heroByUserName.getHp())
                .defence(heroByUserName.getDefence())
                .attackPower(heroByUserName.getAttackPower())
                .level(heroByUserName.getLevel())
                .experience(heroByUserName.getExperience() + heroExpAdd.experience())
                .player(heroByUserName.getPlayer())
                .build()));
    }
}
