# Réseau de Bus - Gestion des Itinéraires

Ce projet vise à modéliser un réseau de bus en utilisant des structures de données appropriées pour prendre en compte les contraintes horaires, les jours fériés, les nuits et les vacances. L'objectif est de permettre aux utilisateurs de saisir des données relatives au réseau de bus, de calculer des itinéraires entre deux arrêts de bus avec plusieurs options (le plus court, le plus rapide, le plus tôt) et de fournir des résultats pertinents en fonction des contraintes spécifiées.

## Structure de données

Nous utilisons des graphes orientés pour représenter le réseau de bus. Chaque nœud du graphe représente un arrêt de bus et chaque arc représente une connexion entre deux arrêts avec un temps associé.

## Fonctionnalités

- **Saisie de données** : Le programme offre une interface utilisateur pour saisir les horaires des bus.
- **Calcul d'itinéraire** : Calculez le plus court chemin, le chemin le plus rapide ou le chemin arrivant le plus tôt entre deux arrêts de bus en prenant en compte les contraintes temporelles spécifiées.

## Installation
Clonez ce dépôt sur votre machine locale :
git clone https://github.com/votre_nom/projet-reseau-bus.git

## Utilisation

Assurez-vous de modifier la ligne 26 du programme pour bien récupérer les fichiers .txt.

1. Exécutez le programme en exécutant le fichier `Main.java`.
2. Suivez les instructions pour saisir les données du réseau de bus et spécifier les options de recherche d'itinéraire.
3. Obtenez les résultats de la recherche d'itinéraire avec les différentes options disponibles.

## Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.
