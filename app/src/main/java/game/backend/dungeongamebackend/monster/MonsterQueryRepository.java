package game.backend.dungeongamebackend.monster;

import java.util.Optional;

interface MonsterQueryRepository {
    Optional<Monster> findMonsterSnapshotByName(String email);
    long countAllMonsters();
}
