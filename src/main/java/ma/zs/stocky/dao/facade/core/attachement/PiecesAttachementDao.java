package ma.zs.stocky.dao.facade.core.attachement;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.attachement.PiecesAttachement;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PiecesAttachementDao extends AbstractRepository<PiecesAttachement,Long>  {

    List<PiecesAttachement> findByTypePiecesAttachementId(Long id);
    int deleteByTypePiecesAttachementId(Long id);
    long countByTypePiecesAttachementReference(String reference);
    List<PiecesAttachement> findByStageId(Long id);
    int deleteByStageId(Long id);
    long countByStageId(Long id);


}
