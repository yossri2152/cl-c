package tn.cloudcrafters.picloud.services.gestionboutique.imageproduit;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import tn.cloudcrafters.picloud.entity.gestionboutique.ImageProduit;

public interface IImageProduitService {
    ImageProduit uploadImage(Long produitId, MultipartFile file) throws IOException;
    ImageProduit getImage(Long id);
    void deleteImage(Long id);
}