package ma.zs.stocky.bean.core.attachement;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_pieces_attachement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="type_pieces_attachement_seq",sequenceName="type_pieces_attachement_seq",allocationSize=1, initialValue = 1)
public class TypePiecesAttachement  extends BaseEntity     {

    private Long id;



    @Column(length = 500)
    private String reference;

    @Column(length = 500)
    private String libelle;



    public TypePiecesAttachement(){
        super();
    }

    public TypePiecesAttachement(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypePiecesAttachement(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="type_pieces_attachement_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypePiecesAttachement typePiecesAttachement = (TypePiecesAttachement) o;
        return id != null && id.equals(typePiecesAttachement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

