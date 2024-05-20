package  ma.zs.stocky.dao.criteria.core.stage;


import ma.zs.stocky.dao.criteria.core.attachement.PiecesAttachementCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class StagePiecesAttachementCriteria extends  BaseCriteria  {


    private StageCriteria stage ;
    private List<StageCriteria> stages ;
    private PiecesAttachementCriteria piecesAttachement ;
    private List<PiecesAttachementCriteria> piecesAttachements ;


    public StagePiecesAttachementCriteria(){}


    public StageCriteria getStage(){
        return this.stage;
    }

    public void setStage(StageCriteria stage){
        this.stage = stage;
    }
    public List<StageCriteria> getStages(){
        return this.stages;
    }

    public void setStages(List<StageCriteria> stages){
        this.stages = stages;
    }
    public PiecesAttachementCriteria getPiecesAttachement(){
        return this.piecesAttachement;
    }

    public void setPiecesAttachement(PiecesAttachementCriteria piecesAttachement){
        this.piecesAttachement = piecesAttachement;
    }
    public List<PiecesAttachementCriteria> getPiecesAttachements(){
        return this.piecesAttachements;
    }

    public void setPiecesAttachements(List<PiecesAttachementCriteria> piecesAttachements){
        this.piecesAttachements = piecesAttachements;
    }
}
