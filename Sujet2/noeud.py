class Noeud:
    def __init__(self, identifiant, capacite_memoire):
        self.id = identifiant
        self.capacite_memoire = capacite_memoire
        self.liste_donnees_stockees = []
        self.liste_noeuds_accessibles = []

    def get_id(self):
        return self.id

    def get_capacite_memoire(self):
        return self.capacite_memoire

    def ajouter_noeud_accessible(self, noeud):
        self.liste_noeuds_accessibles.append(noeud)

    def ajouter_donnee_stockee(self, donnee):
        self.liste_donnees_stockees.append(donnee)
