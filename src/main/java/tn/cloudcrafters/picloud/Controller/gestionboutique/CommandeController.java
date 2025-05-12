package tn.cloudcrafters.picloud.Controller.gestionboutique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cloudcrafters.picloud.entity.gestionboutique.Commande;
import tn.cloudcrafters.picloud.services.gestionboutique.commande.ICommandeService;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {

    private final ICommandeService commandeService;

    public CommandeController(ICommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping
    public ResponseEntity<Page<Commande>> getAllCommandes(Pageable pageable) {
        return ResponseEntity.ok(commandeService.getAllCommandes(pageable));
    }

    @PostMapping
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        return ResponseEntity.ok(commandeService.createCommande(commande));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> getCommandeById(@PathVariable Long id) {
        return ResponseEntity.ok(commandeService.getCommandeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commande> updateCommande(
            @PathVariable Long id,
            @RequestBody Commande commande) {
        return ResponseEntity.ok(commandeService.updateCommande(id, commande));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
        return ResponseEntity.noContent().build();
    }
}