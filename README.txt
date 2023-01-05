D&D Dungeon Master Initiative Tracker

This application allows the users to add D&D monster and allies into a tracker that helps keep order on whose turn
it is while also keeping track of the player's initiative. The D&D monster and allies are all formatted in JSON file
that allows for easy accessibility to the stats of each monster and ally. By using Jackson annotation, the program can
easily read and store the appropriately formatted JSON files. The program also accepts player initiative, but at this
version the user can only add the player name and initiative number(which would be provided by the player's dice roll).

Once the user is done entering the monsters, allies, and players they want for their round of combat, the program will
then roll the dice for initiative for all participants, except for the players. The dice roll for initiative is
calculated by a random roll of a d20 plus the participants dexterity bonus. Having the program roll for all the monster
and allies cuts down on the time in which the Dungeon master needs to roll for each participant. Then the program
prints out the all the participants(including the players) in a list of the participants name and what initiative they
rolled in descending order. Below the list, whoever turn it is, will display the participants' information. For example,
if it is a monster's turn then it will display current HP, size, attributes, and what attacks it can perform(more
information will be displayed in future iterations). If it is the players turn then the program will display just the
name of the player. The program(at this current version) expects the player to keep track of their own stats. This
initiative list helps the Dungeon Master have easy access to the monster and ally stats while keeping the turns in order
all in one place for easy access.

During a monster or allies turn, there is several options the user can do. All these options are supposed to represent
all the options the DM has during a combat rounds. The current options that are implemented are reducing or adding
health, adding more allies and monster during the combat, have the monster roll for their attacks and calculate the
damage, and roll skill checks and saving throws.

The program needs to run in IntelliJ IDEA(Java) with a Windows OS. The program also needs to have the Jackson library
and JUNIT library installed as well.

Written by Matthew Wingerden
