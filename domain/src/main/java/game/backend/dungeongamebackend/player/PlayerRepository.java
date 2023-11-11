package game.backend.dungeongamebackend.player;

import java.util.Optional;

interface PlayerRepository {
    Optional<Player> findPlayerById(int id);
    Player save(Player player);
}
