package tn.cloudcrafters.picloud.services.gestionboutique.commande;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.cloudcrafters.picloud.entity.gestionboutique.Commande;

public interface ICommandeService {
    Commande createCommande(Commande commande);
    Page<Commande> getAllCommandes(Pageable pageable);
    Commande getCommandeById(Long id);
    Commande updateCommande(Long id, Commande commande);
    void deleteCommande(Long id);
}