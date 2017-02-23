# Reman

Le but de ce projet est de permettre de mettre à disposition des logiciels et de les distribuer à toute personne désirant les utiliser. Pour cela, une personne ou un groupe se chargeant de l’administration d’un serveur devra pouvoir ajouter des outils à la liste des logiciels disponibles. La solution devra permettre d’archiver les version antérieurs des outils pour pouvoir en disposer en cas d’audit.
En parallèle, un web service devra permettre à un logiciel d’informer l’utilisateur de l’existence d’une version plus récente que la version en cours d'utilisation.

# Définition des besoins :
* S’assurer qu’un utilisateur dispose de la dernière version d’un outil.
* Permettre de télécharger n’importe quel version d’un outil à tout les utilisateurs.
* Archiver les précédentes versions d’outil pour audit.
* Disposer d’une interface de téléchargement.
* Disposer d’une interface de téléversement.
* Rechercher une version d’outil spécifique.
* Gestion des droits utilisateurs.

# Fonctionnalités :
* Lister l’ensemble des outils disponibles.
* Trier par nom et par version.
* La recherche d’un outil affiche en premier lieu la version la plus récente et liste ensuite les version antérieurs par ordre naturel inversé.
