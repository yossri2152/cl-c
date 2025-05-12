package tn.cloudcrafters.picloud.services.gestionboutique.LigneCommande;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.cloudcrafters.picloud.entity.gestionboutique.LigneCommande;
import tn.cloudcrafters.picloud.Repository.gestionboutique.ILigneCommandeRepository;

@Service
@RequiredArgsConstructor
public class LigneCommandeService implements ILigneCommandeService {

    private final ILigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(ILigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public LigneCommande getLigneCommandeById(Long id) {
        return ligneCommandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ligne de commande non trouvée"));
    }

    @Override
    public LigneCommande updateLigneCommande(Long id, LigneCommande ligneCommande) {
        ligneCommande.setId(id);
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public void deleteLigneCommande(Long id) {
        ligneCommandeRepository.deleteById(id);
    }
}