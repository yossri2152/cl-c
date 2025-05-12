package tn.cloudcrafters.picloud.services.gestionboutique.LigneCommande;

import tn.cloudcrafters.picloud.entity.gestionboutique.LigneCommande;

public interface ILigneCommandeService {
    LigneCommande createLigneCommande(LigneCommande ligneCommande);
    LigneCommande getLigneCommandeById(Long id);
    LigneCommande updateLigneCommande(Long id, LigneCommande ligneCommande);
    void deleteLigneCommande(Long id);
}