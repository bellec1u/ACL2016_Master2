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

V 2.0
* Generer des Invaders :
 - [x] Fait apparaitre x invaders à des position aléatoires en haut de l’écran tout les y temps (hors de l’écran en haut).
 - [x] Faire en sorte que les invaders ne se superposent pas.
* Faire disparaitre un laser.
 - [x] le laser disparait lorsqu'il sort de l'ecran :
* Faire disparaitre un invader.
 - [x] l'invader disparait lorsqu'il sort de l'ecran :
* Gestion des collisions Invader-Laser.
 - [x] les 2 elements sont eliminés.
 
 V2.1
 * Gestion de fin de partie :
 - [x] faire apparaitre le message "GAME OVER" et le score quand la partie est finie.
 - [x] possibilité d'appuyer sur R si la partie est finie pour en relancer une.
 * Gestion des collisions Invader-Spaceship.
 - [x] les 2 elements sont eliminés.
 * Gestion du score de la partie :
 - [x] le score s'affiche sur l'écran
 - [x] le score augmente lorsque l'on tue un Invader.
  * Gestion des vies de la partie :
 - [ ] les vies s'affichent sur l'écran.
 - [ ] les vies décrémentes lors d'une collision Invader-Spaceship.

# Diagrams

https://www.lucidchart.com/invitations/accept/3525ba89-ac91-4f6b-8123-3785bc5c30e2
