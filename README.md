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

# The way of playing
The application choose you randomly n cards among the 40 mixed up cards (n: is a number fixed at the start of the game, which is 21 by default), the user chooses one among these n cards mentally, and after the program asks if the user has chosen well, and that he remembers well one among these n cards shown in front of him, if this is the case the user clicks on Y or y, and in this step the program divides these n cards into 3 groups and the user chooses among which group the card he has chosen exists, the program now takes care of merging these groups and dividing a second time and a third time these n cards, and finally the program is able to predict which card the user has chosen.
