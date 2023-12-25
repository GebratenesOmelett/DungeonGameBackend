package game.backend.dungeongamebackend.monster;

import jakarta.persistence.*;

@Entity
@Table(name = "monster")
class MonsterSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int health;
    private int attackPower;

    protected MonsterSnapshot() {
    }

    MonsterSnapshot(MonsterSnapshotBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.health = builder.health;
        this.attackPower = builder.attackPower;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getHealth() {
        return health;
    }

    int getAttackPower() {
        return attackPower;
    }

    static class MonsterSnapshotBuilder{
        private int id;
        private String name;
        private int health;
        private int attackPower;
        MonsterSnapshot.MonsterSnapshotBuilder setName(String name) {
            this.name = name;
            return this;
        }

        MonsterSnapshot.MonsterSnapshotBuilder setHealth(int health) {
            this.health = health;
            return this;
        }

        MonsterSnapshot.MonsterSnapshotBuilder setAttackPower(int attackPower) {
            this.attackPower = attackPower;
            return this;
        }

        MonsterSnapshot.MonsterSnapshotBuilder setId(int id) {
            this.id = id;
            return this;
        }

        MonsterSnapshot build(){
            return new MonsterSnapshot(this);
        }
    }
}
