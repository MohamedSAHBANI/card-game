# card-game
this small application is a game of cards, where the program allows to display to the user, cards with a predetermined number, this last choice one among these cards mentally, and without indicating it to the program, and the role of our application is to predict which card the player has chosen. there is no magic, it is mathematics...

# technologies
It developed completely in java language, and until now it still without graphical interfaces, it has to play in command line in a clear way, I will improve it later by adding graphical interfaces ...

# Installation
this small application is easy to use, nothing is required except the installation of java development kit jdk (1.0 or more).

# content
It is made up of 3 classes, the first is called Card designates the abstraction of a game card, the card number, its type (BASTOS, ESPADAS, REY ...), as well as a static method which allows to provide us with 40 cards, and another method of shuffling those cards. due to the reusability of this class in other card games, I put the functionality of this game in another class called Functionnality, so that this class is general and reusable...
the second class Functionality provides us with several static methods that we will use in this game, and also contains a method called play, this last contains the entire steps of the game.
The third class is the main class which only allows to call the play method of the Funtionnality class.
