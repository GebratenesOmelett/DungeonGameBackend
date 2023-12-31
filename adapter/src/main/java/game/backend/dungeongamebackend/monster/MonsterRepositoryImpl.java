package game.backend.dungeongamebackend.monster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface SqlMonsterRepository extends JpaRepository<MonsterSnapshot, Integer> {
    Optional<MonsterSnapshot> findMonsterSnapshotById(int id);
    MonsterSnapshot save(MonsterSnapshot monsterSnapshot);

}
@Repository
class MonsterRepositoryImpl implements MonsterQueryRepository, MonsterRepository{
    SqlMonsterRepository sqlMonsterRepository;
    MonsterRepositoryImpl(SqlMonsterRepository sqlMonsterRepository) {
        this.sqlMonsterRepository = sqlMonsterRepository;
    }


    @Override
    public Optional<Monster> findMonsterSnapshotById(int id) {
        return sqlMonsterRepository.findMonsterSnapshotById(id).map(Monster::restore);
    }

    @Override
    public Monster save(Monster monster) {
        return Monster.restore(sqlMonsterRepository.save(monster.getSnapshot()));
    }

    @Override
    public long countAllMonsters() {
        return sqlMonsterRepository.count();
    }
}

