package game.backend.dungeongamebackend.player;

import java.util.Optional;

public interface PlayerQueryRepository {
    Optional<PlayerSnapshot> findPlayerSnapshotByEmail(String email);
}
