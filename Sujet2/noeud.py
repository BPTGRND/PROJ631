class Noeud:
    def __init__(self, identifiant, capacite_memoire):
        self.id = identifiant
        self.capacite_memoire = capacite_memoire
        self.liste_donnees_stockees_localement = []
        self.liste_noeuds_accessibles = []