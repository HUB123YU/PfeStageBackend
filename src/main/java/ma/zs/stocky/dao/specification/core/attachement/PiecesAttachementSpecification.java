package  ma.zs.stocky.dao.specification.core.attachement;

import ma.zs.stocky.dao.criteria.core.attachement.PiecesAttachementCriteria;
import ma.zs.stocky.bean.core.attachement.PiecesAttachement;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class PiecesAttachementSpecification extends  AbstractSpecification<PiecesAttachementCriteria, PiecesAttachement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("contenu", criteria.getContenu(),criteria.getContenuLike());
        addPredicateBigDecimal("taille", criteria.getTaille(), criteria.getTailleMin(), criteria.getTailleMax());
        addPredicateFk("typePiecesAttachement","id", criteria.getTypePiecesAttachement()==null?null:criteria.getTypePiecesAttachement().getId());
        addPredicateFk("typePiecesAttachement","id", criteria.getTypePiecesAttachements());
        addPredicateFk("typePiecesAttachement","reference", criteria.getTypePiecesAttachement()==null?null:criteria.getTypePiecesAttachement().getReference());
        addPredicateFk("stage","id", criteria.getStage()==null?null:criteria.getStage().getId());
        addPredicateFk("stage","id", criteria.getStages());
    }

    public PiecesAttachementSpecification(PiecesAttachementCriteria criteria) {
        super(criteria);
    }

    public PiecesAttachementSpecification(PiecesAttachementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
