class Noeud:
    def __init__(self, identifiant, capacite_memoire):
        self.id = identifiant
        self.capacite_memoire = capacite_memoire
        self.liste_donnees_stockees_localement = []
        self.liste_noeuds_accessibles = []

    def get_id(self):
        return self.id

    def ajouter_noeud_accessible(self, noeud):
        self.liste_noeuds_accessibles.append(noeud)