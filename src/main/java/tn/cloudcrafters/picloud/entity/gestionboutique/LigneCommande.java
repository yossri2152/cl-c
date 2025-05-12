package tn.cloudcrafters.picloud.entity.gestionboutique;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LigneCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande commande;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    private Integer quantite;

    public void setId(Long id) {
    }
}