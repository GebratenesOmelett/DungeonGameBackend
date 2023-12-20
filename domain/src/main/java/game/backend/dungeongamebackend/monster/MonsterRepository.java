package game.backend.dungeongamebackend.monster;
import java.util.Optional;

interface MonsterRepository {

    Optional<Monster> findMonsterSnapshotById(int id);
    Monster save(Monster monster);
}
