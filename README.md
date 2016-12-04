# Developers

* BELLEC Leopold
* DAUZVARDIS Juozas
* JUNGES Pierre-Marie
* LIPSKI Guillaume

# Planned features

V 1.0 :
* Déplacer un GameMoveable :
 - [x] le SpaceShip peut aller à gauche, droite ou peut ne pas bouger.
 - [x] le SpaceShip ne peut pas sortir de l'écran par la gauche ni la droite.
 - [x] l'Invader se déplace vers le bas.

V 1.1 :
* Afficher les GameElement :
 - [x] le SpaceShip, l'Invader et le Laser ont une image.
 - [x] le SpaceShip, l'Invader et le Laser apparaissent dans la zone de jeu.
* Interactions joueur/machine (listeners) :
 - [x] le SpaceShip se déplace vers la gauche lorsque l'utilisateur appuie sur la flèche gauche.
 - [x] le SpaceShip se déplace vers la droite lorsque l'utilisateur appuie sur la flèche droite.
 - [x] le SpaceShip ne bouge pas si l'utilisateur ne fait rien.
 - [x] le SpaceShip tire un Laser lorsque l'utilisateur appuie sur la barre espace.
* Tirer un Laser :
 - [x] un Laser apparaît devant le vaisseau lors d'une pression de la barre espace.
 - [x] le Laser se déplace automatiquement vers le haut.

V 2.0 :
* Générer des Invaders :
 - [x] faire apparaître x invaders à des positions aléatoires en haut de l'écran tous les y temps (hors de l’écran en haut).
 - [x] faire en sorte que les Invaders ne se superposent pas.
* Faire disparaître un laser :
 - [x] le laser disparaît lorsqu'il sort de l'écran.
* Faire disparaître un Invader :
 - [x] l'Invader disparaît lorsqu'il sort de l'écran.
* Gestion des collisions Invader-Laser :
 - [x] les 2 éléments sont éliminés.

V2.1 :
* Gestion de fin de partie :
 - [x] faire apparaître le message "GAME OVER" et le score quand la partie est finie.
 - [x] possibilité d'appuyer sur R si la partie est finie pour en relancer une.
* Gestion des collisions Invader-Spaceship.
 - [x] les deux éléments sont éliminés.
* Gestion du score de la partie :
 - [x] le score s'affiche sur l'écran.
 - [x] le score augmente lorsque l'on tue un Invader.
* Gestion des vies de la partie :
 - [x] les vies s'affichent sur l'écran.
 - [x] les vies décrémentent lors d'une collision Invader-Spaceship.

# Diagrams

https://www.lucidchart.com/invitations/accept/3525ba89-ac91-4f6b-8123-3785bc5c30e2
