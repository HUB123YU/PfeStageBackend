package ma.zs.stocky.service.facade.admin.attachement;

import java.util.List;
import ma.zs.stocky.bean.core.attachement.PiecesAttachement;
import ma.zs.stocky.dao.criteria.core.attachement.PiecesAttachementCriteria;
import ma.zs.stocky.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface PiecesAttachementAdminService {



    List<PiecesAttachement> findByTypePiecesAttachementId(Long id);
    int deleteByTypePiecesAttachementId(Long id);
    long countByTypePiecesAttachementReference(String reference);
    List<PiecesAttachement> findByStageId(Long id);
    int deleteByStageId(Long id);
    long countByStageId(Long id);




	PiecesAttachement create(PiecesAttachement t);

    PiecesAttachement update(PiecesAttachement t);

    List<PiecesAttachement> update(List<PiecesAttachement> ts,boolean createIfNotExist);

    PiecesAttachement findById(Long id);

    PiecesAttachement findOrSave(PiecesAttachement t);

    PiecesAttachement findByReferenceEntity(PiecesAttachement t);

    PiecesAttachement findWithAssociatedLists(Long id);

    List<PiecesAttachement> findAllOptimized();

    List<PiecesAttachement> findAll();

    List<PiecesAttachement> findByCriteria(PiecesAttachementCriteria criteria);

    List<PiecesAttachement> findPaginatedByCriteria(PiecesAttachementCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(PiecesAttachementCriteria criteria);

    List<PiecesAttachement> delete(List<PiecesAttachement> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<PiecesAttachement>> getToBeSavedAndToBeDeleted(List<PiecesAttachement> oldList, List<PiecesAttachement> newList);

    List<PiecesAttachement> importData(List<PiecesAttachement> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<PiecesAttachement> importExcel(MultipartFile file);

}
