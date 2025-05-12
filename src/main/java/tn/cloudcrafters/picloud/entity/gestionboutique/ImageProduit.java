package tn.cloudcrafters.picloud.entity.gestionboutique;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter // Génère uniquement les getters
@Setter // Génère uniquement les setters
public class ImageProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String type;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    // Ajoutez ces méthodes dans ImageProduit.java
    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }

    public void setNom(String originalFilename) {

    }

    public void setType(String contentType) {
    }

    public void setData(byte[] bytes) {
    }

    public void setProduit(Produit produit) {
    }
}