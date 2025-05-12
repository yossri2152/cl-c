package tn.cloudcrafters.picloud.Repository.gestionboutique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.cloudcrafters.picloud.entity.gestionboutique.Categorie;

public interface ICategorieRepository extends JpaRepository<Categorie, Long> {
    // Méthodes de pagination déjà incluses dans JpaRepository
}