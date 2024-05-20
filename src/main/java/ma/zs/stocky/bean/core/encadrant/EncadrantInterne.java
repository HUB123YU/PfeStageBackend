package ma.zs.stocky.bean.core.encadrant;

import java.util.Objects;





import ma.zs.stocky.bean.core.appartenance.Nationalite;
import ma.zs.stocky.bean.core.appartenance.Genre;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "encadrant_interne")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="encadrant_interne_seq",sequenceName="encadrant_interne_seq",allocationSize=1, initialValue = 1)
public class EncadrantInterne  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String code;

    @Column(length = 500)
    private String nom;

    @Column(length = 500)
    private String prenom;

    @Column(length = 500)
    private String email;

    @Column(length = 500)
    private String biographie;

    @Column(length = 500)
    private String telephone;

    private Genre genre ;
    private Nationalite nationalit ;


    public EncadrantInterne(){
        super();
    }

    public EncadrantInterne(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public EncadrantInterne(String code){
        this.code = code ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="encadrant_interne_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getBiographie(){
        return this.biographie;
    }
    public void setBiographie(String biographie){
        this.biographie = biographie;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String telephone){
        this.telephone = telephone;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre")
    public Genre getGenre(){
        return this.genre;
    }
    public void setGenre(Genre genre){
        this.genre = genre;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nationalit")
    public Nationalite getNationalit(){
        return this.nationalit;
    }
    public void setNationalit(Nationalite nationalit){
        this.nationalit = nationalit;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncadrantInterne encadrantInterne = (EncadrantInterne) o;
        return id != null && id.equals(encadrantInterne.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

