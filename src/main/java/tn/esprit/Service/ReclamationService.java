package tn.esprit.Service;


import org.springframework.stereotype.Service;
import tn.esprit.entities.Reclamation;

import java.util.List;

@Service
public class ReclamationService implements IReclamationService {
    @Override
    public void Create(Reclamation reclamation) {

    }

    @Override
    public void Delete(int id) {

    }

    @Override
    public void treat(int id, String treatement) {

    }

    @Override
    public Reclamation getOne(int id) {
        return null;
    }

    @Override
    public List<Reclamation> findAll() {
        return null;
    }
}
