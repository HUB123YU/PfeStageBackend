package  ma.zs.stocky.dao.specification.core.stage;

import ma.zs.stocky.dao.criteria.core.stage.StagePiecesAttachementCriteria;
import ma.zs.stocky.bean.core.stage.StagePiecesAttachement;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class StagePiecesAttachementSpecification extends  AbstractSpecification<StagePiecesAttachementCriteria, StagePiecesAttachement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("stage","id", criteria.getStage()==null?null:criteria.getStage().getId());
        addPredicateFk("stage","id", criteria.getStages());
        addPredicateFk("piecesAttachement","id", criteria.getPiecesAttachement()==null?null:criteria.getPiecesAttachement().getId());
        addPredicateFk("piecesAttachement","id", criteria.getPiecesAttachements());
    }

    public StagePiecesAttachementSpecification(StagePiecesAttachementCriteria criteria) {
        super(criteria);
    }

    public StagePiecesAttachementSpecification(StagePiecesAttachementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
