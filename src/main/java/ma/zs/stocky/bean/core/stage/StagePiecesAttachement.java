package ma.zs.stocky.bean.core.stage;

import java.util.Objects;





import ma.zs.stocky.bean.core.attachement.PiecesAttachement;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.stocky.zynerator.bean.BaseEntity;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stage_pieces_attachement")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="stage_pieces_attachement_seq",sequenceName="stage_pieces_attachement_seq",allocationSize=1, initialValue = 1)
public class StagePiecesAttachement  extends BaseEntity     {

    private Long id;



    private Stage stage ;
    private PiecesAttachement piecesAttachement ;


    public StagePiecesAttachement(){
        super();
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.SEQUENCE,generator="stage_pieces_attachement_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stage")
    public Stage getStage(){
        return this.stage;
    }
    public void setStage(Stage stage){
        this.stage = stage;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pieces_attachement")
    public PiecesAttachement getPiecesAttachement(){
        return this.piecesAttachement;
    }
    public void setPiecesAttachement(PiecesAttachement piecesAttachement){
        this.piecesAttachement = piecesAttachement;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StagePiecesAttachement stagePiecesAttachement = (StagePiecesAttachement) o;
        return id != null && id.equals(stagePiecesAttachement.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

