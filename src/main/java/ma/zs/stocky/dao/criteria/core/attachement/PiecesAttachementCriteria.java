package  ma.zs.stocky.dao.criteria.core.attachement;


import ma.zs.stocky.dao.criteria.core.stage.StageCriteria;

import ma.zs.stocky.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PiecesAttachementCriteria extends  BaseCriteria  {

    private String nom;
    private String nomLike;
    private String contenu;
    private String contenuLike;
    private String taille;
    private String tailleMin;
    private String tailleMax;

    private TypePiecesAttachementCriteria typePiecesAttachement ;
    private List<TypePiecesAttachementCriteria> typePiecesAttachements ;
    private StageCriteria stage ;
    private List<StageCriteria> stages ;


    public PiecesAttachementCriteria(){}

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

    public String getContenu(){
        return this.contenu;
    }
    public void setContenu(String contenu){
        this.contenu = contenu;
    }
    public String getContenuLike(){
        return this.contenuLike;
    }
    public void setContenuLike(String contenuLike){
        this.contenuLike = contenuLike;
    }

    public String getTaille(){
        return this.taille;
    }
    public void setTaille(String taille){
        this.taille = taille;
    }   
    public String getTailleMin(){
        return this.tailleMin;
    }
    public void setTailleMin(String tailleMin){
        this.tailleMin = tailleMin;
    }
    public String getTailleMax(){
        return this.tailleMax;
    }
    public void setTailleMax(String tailleMax){
        this.tailleMax = tailleMax;
    }
      

    public TypePiecesAttachementCriteria getTypePiecesAttachement(){
        return this.typePiecesAttachement;
    }

    public void setTypePiecesAttachement(TypePiecesAttachementCriteria typePiecesAttachement){
        this.typePiecesAttachement = typePiecesAttachement;
    }
    public List<TypePiecesAttachementCriteria> getTypePiecesAttachements(){
        return this.typePiecesAttachements;
    }

    public void setTypePiecesAttachements(List<TypePiecesAttachementCriteria> typePiecesAttachements){
        this.typePiecesAttachements = typePiecesAttachements;
    }
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
}
