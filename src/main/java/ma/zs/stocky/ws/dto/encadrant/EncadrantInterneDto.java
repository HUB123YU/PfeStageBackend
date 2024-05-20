package  ma.zs.stocky.ws.dto.encadrant;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.stocky.ws.dto.appartenance.NationaliteDto;
import ma.zs.stocky.ws.dto.appartenance.GenreDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EncadrantInterneDto  extends AuditBaseDto {

    private String code  ;
    private String nom  ;
    private String prenom  ;
    private String email  ;
    private String biographie  ;
    private String telephone  ;

    private GenreDto genre ;
    private NationaliteDto nationalit ;



    public EncadrantInterneDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
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
    public String getBiographie(){
        return this.biographie;
    }
    public void setBiographie(String biographie){
        this.biographie = biographie;
    }

    @Log
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }


    public GenreDto getGenre(){
        return this.genre;
    }

    public void setGenre(GenreDto genre){
        this.genre = genre;
    }
    public NationaliteDto getNationalit(){
        return this.nationalit;
    }

    public void setNationalit(NationaliteDto nationalit){
        this.nationalit = nationalit;
    }






}
