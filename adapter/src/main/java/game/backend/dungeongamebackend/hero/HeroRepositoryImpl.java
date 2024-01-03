package game.backend.dungeongamebackend.hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface SqlHeroRepository extends JpaRepository<HeroSnapshot, Integer>{
    HeroSnapshot save(HeroSnapshot heroSnapshot);
    Optional<HeroSnapshot> findHeroSnapshotByUserName(String userName);
}
@Repository
class HeroRepositoryImpl implements HeroRepository, HeroQueryRepository{
    private final SqlHeroRepository sqlHeroRepository;

    HeroRepositoryImpl(SqlHeroRepository sqlHeroRepository) {
        this.sqlHeroRepository = sqlHeroRepository;
    }
    @Override
    public Hero save(Hero hero) {
        return Hero.restore(sqlHeroRepository.save(hero.getSnapshot()));
    }

    @Override
    public Optional<HeroSnapshot> getHeroSnapshotByUserName(String userName) {
        return sqlHeroRepository.findHeroSnapshotByUserName(userName);
    }

}
