package tn.cloudcrafters.picloud.services.gestionboutique.imageproduit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.cloudcrafters.picloud.entity.gestionboutique.ImageProduit;
import tn.cloudcrafters.picloud.entity.gestionboutique.Produit;
import tn.cloudcrafters.picloud.Repository.gestionboutique.IImageProduitRepository;
import tn.cloudcrafters.picloud.Repository.gestionboutique.IProduitRepository;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageProduitService implements IImageProduitService {

    private final IImageProduitRepository imageProduitRepository;
    private final IProduitRepository produitRepository;

    public ImageProduitService(IImageProduitRepository imageProduitRepository, IProduitRepository produitRepository) {
        this.imageProduitRepository = imageProduitRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public ImageProduit uploadImage(Long produitId, MultipartFile file) throws IOException {
        Produit produit = produitRepository.findById(produitId)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

        ImageProduit image = new ImageProduit();
        image.setNom(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setData(file.getBytes());
        image.setProduit(produit);

        return imageProduitRepository.save(image);
    }

    @Override
    public ImageProduit getImage(Long id) {
        return imageProduitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image non trouvée"));
    }

    @Override
    public void deleteImage(Long id) {
        imageProduitRepository.deleteById(id);
    }
}