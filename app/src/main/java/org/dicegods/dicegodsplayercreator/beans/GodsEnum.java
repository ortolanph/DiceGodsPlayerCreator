package org.dicegods.dicegodsplayercreator.beans;

import java.util.ArrayList;
import java.util.List;

public enum GodsEnum {
    ZEUS("Zeus", 25, 50);

    private final String name;
    private final Integer life;
    private final Integer mana;

    private GodsEnum(String name, Integer life, Integer mana) {
        this.name = name;
        this.life = life;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public Integer getLife() {
        return life;
    }

    public Integer getMana() {
        return mana;
    }

    public static List<String> getGodsNames() {
        List<String> gods = new ArrayList<String>();

        for(GodsEnum god: values()) {
            gods.add(god.getName());
        }

        return gods;
    }

    public static GodsEnum retrieveByName(String name) {
        for(GodsEnum god : values()) {
            if(god.getName().equals(name)) {
                return god;
            }
        }

        throw new IllegalArgumentException(String.format("The god %s is not is this Pantheon, therefore he cannot compete on Dice Gods", name));
    }
}
