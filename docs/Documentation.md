# Task 1
Behavioural pattern - Options: *Strategy* or *Observer* pattern.
You chose: <REPLACE WITH PATTERN OF CHOICE>

## Itemise changes made (which class files were modified)
1. Chose to go with the Strategy Pattern.
2. Created a base interface named Search Strategy with an abstract method ***execute()*** For which others search strategies may implement.
3. Refactored the Inventory.java :: ***searchItems()*** method from being if elif elif statement to each search strategy class overwriting the ***execute()*** method with its existing logic.
4. Changed the searchBy Global Variable of Inventory.java to be of type SearchStrategy.
5. Refactored the Inventory.java :: ***setSearch()*** Method to return Search Strategy Based on its term Parameter String.
6. Inventory.java :: ***searchItems()*** now calls and returns the result of the SearchBy.execute method.


# Task 2
Structural pattern - *Composite* pattern.

## Itemise changes made (which class files were modified)
1. 

# Task 3

## Itemised changes or new files
1. 

## What was changed
1. 

## Why it was changed
1. 

## The benefits of the change
1. 