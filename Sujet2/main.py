import donnee as d
import utilisateur as u
import noeud as n
import systeme as s

donnee0 = d.Donnee(0, 10)
donnee1 = d.Donnee(1, 40)
donnee2 = d.Donnee(2, 30)
donnee3 = d.Donnee(3, 10)
donnee4 = d.Donnee(4, 20)
donnee5 = d.Donnee(5, 10)
donnee6 = d.Donnee(6, 20)
donnee7 = d.Donnee(7, 30)
donnee8 = d.Donnee(8, 20)

utilisateur0 = u.Utilisateur(0)
utilisateur1 = u.Utilisateur(1)
utilisateur2 = u.Utilisateur(2)
utilisateur3 = u.Utilisateur(3)
utilisateur4 = u.Utilisateur(4)
utilisateur5 = u.Utilisateur(5)
utilisateur6 = u.Utilisateur(6)
utilisateur0.ajouter_donnee_interet(donnee0.get_id())
utilisateur1.ajouter_donnee_interet(donnee1.get_id())
utilisateur1.ajouter_donnee_interet(donnee2.get_id())
utilisateur2.ajouter_donnee_interet(donnee5.get_id())
utilisateur2.ajouter_donnee_interet(donnee3.get_id())
utilisateur3.ajouter_donnee_interet(donnee4.get_id())
utilisateur4.ajouter_donnee_interet(donnee6.get_id())
utilisateur5.ajouter_donnee_interet(donnee8.get_id())
utilisateur6.ajouter_donnee_interet(donnee7.get_id())

noeud0 = n.Noeud(0, 40)
noeud1 = n.Noeud(1, 40)
noeud2 = n.Noeud(2, 50)
noeud3 = n.Noeud(3, 40)
noeud4 = n.Noeud(4, 50)

system = s.System(1)
