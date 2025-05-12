package tn.cloudcrafters.picloud.services.gestionboutique.Categorie;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.cloudcrafters.picloud.entity.gestionboutique.Categorie;
import tn.cloudcrafters.picloud.Repository.gestionboutique.ICategorieRepository;

@Service
@RequiredArgsConstructor
public class CategorieService implements ICategorieService
