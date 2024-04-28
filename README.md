# Sujet 1 - Gestion d'un réseau de bus (JAVA)

Ce projet vise à modéliser un réseau de bus en utilisant des structures de données appropriées pour prendre en compte les contraintes horaires, les jours fériés, les nuits et les vacances. L'objectif est de permettre aux utilisateurs de saisir des données relatives au réseau de bus, de calculer des itinéraires entre deux arrêts de bus avec plusieurs options (le plus court, le plus rapide, le plus tôt) et de fournir des résultats pertinents en fonction des contraintes spécifiées.

## Structure de données

Nous utilisons des graphes orientés pour représenter le réseau de bus. Chaque nœud du graphe représente un arrêt de bus et chaque arc représente une connexion entre deux arrêts avec un temps associé.

## Fonctionnalités

- **Saisie de données** : Le programme offre une interface utilisateur pour saisir les horaires des bus.
- **Calcul d'itinéraire** : Calculez le plus court chemin, le chemin le plus rapide ou le chemin arrivant le plus tôt entre deux arrêts de bus en prenant en compte les contraintes temporelles spécifiées.

## Installation
Clonez ce dépôt sur votre machine locale avec cette commande :
git clone `https://github.com/BPTGRND/PROJ631.git`

## Utilisation

Assurez-vous de modifier la ligne 28 du programme pour bien récupérer les fichiers .txt.

1. Lancez le programme en exécutant le fichier `Main.java`.
2. Suivez les instructions pour saisir les données du réseau de bus et spécifier les options de recherche d'itinéraire.
3. Obtenez les résultats de la recherche d'itinéraire avec les différentes options disponibles.

# Sujet 2 - Stockage de données personnelles (PYTHON)

Ce projet vise à créer un système de stockage pour données personnelles, avec des structures pour les utilisateurs, les nœuds système et les données. L'objectif est d'optimiser le placement des données pour minimiser les temps d'accès, en tenant compte des capacités de stockage et des intérêts multiples des utilisateurs pour une même donnée.

## Structure de données

La structure de données proposée pour ce système comprend trois entités principales : les données, les utilisateurs et les nœuds système. Cette structure permet de modéliser les relations entre les différentes entités du système, facilitant ainsi la gestion et l'optimisation du stockage des données en fonction des besoins des utilisateurs et des contraintes des nœuds système.

## Fonctionnalités

- **Placement de données sur un système** : Cette fonctionnalité consiste à déterminer l'emplacement optimal pour chaque donnée dans le système. L'algorithme prend en compte les préférences des utilisateurs pour chaque donnée et les capacités de stockage disponibles sur les différents nœuds système.

## Installation
Clonez ce dépôt sur votre machine locale avec cette commande :
git clone `https://github.com/BPTGRND/PROJ631.git`

## Utilisation

1. Lancez le programme en exécutant le fichier `main.py` dans le dossier Sujet2.
2. Obtenez les résultats du placement des données sur le système en fonctions des différentes contraintes.
