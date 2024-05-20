package ma.zs.stocky.service.facade.admin.stage;

import java.util.List;
import ma.zs.stocky.bean.core.stage.StagePiecesAttachement;
import ma.zs.stocky.dao.criteria.core.stage.StagePiecesAttachementCriteria;
import ma.zs.stocky.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface StagePiecesAttachementAdminService {



    List<StagePiecesAttachement> findByStageId(Long id);
    int deleteByStageId(Long id);
    long countByStageId(Long id);
    List<StagePiecesAttachement> findByPiecesAttachementId(Long id);
    int deleteByPiecesAttachementId(Long id);
    long countByPiecesAttachementId(Long id);




	StagePiecesAttachement create(StagePiecesAttachement t);

    StagePiecesAttachement update(StagePiecesAttachement t);

    List<StagePiecesAttachement> update(List<StagePiecesAttachement> ts,boolean createIfNotExist);

    StagePiecesAttachement findById(Long id);

    StagePiecesAttachement findOrSave(StagePiecesAttachement t);

    StagePiecesAttachement findByReferenceEntity(StagePiecesAttachement t);

    StagePiecesAttachement findWithAssociatedLists(Long id);

    List<StagePiecesAttachement> findAllOptimized();

    List<StagePiecesAttachement> findAll();

    List<StagePiecesAttachement> findByCriteria(StagePiecesAttachementCriteria criteria);

    List<StagePiecesAttachement> findPaginatedByCriteria(StagePiecesAttachementCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(StagePiecesAttachementCriteria criteria);

    List<StagePiecesAttachement> delete(List<StagePiecesAttachement> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<StagePiecesAttachement>> getToBeSavedAndToBeDeleted(List<StagePiecesAttachement> oldList, List<StagePiecesAttachement> newList);

    List<StagePiecesAttachement> importData(List<StagePiecesAttachement> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<StagePiecesAttachement> importExcel(MultipartFile file);

}
