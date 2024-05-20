package  ma.zs.stocky.ws.dto.stage;

import ma.zs.stocky.zynerator.audit.Log;
import ma.zs.stocky.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.stocky.ws.dto.attachement.PiecesAttachementDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class StagePiecesAttachementDto  extends AuditBaseDto {


    private StageDto stage ;
    private PiecesAttachementDto piecesAttachement ;



    public StagePiecesAttachementDto(){
        super();
    }




    public StageDto getStage(){
        return this.stage;
    }

    public void setStage(StageDto stage){
        this.stage = stage;
    }
    public PiecesAttachementDto getPiecesAttachement(){
        return this.piecesAttachement;
    }

    public void setPiecesAttachement(PiecesAttachementDto piecesAttachement){
        this.piecesAttachement = piecesAttachement;
    }






}
