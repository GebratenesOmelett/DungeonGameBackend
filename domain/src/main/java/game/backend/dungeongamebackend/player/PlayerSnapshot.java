package game.backend.dungeongamebackend.player;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "player")
@Getter
class PlayerSnapshot implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private String userName;

    protected PlayerSnapshot() {
    }

    PlayerSnapshot(PlayerSnapshotBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.userName = builder.userName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    static class PlayerSnapshotBuilder{
        private int id;
        private String email;
        private String password;
        private String userName;
        PlayerSnapshotBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        PlayerSnapshotBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        PlayerSnapshotBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        PlayerSnapshotBuilder setId(int id) {
            this.id = id;
            return this;
        }

        PlayerSnapshot build(){
            return new PlayerSnapshot(this);
        }
    }
}
