package  ma.zs.stocky.dao.criteria.core.etudiant;


import ma.zs.stocky.dao.criteria.core.departement.FiliereCriteria;
import ma.zs.stocky.dao.criteria.core.appartenance.NationaliteCriteria;
import ma.zs.stocky.dao.criteria.core.appartenance.GenreCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class EtudiantCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String email;
    private String emailLike;
    private String adresse;
    private String adresseLike;
    private String telephone;
    private String telephoneLike;
    private LocalDateTime dateNaissance;
    private LocalDateTime dateNaissanceFrom;
    private LocalDateTime dateNaissanceTo;
    private String codeAppoge;
    private String codeAppogeLike;

    private GenreCriteria genre ;
    private List<GenreCriteria> genres ;
    private NationaliteCriteria nationalite ;
    private List<NationaliteCriteria> nationalites ;
    private FiliereCriteria filiere ;
    private List<FiliereCriteria> filieres ;


    public EtudiantCriteria(){}

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNomLike(){
        return this.nomLike;
    }
    public void setNomLike(String nomLike){
        this.nomLike = nomLike;
    }

    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getPrenomLike(){
        return this.prenomLike;
    }
    public void setPrenomLike(String prenomLike){
        this.prenomLike = prenomLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    public String getAdresseLike(){
        return this.adresseLike;
    }
    public void setAdresseLike(String adresseLike){
        this.adresseLike = adresseLike;
    }

    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    public String getTelephoneLike(){
        return this.telephoneLike;
    }
    public void setTelephoneLike(String telephoneLike){
        this.telephoneLike = telephoneLike;
    }

    public LocalDateTime getDateNaissance(){
        return this.dateNaissance;
    }
    public void setDateNaissance(LocalDateTime dateNaissance){
        this.dateNaissance = dateNaissance;
    }
    public LocalDateTime getDateNaissanceFrom(){
        return this.dateNaissanceFrom;
    }
    public void setDateNaissanceFrom(LocalDateTime dateNaissanceFrom){
        this.dateNaissanceFrom = dateNaissanceFrom;
    }
    public LocalDateTime getDateNaissanceTo(){
        return this.dateNaissanceTo;
    }
    public void setDateNaissanceTo(LocalDateTime dateNaissanceTo){
        this.dateNaissanceTo = dateNaissanceTo;
    }
    public String getCodeAppoge(){
        return this.codeAppoge;
    }
    public void setCodeAppoge(String codeAppoge){
        this.codeAppoge = codeAppoge;
    }
    public String getCodeAppogeLike(){
        return this.codeAppogeLike;
    }
    public void setCodeAppogeLike(String codeAppogeLike){
        this.codeAppogeLike = codeAppogeLike;
    }


    public GenreCriteria getGenre(){
        return this.genre;
    }

    public void setGenre(GenreCriteria genre){
        this.genre = genre;
    }
    public List<GenreCriteria> getGenres(){
        return this.genres;
    }

    public void setGenres(List<GenreCriteria> genres){
        this.genres = genres;
    }
    public NationaliteCriteria getNationalite(){
        return this.nationalite;
    }

    public void setNationalite(NationaliteCriteria nationalite){
        this.nationalite = nationalite;
    }
    public List<NationaliteCriteria> getNationalites(){
        return this.nationalites;
    }

    public void setNationalites(List<NationaliteCriteria> nationalites){
        this.nationalites = nationalites;
    }
    public FiliereCriteria getFiliere(){
        return this.filiere;
    }

    public void setFiliere(FiliereCriteria filiere){
        this.filiere = filiere;
    }
    public List<FiliereCriteria> getFilieres(){
        return this.filieres;
    }

    public void setFilieres(List<FiliereCriteria> filieres){
        this.filieres = filieres;
    }
}
