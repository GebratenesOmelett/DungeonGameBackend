package game.backend.dungeongamebackend.monster;

import java.util.Optional;

public interface MonsterQueryRepository {
    Optional<Monster> findMonsterSnapshotByName(String email);
    long countAllMonsters();
}
