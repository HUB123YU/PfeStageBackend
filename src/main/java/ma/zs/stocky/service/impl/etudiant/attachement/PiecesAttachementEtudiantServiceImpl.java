package ma.zs.stocky.service.impl.etudiant.attachement;


import ma.zs.stocky.zynerator.exception.EntityNotFoundException;
import ma.zs.stocky.bean.core.attachement.PiecesAttachement;
import ma.zs.stocky.dao.criteria.core.attachement.PiecesAttachementCriteria;
import ma.zs.stocky.dao.facade.core.attachement.PiecesAttachementDao;
import ma.zs.stocky.dao.specification.core.attachement.PiecesAttachementSpecification;
import ma.zs.stocky.service.facade.etudiant.attachement.PiecesAttachementEtudiantService;
import ma.zs.stocky.zynerator.service.AbstractServiceImpl;
import ma.zs.stocky.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import ma.zs.stocky.zynerator.util.RefelexivityUtil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.stocky.service.facade.etudiant.attachement.TypePiecesAttachementEtudiantService ;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement ;
import ma.zs.stocky.service.facade.etudiant.stage.StageEtudiantService ;
import ma.zs.stocky.bean.core.stage.Stage ;

import java.util.List;
@Service
public class PiecesAttachementEtudiantServiceImpl implements PiecesAttachementEtudiantService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PiecesAttachement update(PiecesAttachement t) {
        PiecesAttachement loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{PiecesAttachement.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public PiecesAttachement findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public PiecesAttachement findOrSave(PiecesAttachement t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            PiecesAttachement result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<PiecesAttachement> importData(List<PiecesAttachement> items) {
        List<PiecesAttachement> list = new ArrayList<>();
        for (PiecesAttachement t : items) {
            PiecesAttachement founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<PiecesAttachement> findAll() {
        return dao.findAll();
    }

    public List<PiecesAttachement> findByCriteria(PiecesAttachementCriteria criteria) {
        List<PiecesAttachement> content = null;
        if (criteria != null) {
            PiecesAttachementSpecification mySpecification = constructSpecification(criteria);
            if (criteria.isPeagable()) {
                Pageable pageable = PageRequest.of(0, criteria.getMaxResults());
                content = dao.findAll(mySpecification, pageable).getContent();
            } else {
                content = dao.findAll(mySpecification);
            }
        } else {
            content = dao.findAll();
        }
        return content;

    }


    private PiecesAttachementSpecification constructSpecification(PiecesAttachementCriteria criteria) {
        PiecesAttachementSpecification mySpecification =  (PiecesAttachementSpecification) RefelexivityUtil.constructObjectUsingOneParam(PiecesAttachementSpecification.class, criteria);
        return mySpecification;
    }

    public List<PiecesAttachement> findPaginatedByCriteria(PiecesAttachementCriteria criteria, int page, int pageSize, String order, String sortField) {
        PiecesAttachementSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(PiecesAttachementCriteria criteria) {
        PiecesAttachementSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<PiecesAttachement> findByTypePiecesAttachementId(Long id){
        return dao.findByTypePiecesAttachementId(id);
    }
    public int deleteByTypePiecesAttachementId(Long id){
        return dao.deleteByTypePiecesAttachementId(id);
    }
    public long countByTypePiecesAttachementReference(String reference){
        return dao.countByTypePiecesAttachementReference(reference);
    }
    public List<PiecesAttachement> findByStageId(Long id){
        return dao.findByStageId(id);
    }
    public int deleteByStageId(Long id){
        return dao.deleteByStageId(id);
    }
    public long countByStageId(Long id){
        return dao.countByStageId(id);
    }

	public boolean deleteById(Long id) {
        boolean condition = deleteByIdCheckCondition(id);
        if (condition) {
            dao.deleteById(id);
        }
        return condition;
    }

    public boolean deleteByIdCheckCondition(Long id) {
        return true;
    }

    public void deleteByIdIn(List<Long> ids) {
        //dao.deleteByIdIn(ids);
    }
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public int delete(PiecesAttachement t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PiecesAttachement> delete(List<PiecesAttachement> list) {
		List<PiecesAttachement> result = new ArrayList();
        if (list != null) {
            for (PiecesAttachement t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public PiecesAttachement create(PiecesAttachement t) {
        PiecesAttachement loaded = findByReferenceEntity(t);
        PiecesAttachement saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PiecesAttachement> create(List<PiecesAttachement> ts) {
        List<PiecesAttachement> result = new ArrayList<>();
        if (ts != null) {
            for (PiecesAttachement t : ts) {
				PiecesAttachement created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public PiecesAttachement findWithAssociatedLists(Long id){
        PiecesAttachement result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<PiecesAttachement> update(List<PiecesAttachement> ts, boolean createIfNotExist) {
        List<PiecesAttachement> result = new ArrayList<>();
        if (ts != null) {
            for (PiecesAttachement t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    PiecesAttachement loadedItem = dao.findById(t.getId()).orElse(null);
                    if (createIfNotExist && (t.getId() == null || loadedItem == null)) {
                        dao.save(t);
                    } else if (t.getId() != null && loadedItem != null) {
                        dao.save(t);
                    } else {
                        result.add(t);
                    }
                }
            }
        }
        return result;
    }





    public PiecesAttachement findByReferenceEntity(PiecesAttachement t) {
        return t == null || t.getId() == null ? null : findById(t.getId());
    }
    public void findOrSaveAssociatedObject(PiecesAttachement t){
        if( t != null) {
            t.setTypePiecesAttachement(typePiecesAttachementService.findOrSave(t.getTypePiecesAttachement()));
            t.setStage(stageService.findOrSave(t.getStage()));
        }
    }



    public List<PiecesAttachement> findAllOptimized() {
        return dao.findAll();
    }

    @Override
    public List<List<PiecesAttachement>> getToBeSavedAndToBeDeleted(List<PiecesAttachement> oldList, List<PiecesAttachement> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<PiecesAttachement> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private TypePiecesAttachementEtudiantService typePiecesAttachementService ;
    @Autowired
    private StageEtudiantService stageService ;

    private @Autowired PiecesAttachementDao dao;


}
