package game.backend.dungeongamebackend.hero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

interface SqlHeroRepository extends JpaRepository<HeroSnapshot, Integer>{
    Hero save(Hero hero);
}
@Repository
public class HeroRepositoryImpl implements HeroRepository{
    private final SqlHeroRepository sqlHeroRepository;

    HeroRepositoryImpl(SqlHeroRepository sqlHeroRepository) {
        this.sqlHeroRepository = sqlHeroRepository;
    }
    @Override
    public Hero save(Hero hero) {
        return sqlHeroRepository.save(hero);
    }
}
