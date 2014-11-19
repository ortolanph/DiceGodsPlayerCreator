package org.dicegods.dicegodsplayercreator.beans;

public class Player {
    private Integer id;
    private String name;
    private String deity;
    private Attribute life;
    private Attribute mana;
    private ItemBelt potions;
    private ItemBelt elixirs;
    private Integer shield;

    private static final String TO_STRING_FORMAT = "Player {id=%d, name='%s', deity='%s', life=%s, mana=%s, potions=%s, elixirs=%s, shield=%d}";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeity() {
        return deity;
    }

    public void setDeity(String deity) {
        this.deity = deity;
    }

    public Attribute getLife() {
        return life;
    }

    public void setLife(Attribute life) {
        this.life = life;
    }

    public Attribute getMana() {
        return mana;
    }

    public void setMana(Attribute mana) {
        this.mana = mana;
    }

    public ItemBelt getPotions() {
        return potions;
    }

    public void setPotions(ItemBelt potions) {
        this.potions = potions;
    }

    public ItemBelt getElixirs() {
        return elixirs;
    }

    public void setElixirs(ItemBelt elixirs) {
        this.elixirs = elixirs;
    }

    public Integer getShield() {
        return shield;
    }

    public void setShield(Integer shield) {
        this.shield = shield;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (!deity.equals(player.deity)) return false;
        if (!id.equals(player.id)) return false;
        if (!name.equals(player.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + deity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_FORMAT, id, name, deity, life.toString(), mana.toString(), potions.toString(), elixirs.toString(), shield);
    }
}