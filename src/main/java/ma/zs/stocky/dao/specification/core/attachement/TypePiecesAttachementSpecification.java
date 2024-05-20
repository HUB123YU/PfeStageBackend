package  ma.zs.stocky.dao.specification.core.attachement;

import ma.zs.stocky.dao.criteria.core.attachement.TypePiecesAttachementCriteria;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class TypePiecesAttachementSpecification extends  AbstractSpecification<TypePiecesAttachementCriteria, TypePiecesAttachement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public TypePiecesAttachementSpecification(TypePiecesAttachementCriteria criteria) {
        super(criteria);
    }

    public TypePiecesAttachementSpecification(TypePiecesAttachementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
