package ma.zs.stocky.dao.facade.core.attachement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import java.util.List;


@Repository
public interface TypePiecesAttachementDao extends AbstractRepository<TypePiecesAttachement,Long>  {
    TypePiecesAttachement findByReference(String reference);
    int deleteByReference(String reference);


    @Query("SELECT NEW TypePiecesAttachement(item.id,item.libelle) FROM TypePiecesAttachement item")
    List<TypePiecesAttachement> findAllOptimized();

}
