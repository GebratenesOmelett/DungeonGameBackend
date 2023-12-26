package game.backend.dungeongamebackend.player;

import game.backend.dungeongamebackend.auth.JwtService;
import game.backend.dungeongamebackend.auth.dto.AuthenticationResponse;
import game.backend.dungeongamebackend.hero.HeroFacade;
import game.backend.dungeongamebackend.player.dto.PlayerCreateDto;
import game.backend.dungeongamebackend.player.dto.PlayerLoginDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class PlayerFacade {
    private final PlayerRepository playerRepository;
    private final PlayerQueryRepository playerQueryRepository;
    private final PlayerFactory playerFactory;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final HeroFacade heroFacade;
    private final PlayerMapper playerMapper;


    PlayerFacade(PlayerRepository playerRepository, PlayerQueryRepository playerQueryRepository,
                 PlayerFactory playerFactory, JwtService jwtService, AuthenticationManager authenticationManager,
                 HeroFacade heroFacade, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerQueryRepository = playerQueryRepository;
        this.playerFactory = playerFactory;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.heroFacade = heroFacade;
        this.playerMapper = playerMapper;
    }
    public PlayerSnapshot getPlayerSnapshotByEmail(String email){
        return playerQueryRepository.findPlayerSnapshotByEmail(email)
                .orElseThrow();
    }

    public AuthenticationResponse create(PlayerCreateDto playerCreateDto) {
        Player player = playerFactory.from(playerCreateDto);
        heroFacade.create(playerMapper.toSimplePlayer(playerRepository.save(player).getSnapshot()));
        var jwtToken = jwtService.generateToken(player.getSnapshot());
        return new AuthenticationResponse(jwtToken, playerCreateDto.getUserName(), playerCreateDto.getEmail(), Integer.toString(JwtService.expiration));
    }

    public AuthenticationResponse login(PlayerLoginDto playerLoginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        playerLoginDto.getEmail(),
                        playerLoginDto.getPassword()
                )
        );
        PlayerSnapshot player = getPlayerSnapshotByEmail(playerLoginDto.getEmail());
        var jwtToken = jwtService.generateToken(player);
        return new AuthenticationResponse(jwtToken, player.getUserName(), player.getEmail(), Integer.toString(JwtService.expiration));
    }
}
