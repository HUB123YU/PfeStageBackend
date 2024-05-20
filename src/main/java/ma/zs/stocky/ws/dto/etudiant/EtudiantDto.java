package  ma.zs.stocky.ws.dto.etudiant;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.stocky.ws.dto.departement.FiliereDto;
import ma.zs.stocky.ws.dto.appartenance.NationaliteDto;
import ma.zs.stocky.ws.dto.appartenance.GenreDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtudiantDto  extends AuditBaseDto {

    private String nom  ;
    private String prenom  ;
    private String email  ;
    private String adresse  ;
    private String telephone  ;
    private String dateNaissance ;
    private String codeAppoge  ;

    private GenreDto genre ;
    private NationaliteDto nationalite ;
    private FiliereDto filiere ;



    public EtudiantDto(){
        super();
    }



    @Log
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }

    @Log
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    @Log
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    @Log
    public String getAdresse(){
        return this.adresse;
    }
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    @Log
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateNaissance(){
        return this.dateNaissance;
    }
    public void setDateNaissance(String dateNaissance){
        this.dateNaissance = dateNaissance;
    }

    @Log
    public String getCodeAppoge(){
        return this.codeAppoge;
    }
    public void setCodeAppoge(String codeAppoge){
        this.codeAppoge = codeAppoge;
    }


    public GenreDto getGenre(){
        return this.genre;
    }

    public void setGenre(GenreDto genre){
        this.genre = genre;
    }
    public NationaliteDto getNationalite(){
        return this.nationalite;
    }

    public void setNationalite(NationaliteDto nationalite){
        this.nationalite = nationalite;
    }
    public FiliereDto getFiliere(){
        return this.filiere;
    }

    public void setFiliere(FiliereDto filiere){
        this.filiere = filiere;
    }






}
