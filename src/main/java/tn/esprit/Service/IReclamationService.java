package tn.esprit.Service;

import tn.esprit.entities.Reclamation;

import java.util.List;

public interface IReclamationService {

    public void Create(Reclamation reclamation);
    public void Delete(int id);
    public void treat(int id, String treatement);
    public Reclamation getOne(int id);
    public List<Reclamation> findAll();
}
