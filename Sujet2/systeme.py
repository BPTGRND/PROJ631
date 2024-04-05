class Systeme:
    def __init__(self, identifiant):
        self.id = identifiant
        self.liste_donnees = []
        self.liste_utilisateurs = []
        self.liste_noeuds = []

    def set_liste_donnees(self, liste_donnees):
        self.liste_donnees = liste_donnees

    def set_liste_utilisateurs(self, liste_utilisateurs):
        self.liste_utilisateurs = liste_utilisateurs

    def set_liste_noeuds(self, liste_noeuds):
        self.liste_noeuds = liste_noeuds

    def placer_donnees(self):
        for donnee in self.liste_donnees:
            noeud_plus_proche = None
            distance_min = float('inf')
            donnee_id = donnee.get_id()
            # Trouver le nœud système le plus proche de l'utilisateur intéressé par la donnée
            for utilisateur in self.liste_utilisateurs:
                if donnee.get_id() in utilisateur.liste_donnees_interet:
                    for noeud in self.liste_noeuds:
                        noeud_id = noeud.get_id()
                        # Vérifier si le nœud peut stocker la donnée et est plus proche que le précédent
                        if donnee.get_taille() <= self.calculer_taille_restante(noeud):
                            distance = abs(utilisateur.noeud_accessible - noeud_id)
                            if distance < distance_min:
                                distance_min = distance
                                for noeud_bis in self.liste_noeuds:
                                    if noeud_bis.get_id() == noeud_id:
                                        noeud_plus_proche = noeud
                                        break

            # Placer la donnée sur le nœud système le plus proche
            if noeud_plus_proche is not None:
                noeud_plus_proche.ajouter_donnee_stockee(donnee_id)
                print(f"Donnée {donnee_id} placée sur le nœud système {noeud_plus_proche.get_id()}.")
            else:
                print(f"Impossible de placer la donnée {donnee_id} sur un nœud système.")

    def calculer_taille_restante(self, noeud):
        taille_totale = 0
        for donnee_id in noeud.liste_donnees_stockees:
            for donnee in self.liste_donnees:
                if donnee.get_id() == donnee_id:
                    taille_totale += donnee.get_taille()
                    break
        taille_restante = noeud.get_capacite_memoire() - taille_totale
        return taille_restante
