package ru.reeson2003.model.game.characters.items.TMPItem;

/**
 * Created by nimtego_loc on 13.12.2016.
 */

class Item {
    private ItemState mapItemState;
    private ItemState inventoryItemState;
    private ItemState equipItemState;
    private ItemState state = mapItemState;
    private String name;
    private int price;
    private int weight;

    public Item(String name) {
        this.name = name;
        this.mapItemState = new MapItemState(this);
        this.inventoryItemState = new InventoryItemState(this);
        this.equipItemState = new EquipItemState(this);
        this.state = mapItemState;
    }

    public void liftItemWithMaps() {
        state.liftItemWithMaps();
    }

    public void putOnItem() {
        state.putOnItem();
    }

    public void putOffItem() {
        state.putOffItem();
    }

    public void throwOutItem() {
        state.throwOutItem();
    }

    public ItemState getState() {
        return state;
    }

    public void setState(final ItemState itemState) {
        this.state = itemState;
    }

    public ItemState getMapItemState() {
        return mapItemState;
    }

    public ItemState getInventoryItemState() {
        return inventoryItemState;
    }

    public ItemState getEquipItemState() {
        return equipItemState;
    }
}

interface ItemState {
    void liftItemWithMaps();

    void putOnItem();

    void putOffItem();

    void throwOutItem();

    void setItem(Item item);

    Item getItem();
}

class MapItemState implements ItemState {
    private Item item;

    public MapItemState(Item item) {
        this.item = item;
        this.item.setState(this.item.getMapItemState());
    }

    public void liftItemWithMaps() {
        System.out.println(" LIFT ");
        item.setState(item.getInventoryItemState());
    }

    public void putOnItem() {
        System.out.println(" Nedd LIFT ");
    }

    public void putOffItem() {
        System.out.println(" Nedd LIFT and PUT ON");
    }

    public void throwOutItem() {
        System.out.println(" Nedd LIFT ");
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }
}

class InventoryItemState implements ItemState {
    private Item item;

    public InventoryItemState(Item item) {
        this.item = item;
        this.item.setState(this.item.getInventoryItemState());
    }

    public void liftItemWithMaps() {
        System.out.println(" Need throw item first ");
    }

    public void putOnItem() {
        System.out.println(" PUT ON ");
        item.setState(item.getEquipItemState());
    }

    public void putOffItem() {
        System.out.println(" Need LIFT and PUT ON");
    }

    public void throwOutItem() {
        System.out.println(" Drop in map ");
        item.setState(item.getMapItemState());
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }
}

class EquipItemState implements ItemState {
    private Item item;

    public EquipItemState(Item item) {
        this.item = item;
        this.item.setState(this.item.getEquipItemState());
    }

    public void liftItemWithMaps() {
        System.out.println(" Need put Off first and throw");
    }

    public void putOnItem() {
        System.out.println(" Already ");
    }

    public void putOffItem() {
        System.out.println(" Put off. In Inventory");
        item.setState(item.getInventoryItemState());
    }

    public void throwOutItem() {
        System.out.println(" Need put Off first ");
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public Item getItem() {
        return item;
    }
}

class IronOre extends Item {

    public IronOre() {
        super("Iron Ore");
    }
}

class TestItem {
    public static void main(String[] args) {
        // Ворлд мапа >>>
        ItemState[][] worldMap = new MapItemState[10][10];
        Item item = new Item("BOOTS");
        worldMap[0][0] = new MapItemState(item);
        // Пытаюсь сразу надеть >>
        worldMap[0][0].putOnItem();
        ItemState[] inventory = new InventoryItemState[10];
        inventory[0] = new InventoryItemState(worldMap[0][0].getItem());
        inventory[0].putOnItem();
        inventory[0].putOffItem();
        ItemState equip = new EquipItemState(new Item("JJJ"));
        Item itemTest1 = new Item("Test 1");
        ItemState testMap = new MapItemState(itemTest1);
        testMap.putOnItem();
        ItemState testInvento = new InventoryItemState(itemTest1);
        testInvento.putOnItem();
    }
}



