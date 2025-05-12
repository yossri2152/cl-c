package tn.cloudcrafters.picloud.Repository.gestionboutique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.cloudcrafters.picloud.entity.gestionboutique.LigneCommande;

@Repository
public interface ILigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
}