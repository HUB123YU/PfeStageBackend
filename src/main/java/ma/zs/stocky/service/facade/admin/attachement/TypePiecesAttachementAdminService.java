package ma.zs.stocky.service.facade.admin.attachement;

import java.util.List;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import ma.zs.stocky.dao.criteria.core.attachement.TypePiecesAttachementCriteria;
import ma.zs.stocky.zynerator.service.IService;


import org.springframework.web.multipart.MultipartFile;

public interface TypePiecesAttachementAdminService {







	TypePiecesAttachement create(TypePiecesAttachement t);

    TypePiecesAttachement update(TypePiecesAttachement t);

    List<TypePiecesAttachement> update(List<TypePiecesAttachement> ts,boolean createIfNotExist);

    TypePiecesAttachement findById(Long id);

    TypePiecesAttachement findOrSave(TypePiecesAttachement t);

    TypePiecesAttachement findByReferenceEntity(TypePiecesAttachement t);

    TypePiecesAttachement findWithAssociatedLists(Long id);

    List<TypePiecesAttachement> findAllOptimized();

    List<TypePiecesAttachement> findAll();

    List<TypePiecesAttachement> findByCriteria(TypePiecesAttachementCriteria criteria);

    List<TypePiecesAttachement> findPaginatedByCriteria(TypePiecesAttachementCriteria criteria, int page, int pageSize, String order, String sortField);

    int getDataSize(TypePiecesAttachementCriteria criteria);

    List<TypePiecesAttachement> delete(List<TypePiecesAttachement> ts);

    void deleteByIdIn(List<Long> ids);

    boolean deleteById(Long id);

    List<List<TypePiecesAttachement>> getToBeSavedAndToBeDeleted(List<TypePiecesAttachement> oldList, List<TypePiecesAttachement> newList);

    List<TypePiecesAttachement> importData(List<TypePiecesAttachement> items);

    public String uploadFile(String checksumOld, String tempUpladedFile,String destinationFilePath) throws Exception ;

    List<TypePiecesAttachement> importExcel(MultipartFile file);

}
