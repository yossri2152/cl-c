package tn.cloudcrafters.picloud.Repository.gestionboutique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.cloudcrafters.picloud.entity.gestionboutique.ImageProduit;

@Repository
public interface IImageProduitRepository extends JpaRepository<ImageProduit, Long> {
}