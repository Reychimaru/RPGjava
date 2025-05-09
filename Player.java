public class Player {
    private String name;
    private int health;
    private int mana;
    private int strength;
    private int dexterity;
    private int intellect;

    public Player(String name, int strength, int dexterity, int intellect) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intellect = intellect;
        this.health = strength + 20;
        this.mana = intellect + 10;
    }

    // Getter e Setter
public String getName() {
    return name;
}

public int getHealth() {
    return health;
}

public void setHealth(int health) {
    this.health = Math.max(0, health); // Evita valori negativi
}

public int getMana() {
    return mana;
}

public void setMana(int mana) {
    this.mana = Math.max(0, mana); // Evita valori negativi
}

public int getStrength() {
    return strength;
}

public void setStrength(int strength) {
    this.strength = strength;
}

public int getDexterity() {
    return dexterity;
}

public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
}

public int getIntellect() {
    return intellect;
}

public void setIntellect(int intellect) {
    this.intellect = intellect;
}

    public int attack() {
        return strength + (int) (Math.random() * 20) + 1;
    };

    public int attackDamage() {
        return strength + (int) (Math.random() * 20) + 1;
    };

    public int thunderbolt() {
        return intellect + (int) ((Math.random() * 6) + 1) * 2;
    };

    public int fireball() {
        return intellect + (int) ((Math.random() * 8) + 1) * 3;
    };

    public int dodge() {
        return dexterity + (int) (Math.random() * 20) + 1;
    }

    public int escape() {
        return dexterity + (int) (Math.random() * 20) + 1;
    }
}