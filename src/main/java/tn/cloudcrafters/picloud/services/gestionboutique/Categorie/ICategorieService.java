package tn.cloudcrafters.picloud.services.gestionboutique.Categorie;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tn.cloudcrafters.picloud.entity.gestionboutique.Categorie;

public interface ICategorieService {
    Categorie createCategorie(Categorie categorie);
    Page<Categorie> getAllCategories(Pageable pageable);
    Categorie getCategorieById(Long id);
    Categorie updateCategorie(Long id, Categorie categorie);
    void deleteCategorie(Long id);
}