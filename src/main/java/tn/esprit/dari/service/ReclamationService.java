package tn.esprit.dari.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.dari.Config.OpenNLP;
import tn.esprit.dari.entities.NotificationEmail;
import tn.esprit.dari.entities.Reclamation;
import tn.esprit.dari.entities.Utilisateur;
import tn.esprit.dari.repositories.ReclamationRepository;
import tn.esprit.dari.repositories.UtilisateurRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamationService implements IReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;
    @Autowired
    private UtilisateurRepository userRepo;
    @Autowired
    private MailService ms;



    @Override
    public Boolean Create(@Valid Reclamation reclamation, Long userid) {


        if(userid!=0 && reclamation!=null ){
           reclamation.setDateTime(LocalDateTime.now());

           reclamation.setState(false);
            Utilisateur user=userRepo.findById((long)userid).get();
            reclamation.setUser(user);
            OpenNLP model=new OpenNLP();
            //PreTrained Recrusive Neural Networl to return the sentimet based on text
            reclamation.setPriority(model.findSentiment(reclamation.getExplication()));
            reclamationRepository.save(reclamation);
            return true;

        }
        return false;

    }

    @Override
    public void Delete(int id) {
        reclamationRepository.deleteById(id);

    }

    @Override
    public boolean treat(int id, String treatement) {
        Reclamation reclamation=reclamationRepository.findById(id).orElse(null);
        if (reclamation != null && !reclamation.getState()) {
            reclamation.setTreatement(treatement);
            reclamation.setState(true);
            reclamationRepository.save(reclamation);

            NotificationEmail notificationEmail=new NotificationEmail("Claim Treated",reclamation.getUser().getEmail(),treatement);

            ms.sendEmail(notificationEmail);

            return true;
        }else{
            return false;
        }
    }

    @Override
    public Reclamation getOne(int id) {
        return reclamationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reclamation> findAll() {
        return reclamationRepository.findAll(Sort.by(Sort.Direction.ASC, "priority").and(Sort.by(Sort.Direction.DESC,"dateTime")));
    }

    @Override
    public List<Reclamation> findNotTreated() {
        return reclamationRepository.findNotTreated().stream().sorted(Comparator.comparing(Reclamation::getPriority)).collect(Collectors.toList());
    }

    @Override
    public List<Reclamation> findMyReclam(int id) {
        return reclamationRepository.findMyReclams((long)id).stream().sorted(Comparator.comparing(Reclamation::getDateTime)).collect(Collectors.toList());
    }

    @Override
    public List<Reclamation> filter(String filter) {
        return reclamationRepository.findByFilter(filter).stream().sorted(Comparator.comparing(Reclamation::getPriority)).collect(Collectors.toList());
    }

    @Override
    public List<Reclamation> findBetweenDate(LocalDateTime start, LocalDateTime end) {
        return reclamationRepository.findBetweenDate(start,end).stream().sorted(Comparator.comparing(Reclamation::getPriority)).collect(Collectors.toList());
    }

    @Override
    public List<Reclamation> findByType(String type) {
        return reclamationRepository.findByType(type).stream().sorted(Comparator.comparing(Reclamation::getPriority)).collect(Collectors.toList());
    }



    public List<Reclamation> searchMultiCriteria(String filter, String type, boolean mine, LocalDateTime start, LocalDateTime end,boolean treated,int id ){
        List<Reclamation> reclamations;

        if(mine){
            reclamations=findMyReclam(id);
        }else{

            reclamations =findAll();
        }

        if(!filter.isEmpty()){
            reclamations=reclamations.stream().filter(x->x.getTitle().toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
        }
        if(!type.isEmpty()){
            reclamations=reclamations.stream().filter(x->x.getType().toLowerCase().contains(type.toLowerCase())).collect(Collectors.toList());
        }

        if(start!=null && end!=null){
            reclamations=reclamations.stream().filter(x->x.getDateTime().isAfter(start) && x.getDateTime().isBefore(end) ).collect(Collectors.toList());
        }
        if(treated){
            reclamations=reclamations.stream().filter(x->x.getState()==true).collect(Collectors.toList());
        }

        return reclamations;



    }
}
