# Task 1
Behavioural pattern - Options: *Strategy* or *Observer* pattern.
You chose: <REPLACE WITH PATTERN OF CHOICE>

## Itemise changes made (which class files were modified)
1. Chose to go with the Strategy Pattern.
2. Created a base interface named `Search Strategy` with an abstract method ***execute()*** For which others search strategies may implement.
3. Refactored the `Inventory.java` :: ***searchItems()*** method from being if elif elif statement to each search strategy class overwriting the ***execute()*** method with its existing logic.
4. Changed the **searchBy** Global Variable of `Inventory.java` to be of type `SearchStrategy`.
5. Refactored the `Inventory.java` :: ***setSearch()*** Method to return Search Strategy Based on its term Parameter String.
6. `Inventory.java` :: ***searchItems()*** now calls and returns the result of the SearchBy.execute method.


# Task 2
Structural pattern - *Composite* pattern.

## Itemise changes made (which class files were modified)
1. Created `CraftingManager.java` a "Strategy Style" interface With Abstract Methods ***craft()*** and ***uncraft()***
2. Created `StandardCraftingManager` which implements CraftingManager Inteface and overrides `CraftingManager` Methods 
3. Added Methods to `ItemDefinition.Java`
    1. ***getComponentNames()*** getter for private componentnames variable
    2. ***HashMap<ItemDefinition,Integer> getComponentQty()*** Returns a hashmap of the Item Definitions Components from  ***getComponentNames()***
    3. ***getCompositionWeight()*** returns the sum of the weights of all composing items
    4. ***setWeight()*** setter for weight variable
4. Added Methods to `Item.Java`
    1.changed **getWeight()** from optional or else setting weight to 0.0 to settign weight to ***getCompositionWeight()*** 
5. Attatched 'App.Java' existing ***setupCrafting()*** and ***setupUncrafting()*** to my Crafting Manager methods
# Task 3

## Itemised changes or new files
1. Created `CraftingManager.java` interface and Created `StandardCraftingManager`

## What was changed
1. Decided To implement Crafting as a strategy style pattern instead of the implied ItemDefinitions methods

## Why it was changed
1. 

## The benefits of the change
1. 