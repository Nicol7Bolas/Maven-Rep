package edu.insightr.gildedrose;

public class Inventory {

    private Item[] items;

    public Item[] getItems(){
        return items;
    }

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6),
                new Item("conjured silver blade", 4, 20)
        };

    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!"Aged Brie".equals(items[i].getName()) && !"Backstage passes to a TAFKAL80ETC concert".equals(items[i].getName())) {
                if (items[i].getQuality() > 0) {
                    if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                        items[i].setQuality(items[i].getQuality() - 1);
                        if (items[i].getName().contains("Conjured") || items[i].getName().contains("conjured")){
                            items[i].setQuality(items[i].getQuality() - 1);
                            //We suppose conjured items to have the word 'conjured' in their name and so their quality decreases 1 more time than normal items.
                        }
                    }
                }
            } else {
                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if ("Backstage passes to a TAFKAL80ETC concert".equals(items[i].getName())) {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                items[i].setSellIn(items[i].getSellIn() - 1);
            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName() != "Aged Brie") {
                    if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getQuality() > 0) {
                            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                                items[i].setQuality(items[i].getQuality() - 1);
                                if (items[i].getName().contains("Conjured") || items[i].getName().contains("conjured")){
                                    items[i].setQuality(items[i].getQuality() - 1);
                                    // Again, the quality of conjured items decreases twice as fast so they will lose 4 points instead of 2 after their sellIn date
                                }
                            }
                        }
                    } else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                } else {
                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        for (int i = 0; i < 10; i++) {
            inventory.updateQuality();
            inventory.printInventory();
        }
    }
}
