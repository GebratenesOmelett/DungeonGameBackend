package game.backend.dungeongamebackend.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

interface SqlPlayerRepository extends JpaRepository<PlayerSnapshot, Integer> {
    Optional<PlayerSnapshot> findPlayerById(int id);

    PlayerSnapshot save(PlayerSnapshot player);

    Optional<PlayerSnapshot> findPlayerSnapshotByEmail(String email);
}

@Repository
class PlayerRepositoryImpl implements PlayerRepository, PlayerQueryRepository {

    private final SqlPlayerRepository sqlPlayerRepository;

    PlayerRepositoryImpl(SqlPlayerRepository sqlPlayerRepository) {
        this.sqlPlayerRepository = sqlPlayerRepository;
    }

    @Override
    public Optional<Player> findPlayerById(int id) {
        return sqlPlayerRepository.findPlayerById(id).map(Player::restore);
    }

    @Override
    public Player save(Player player) {
        return Player.restore(sqlPlayerRepository.save(player.getSnapshot()));
    }

    @Override
    public Optional<PlayerSnapshot> findPlayerSnapshotByEmail(String email) {
        return sqlPlayerRepository.findPlayerSnapshotByEmail(email);
    }
}
