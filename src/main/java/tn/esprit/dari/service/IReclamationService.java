package tn.esprit.dari.service;

import tn.esprit.dari.entities.Reclamation;

import java.time.LocalDateTime;
import java.util.List;

public interface IReclamationService {

    public Boolean Create(Reclamation reclamation,Long userId);
    public void Delete(int id);
    public boolean treat(int id, String treatement);
    public Reclamation getOne(int id);
    public List<Reclamation> findAll();
    public List<Reclamation> findNotTreated();
    public List<Reclamation> findMyReclam(int id);
    public List<Reclamation> filter(String filter);
    public List<Reclamation> findBetweenDate(LocalDateTime start,LocalDateTime end);
    public List<Reclamation> findByType(String type);
    public List<Reclamation> searchMultiCriteria(String filter, String type, boolean mine, LocalDateTime start, LocalDateTime end,boolean treated,int id );
}
