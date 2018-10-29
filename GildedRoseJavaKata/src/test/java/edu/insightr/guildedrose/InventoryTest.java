package edu.insightr.guildedrose;

import edu.insightr.gildedrose.Inventory;
import edu.insightr.gildedrose.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {
    @Test
    void agedBrie() {

        //SETUP
        Inventory inventTest = new Inventory();
        Item agedBrie = new Item(" Aged Brie", 2, 0);
        Item[] itemsTest = new Item[1];
        itemsTest[0] = agedBrie;

        //Action
        inventTest.updateQuality();

        //TEST DU RESULTAT
        assertEquals(1, inventTest.getItems()[0].getQuality());
    }

}