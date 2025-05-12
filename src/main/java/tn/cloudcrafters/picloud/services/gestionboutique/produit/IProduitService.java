package tn.cloudcrafters.picloud.services.gestionboutique.produit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import tn.cloudcrafters.picloud.entity.gestionboutique.Produit;

import java.io.IOException;

public interface IProduitService {
    Produit createProduit(Produit produit, MultipartFile image) throws IOException;
    Page<Produit> getAllProduits(Pageable pageable);
    Produit getProduitById(Long id);
    Page<Produit> getProduitsByCategorie(Long categorieId, Pageable pageable);
    Produit updateProduit(Long id, Produit produit);
    void deleteProduit(Long id);
}