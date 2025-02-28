package dat.backend.model.persistence;

import dat.backend.model.entities.Item;

import java.util.List;

public class ItemFacade
{
    public static List<Item> getItems(ConnectionPool connectionPool)
    {
        return ItemMapper.getItems(connectionPool);
    }

    public static void toggleItem(int item_id, ConnectionPool connectionPool)
    {
        ItemMapper.toggleItem(item_id,connectionPool);
    }

    public static Item getItemById(int item_id, ConnectionPool connectionPool)
    {
        return ItemMapper.getItemsById(item_id, connectionPool);
    }

    public static void updateItemName(int item_id, String name, ConnectionPool connectionPool)
    {
        ItemMapper.updateItemName(item_id,name,connectionPool);
    }

    public static int addItem(String name, String username, ConnectionPool connectionPool)
    {
        return ItemMapper.addItem(name, username, connectionPool);
    }

    public static int deleteItem(String item_id, String username, ConnectionPool connectionPool)
    {
        return ItemMapper.deleteItem(item_id,username,connectionPool);
    }
}