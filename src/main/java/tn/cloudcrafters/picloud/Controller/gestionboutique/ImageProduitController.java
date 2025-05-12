package tn.cloudcrafters.picloud.Controller.gestionboutique;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.cloudcrafters.picloud.entity.gestionboutique.ImageProduit;
import tn.cloudcrafters.picloud.services.gestionboutique.imageproduit.IImageProduitService;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageProduitController {

    private final IImageProduitService imageProduitService;

    public ImageProduitController(IImageProduitService imageProduitService) {
        this.imageProduitService = imageProduitService;
    }

    @PostMapping("/upload/{produitId}")
    public ResponseEntity<ImageProduit> uploadImage(
            @PathVariable Long produitId,
            @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(imageProduitService.uploadImage(produitId, file));
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        ImageProduit image = imageProduitService.getImage(id);
        return ResponseEntity.ok()
                .contentType(org.springframework.http.MediaType.parseMediaType(image.getType()))
                .body(image.getData());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageProduitService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}