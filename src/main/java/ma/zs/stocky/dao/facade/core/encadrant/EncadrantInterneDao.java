package ma.zs.stocky.dao.facade.core.encadrant;

import org.springframework.data.jpa.repository.Query;
import ma.zs.stocky.zynerator.repository.AbstractRepository;
import ma.zs.stocky.bean.core.encadrant.EncadrantInterne;
import org.springframework.stereotype.Repository;
import ma.zs.stocky.bean.core.encadrant.EncadrantInterne;
import java.util.List;


@Repository
public interface EncadrantInterneDao extends AbstractRepository<EncadrantInterne,Long>  {
    EncadrantInterne findByCode(String code);
    int deleteByCode(String code);

    List<EncadrantInterne> findByGenreId(Long id);
    int deleteByGenreId(Long id);
    long countByGenreCode(String code);
    List<EncadrantInterne> findByNationalitId(Long id);
    int deleteByNationalitId(Long id);
    long countByNationalitCode(String code);

    @Query("SELECT NEW EncadrantInterne(item.id,item.code) FROM EncadrantInterne item")
    List<EncadrantInterne> findAllOptimized();

}
