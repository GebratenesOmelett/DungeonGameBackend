package game.backend.dungeongamebackend.monster;
import java.util.Optional;

interface MonsterRepository {
    Optional<MonsterSnapshot> findMonsterSnapshotByName(String email);
    Monster save(Monster monster);
}
