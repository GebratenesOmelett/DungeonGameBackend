package game.backend.dungeongamebackend.hero;

import game.backend.dungeongamebackend.hero.dto.HeroDto;
import org.springframework.stereotype.Service;

@Service
class HeroMapper {
    HeroDto toDto(HeroSnapshot heroSnapshot) {
        return new HeroDto(heroSnapshot.getHp(),
                heroSnapshot.getDefence(),
                heroSnapshot.getAttackPower(),
                heroSnapshot.getUserName(),
                heroSnapshot.getLevel(),
                heroSnapshot.getExperience());
    }
}
