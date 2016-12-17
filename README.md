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

V 2.1 :
* Gestion de fin de partie :
 - [x] faire apparaître le message "GAME OVER" et le score quand la partie est finie.
 - [x] possibilité d'appuyer sur 'R' si la partie est finie pour en relancer une.
* Gestion des collisions Invader-Spaceship.
 - [x] les deux éléments sont éliminés.
* Gestion du score de la partie :
 - [x] le score s'affiche sur l'écran.
 - [x] le score augmente lorsque l'on tue un Invader.
* Gestion des vies de la partie :
 - [x] les vies s'affichent sur l'écran.
 - [x] les vies décrémentent lors d'une collision Invader-Spaceship.

V 3.0 :
* Modification du niveau de difficulté en fonction du score :
 - [x] plus le score est élevé plus les invaders apparaissent nombreux et rapidement.
* Gestion des bonus du tir spécial :
 - [x] les bonus du tir spécial ont une certaine probabilité d'apparaître à la mort des invaders.
 - [x] lorsque le vaisseau touche un bonus du tir spécial, le bonus disparaît et s'ajoute à la liste de bonus du tir spécial.
 - [x] si le joueur a 3 bonus du tir spécial, il ne peut plus en accumuler davantage.
 - [x] lorsque le bonus du tir spécial sort de l'écran, celui-ci disparaît complètement du monde.
* Les Invaders lâchent des bombes de façon aléatoire :
 - [x] les bombes apparaissent et interagissent comme les Invaders.
 - [x] les bombes donnent un score plus élevé.
 - [x] chaque Invader a entre 0 et 3 bombes.
* Mettre le jeu en pause :
 - [x] une pression sur la touche ÉCHAP met le jeu en pause et affiche l’écran de pause.

V 3.1 :
* Gestion des bonus de vie :
 - [x] lorsqu'un alien meurt, il a 5% de chance de faire apparaître un bonus puis 50% de chance de faire apparaître soit un SpecialShootBonus, soit un LifeBonus.
* Tir spécial :
 - [x] le vaisseau, s'il possède au moins un bonus du tir spécial, peut lancer un tir spécial via la touche "N".
 - [x] lorsqu'un tir spécial (ShoopDaWhoop) est lancé, les tirs normaux sont bloqués et "l'animation" (image + son) commence.
 - [x] le tir spécial tue tous les aliens devant le vaisseau.
* Gestion de la musique de fond :
 - [x] le jeu lance automatiquement une musique de fond lors d'une partie.
 
V 3.2 :
* Tir spécial :
 - [x] tir spécial simplifié ; le vaisseau tire un puissant rayon laser destructeur.
* Gestion des déserteurs des vaisseaux aliens :
 - [x] un petit vaisseau déserteur peut être expulsé par les Invaders à tout moment ; il produit des dégâts au contact du vaisseau joueur.
* Gestion de la musique de fond :
 - [x] la musique peut être arrêtée ou relancée à l'aide d'une pression sur la touche 'M'.


# Diagrams

https://www.lucidchart.com/invitations/accept/3525ba89-ac91-4f6b-8123-3785bc5c30e2
