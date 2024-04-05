class Utilisateur:
    def __init__(self, identifiant):
        self.id = identifiant
        self.liste_donnees_interet = []
        self.noeud_systeme_accessible = []

    def ajouter_donnee_interet(self, donnee):
        self.liste_donnees_interet.append(donnee)

