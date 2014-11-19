package org.dicegods.dicegodsplayercreator.beans;

public class ItemBelt {
    private Integer maxItems;
    private Integer currentItems;

    private static final String TO_STRING = "ItemBelt {maxItems=%d, currentItems=%d}";

    public ItemBelt(Integer maxItems) {
        this.maxItems = maxItems;
        this.currentItems = 0;
    }

    public Integer getCurrentItems() {
        return currentItems;
    }

    public Integer getMaxItems() {
        return maxItems;
    }

    public void addItems(Integer amount) {
        currentItems += amount;

        if(currentItems > maxItems) {
            currentItems = maxItems;
        }
    }

    public void subtractItem(Integer amount) {
        currentItems -= amount;

        if(currentItems < 0) {
            currentItems = 0;
        }
    }

    @Override
    public String toString() {
        return String.format(TO_STRING, maxItems, currentItems);
    }
}
