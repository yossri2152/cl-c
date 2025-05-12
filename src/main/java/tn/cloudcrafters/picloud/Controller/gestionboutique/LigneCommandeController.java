package tn.cloudcrafters.picloud.Controller.gestionboutique;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.cloudcrafters.picloud.entity.gestionboutique.LigneCommande;
import tn.cloudcrafters.picloud.services.gestionboutique.LigneCommande.ILigneCommandeService;

@RestController
@RequestMapping("/api/lignecommandes")
public class LigneCommandeController {

    private final ILigneCommandeService ligneCommandeService;

    public LigneCommandeController(ILigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @PostMapping
    public ResponseEntity<LigneCommande> createLigneCommande(
            @RequestBody LigneCommande ligneCommande) {
        return ResponseEntity.ok(ligneCommandeService.createLigneCommande(ligneCommande));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LigneCommande> getLigneCommandeById(@PathVariable Long id) {
        return ResponseEntity.ok(ligneCommandeService.getLigneCommandeById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LigneCommande> updateLigneCommande(
            @PathVariable Long id,
            @RequestBody LigneCommande ligneCommande) {
        return ResponseEntity.ok(ligneCommandeService.updateLigneCommande(id, ligneCommande));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigneCommande(@PathVariable Long id) {
        ligneCommandeService.deleteLigneCommande(id);
        return ResponseEntity.noContent().build();
    }
}