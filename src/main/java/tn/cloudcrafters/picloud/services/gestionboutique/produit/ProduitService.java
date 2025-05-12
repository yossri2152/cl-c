package tn.cloudcrafters.picloud.services.gestionboutique.produit;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.cloudcrafters.picloud.entity.gestionboutique.Categorie;
import tn.cloudcrafters.picloud.entity.gestionboutique.Produit;
import tn.cloudcrafters.picloud.Repository.gestionboutique.ICategorieRepository;
import tn.cloudcrafters.picloud.Repository.gestionboutique.IProduitRepository;
import tn.cloudcrafters.picloud.services.gestionboutique.imageproduit.IImageProduitService;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProduitService implements IProduitService {

    private final IProduitRepository produitRepository;
    private final ICategorieRepository categorieRepository;
    private final IImageProduitService imageProduitService;

    public ProduitService(IProduitRepository produitRepository, ICategorieRepository categorieRepository, IImageProduitService imageProduitService) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
        this.imageProduitService = imageProduitService;
    }

    @Override
    public Produit createProduit(Produit produit, MultipartFile image) throws IOException {
        if (image != null && !image.isEmpty()) {
            Produit savedProduit = produitRepository.save(produit);
            imageProduitService.uploadImage(savedProduit.getId(), image);
            return savedProduit;
        }
        return produitRepository.save(produit);
    }

    @Override
    public Page<Produit> getAllProduits(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    @Override
    public Produit getProduitById(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    @Override
    public Page<Produit> getProduitsByCategorie(Long categorieId, Pageable pageable) {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
        return produitRepository.findByCategorie(categorie, pageable);
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        produit.setId(id);
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }
}