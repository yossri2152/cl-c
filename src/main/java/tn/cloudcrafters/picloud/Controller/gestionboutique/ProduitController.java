package tn.cloudcrafters.picloud.Controller.gestionboutique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.cloudcrafters.picloud.entity.gestionboutique.Produit;
import tn.cloudcrafters.picloud.services.gestionboutique.produit.IProduitService;

import java.io.IOException;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final IProduitService produitService;

    public ProduitController(IProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping
    public ResponseEntity<Page<Produit>> getAllProduits(Pageable pageable) {
        return ResponseEntity.ok(produitService.getAllProduits(pageable));
    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Produit> createProduit(
            @RequestPart Produit produit,
            @RequestPart(required = false) MultipartFile image) throws IOException {
        return ResponseEntity.ok(produitService.createProduit(produit, image));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }

    @GetMapping("/categorie/{categorieId}")
    public ResponseEntity<Page<Produit>> getProduitsByCategorie(
            @PathVariable Long categorieId, Pageable pageable) {
        return ResponseEntity.ok(produitService.getProduitsByCategorie(categorieId, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(
            @PathVariable Long id,
            @RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.updateProduit(id, produit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.noContent().build();
    }
}