"""Functions to keep track and alter inventory."""

import collections
def create_inventory(items):
    """Create a dict that tracks the amount (count) of each element on the `items` list.

    :param items: list - list of items to create an inventory from.
    :return: dict - the inventory dictionary.
    """
    # return collections.Counter(items)
    m = {}
    for k in items:
        # if k not in m:
            # m[k] = 1
        # else:
            # m[k] += 1
        m[k] = m.get(k,0) + 1
    return m


def add_items(inventory, items):
    """Add or increment items in inventory using elements from the items `list`.

    :param inventory: dict - dictionary of existing inventory.
    :param items: list - list of items to update the inventory with.
    :return: dict - the inventory updated with the new items.
    """
    
    for i in items:
        # if i in inventory:
            # inventory[i] += 1
        # else:
            # inventory[i] = 1
        inventory[i] = inventory.get(i,0) + 1
    return inventory


def decrement_items(inventory, items):
    """Decrement items in inventory using elements from the `items` list.

    :param inventory: dict - inventory dictionary.
    :param items: list - list of items to decrement from the inventory.
    :return: dict - updated inventory with items decremented.
    """

    for i in items:
        if i in inventory and inventory[i] > 0:
            inventory[i] -= 1
    return inventory

def remove_item(inventory, item):
    """Remove item from inventory if it matches `item` string.

    :param inventory: dict - inventory dictionary.
    :param item: str - item to remove from the inventory.
    :return: dict - updated inventory with item removed. Current inventory if item does not match.
    """
    if item in inventory:
        del inventory[item]
    return inventory

def list_inventory(inventory):
    """Create a list containing all (item_name, item_count) pairs in inventory.

    :param inventory: dict - an inventory dictionary.
    :return: list of tuples - list of key, value pairs from the inventory dictionary.
    """

    return [(k,v) for (k,v) in inventory.items() if v >0]
