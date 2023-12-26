package game.backend.dungeongamebackend.hero;

import java.util.Optional;

interface HeroQueryRepository {
    Optional<HeroSnapshot> getHeroSnapshotByUserName(String userName);
}
