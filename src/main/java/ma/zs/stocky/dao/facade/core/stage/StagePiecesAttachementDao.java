package ma.zs.stocky.dao.facade.core.stage;

import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.stage.StagePiecesAttachement;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface StagePiecesAttachementDao extends AbstractRepository<StagePiecesAttachement,Long>  {

    List<StagePiecesAttachement> findByStageId(Long id);
    int deleteByStageId(Long id);
    long countByStageId(Long id);
    List<StagePiecesAttachement> findByPiecesAttachementId(Long id);
    int deleteByPiecesAttachementId(Long id);
    long countByPiecesAttachementId(Long id);


}
