package tn.cloudcrafters.picloud.services.gestionboutique.commande;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.cloudcrafters.picloud.entity.gestionboutique.Commande;
import tn.cloudcrafters.picloud.Repository.gestionboutique.ICommandeRepository;

@Service
@RequiredArgsConstructor
public class CommandeService implements ICommandeService {

    private final ICommandeRepository commandeRepository;

    public CommandeService(ICommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Page<Commande> getAllCommandes(Pageable pageable) {
        return commandeRepository.findAll(pageable);
    }

    @Override
    public Commande getCommandeById(Long id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande non trouvée"));
    }

    @Override
    public Commande updateCommande(Long id, Commande commande) {
        commande.setId(id);
        return commandeRepository.save(commande);
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}