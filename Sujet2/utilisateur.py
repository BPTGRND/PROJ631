class Utilisateur:
    def __init__(self, identifiant):
        self.id = identifiant
        self.liste_donnees_interet = []
        self.noeud_accessible = int

    def ajouter_donnee_interet(self, donnee):
        self.liste_donnees_interet.append(donnee)

    def ajouter_noeud_accessible(self, noeud):
        self.noeud_accessible = noeud
