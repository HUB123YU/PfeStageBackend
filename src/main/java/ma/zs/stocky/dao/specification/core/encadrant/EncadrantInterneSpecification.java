package  ma.zs.stocky.dao.specification.core.encadrant;

import ma.zs.stocky.dao.criteria.core.encadrant.EncadrantInterneCriteria;
import ma.zs.stocky.bean.core.encadrant.EncadrantInterne;
import ma.zs.stocky.zynerator.specification.AbstractSpecification;


public class EncadrantInterneSpecification extends  AbstractSpecification<EncadrantInterneCriteria, EncadrantInterne>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("prenom", criteria.getPrenom(),criteria.getPrenomLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("biographie", criteria.getBiographie(),criteria.getBiographieLike());
        addPredicate("telephone", criteria.getTelephone(),criteria.getTelephoneLike());
        addPredicateFk("genre","id", criteria.getGenre()==null?null:criteria.getGenre().getId());
        addPredicateFk("genre","id", criteria.getGenres());
        addPredicateFk("genre","code", criteria.getGenre()==null?null:criteria.getGenre().getCode());
        addPredicateFk("nationalit","id", criteria.getNationalit()==null?null:criteria.getNationalit().getId());
        addPredicateFk("nationalit","id", criteria.getNationalits());
        addPredicateFk("nationalit","code", criteria.getNationalit()==null?null:criteria.getNationalit().getCode());
    }

    public EncadrantInterneSpecification(EncadrantInterneCriteria criteria) {
        super(criteria);
    }

    public EncadrantInterneSpecification(EncadrantInterneCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
