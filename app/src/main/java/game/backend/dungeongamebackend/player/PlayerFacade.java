package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.auth.JwtService;
import game.backend.dungeongamebackend.auth.dto.AuthenticationResponse;
import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import game.backend.dungeongamebackend.player.dto.PlayerLoginDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PlayerFacade {
    private final PlayerRepository playerRepository;
    private final PlayerQueryRepository playerQueryRepository;
    private final PlayerFactory playerFactory;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    PlayerFacade(PlayerRepository playerRepository, PlayerQueryRepository playerQueryRepository, PlayerFactory playerFactory, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.playerRepository = playerRepository;
        this.playerQueryRepository = playerQueryRepository;
        this.playerFactory = playerFactory;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse create(PlayerCreateDto playerCreateDto) {
        Player player = playerFactory.from(playerCreateDto);
        playerRepository.save(player);
        var jwtToken = jwtService.generateToken(player.getSnapshot());
        return new AuthenticationResponse(jwtToken, playerCreateDto.getUserName(), playerCreateDto.getEmail());
    }

    public AuthenticationResponse login(PlayerLoginDto playerLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        playerLoginDto.getEmail(),
                        playerLoginDto.getPassword()
                )
        );
        PlayerSnapshot player = playerQueryRepository.findPlayerSnapshotByEmail(playerLoginDto.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(player);
        return new AuthenticationResponse(jwtToken, player.getUserName(), player.getEmail());
    }
}
