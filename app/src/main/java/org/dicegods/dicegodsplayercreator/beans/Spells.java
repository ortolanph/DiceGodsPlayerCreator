package org.dicegods.dicegodsplayercreator.beans;

public enum Spells {
    STRONG_SPELL(5),
    MEDIUM_SPELL(3),
    WEAK_SPELL(2);

    private Integer manaPointSpent;

    private Spells(int manaPointSpent) {
        this.manaPointSpent = manaPointSpent;
    }

    public Integer getManaPointSpent() {
        return manaPointSpent;
    }
}
