package  ma.zs.stocky.dao.criteria.core.encadrant;


import ma.zs.stocky.dao.criteria.core.appartenance.NationaliteCriteria;
import ma.zs.stocky.dao.criteria.core.appartenance.GenreCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EncadrantInterneCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String nom;
    private String nomLike;
    private String prenom;
    private String prenomLike;
    private String email;
    private String emailLike;
    private String biographie;
    private String biographieLike;
    private String telephone;
    private String telephoneLike;

    private GenreCriteria genre ;
    private List<GenreCriteria> genres ;
    private NationaliteCriteria nationalit ;
    private List<NationaliteCriteria> nationalits ;


    public EncadrantInterneCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

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

    public String getBiographie(){
        return this.biographie;
    }
    public void setBiographie(String biographie){
        this.biographie = biographie;
    }
    public String getBiographieLike(){
        return this.biographieLike;
    }
    public void setBiographieLike(String biographieLike){
        this.biographieLike = biographieLike;
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
    public NationaliteCriteria getNationalit(){
        return this.nationalit;
    }

    public void setNationalit(NationaliteCriteria nationalit){
        this.nationalit = nationalit;
    }
    public List<NationaliteCriteria> getNationalits(){
        return this.nationalits;
    }

    public void setNationalits(List<NationaliteCriteria> nationalits){
        this.nationalits = nationalits;
    }
}
