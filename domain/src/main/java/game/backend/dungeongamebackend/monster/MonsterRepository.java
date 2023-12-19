package game.backend.dungeongamebackend.monster;
import java.util.Optional;

interface MonsterRepository {
    Optional<MonsterSnapshot> findMonsterSnapshotByName(String email);
    Optional<MonsterSnapshot> findMonsterSnapshotById(int id);
    Monster save(Monster monster);
}
