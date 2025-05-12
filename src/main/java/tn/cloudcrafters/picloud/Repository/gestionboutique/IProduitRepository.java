package tn.cloudcrafters.picloud.Repository.gestionboutique;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.cloudcrafters.picloud.entity.gestionboutique.Categorie;
import tn.cloudcrafters.picloud.entity.gestionboutique.Produit;

@Repository
public interface IProduitRepository extends JpaRepository<Produit, Long> {
    Page<Produit> findByCategorie(Categorie categorie, Pageable pageable);
}