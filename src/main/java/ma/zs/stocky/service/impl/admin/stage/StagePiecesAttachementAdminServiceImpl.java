package ma.zs.stocky.service.impl.admin.stage;


import ma.zs.stocky.zynerator.exception.EntityNotFoundException;
import ma.zs.stocky.bean.core.stage.StagePiecesAttachement;
import ma.zs.stocky.dao.criteria.core.stage.StagePiecesAttachementCriteria;
import ma.zs.stocky.dao.facade.core.stage.StagePiecesAttachementDao;
import ma.zs.stocky.dao.specification.core.stage.StagePiecesAttachementSpecification;
import ma.zs.stocky.service.facade.admin.stage.StagePiecesAttachementAdminService;
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

import ma.zs.stocky.service.facade.admin.attachement.PiecesAttachementAdminService ;
import ma.zs.stocky.bean.core.attachement.PiecesAttachement ;
import ma.zs.stocky.service.facade.admin.stage.StageAdminService ;
import ma.zs.stocky.bean.core.stage.Stage ;

import java.util.List;
@Service
public class StagePiecesAttachementAdminServiceImpl implements StagePiecesAttachementAdminService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public StagePiecesAttachement update(StagePiecesAttachement t) {
        StagePiecesAttachement loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{StagePiecesAttachement.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public StagePiecesAttachement findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public StagePiecesAttachement findOrSave(StagePiecesAttachement t) {
        if (t != null) {
            findOrSaveAssociatedObject(t);
            StagePiecesAttachement result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<StagePiecesAttachement> importData(List<StagePiecesAttachement> items) {
        List<StagePiecesAttachement> list = new ArrayList<>();
        for (StagePiecesAttachement t : items) {
            StagePiecesAttachement founded = findByReferenceEntity(t);
			if (founded == null) {
				findOrSaveAssociatedObject(t);
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<StagePiecesAttachement> findAll() {
        return dao.findAll();
    }

    public List<StagePiecesAttachement> findByCriteria(StagePiecesAttachementCriteria criteria) {
        List<StagePiecesAttachement> content = null;
        if (criteria != null) {
            StagePiecesAttachementSpecification mySpecification = constructSpecification(criteria);
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


    private StagePiecesAttachementSpecification constructSpecification(StagePiecesAttachementCriteria criteria) {
        StagePiecesAttachementSpecification mySpecification =  (StagePiecesAttachementSpecification) RefelexivityUtil.constructObjectUsingOneParam(StagePiecesAttachementSpecification.class, criteria);
        return mySpecification;
    }

    public List<StagePiecesAttachement> findPaginatedByCriteria(StagePiecesAttachementCriteria criteria, int page, int pageSize, String order, String sortField) {
        StagePiecesAttachementSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(StagePiecesAttachementCriteria criteria) {
        StagePiecesAttachementSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
    }

    public List<StagePiecesAttachement> findByStageId(Long id){
        return dao.findByStageId(id);
    }
    public int deleteByStageId(Long id){
        return dao.deleteByStageId(id);
    }
    public long countByStageId(Long id){
        return dao.countByStageId(id);
    }
    public List<StagePiecesAttachement> findByPiecesAttachementId(Long id){
        return dao.findByPiecesAttachementId(id);
    }
    public int deleteByPiecesAttachementId(Long id){
        return dao.deleteByPiecesAttachementId(id);
    }
    public long countByPiecesAttachementId(Long id){
        return dao.countByPiecesAttachementId(id);
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
    public int delete(StagePiecesAttachement t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<StagePiecesAttachement> delete(List<StagePiecesAttachement> list) {
		List<StagePiecesAttachement> result = new ArrayList();
        if (list != null) {
            for (StagePiecesAttachement t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public StagePiecesAttachement create(StagePiecesAttachement t) {
        StagePiecesAttachement loaded = findByReferenceEntity(t);
        StagePiecesAttachement saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<StagePiecesAttachement> create(List<StagePiecesAttachement> ts) {
        List<StagePiecesAttachement> result = new ArrayList<>();
        if (ts != null) {
            for (StagePiecesAttachement t : ts) {
				StagePiecesAttachement created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public StagePiecesAttachement findWithAssociatedLists(Long id){
        StagePiecesAttachement result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<StagePiecesAttachement> update(List<StagePiecesAttachement> ts, boolean createIfNotExist) {
        List<StagePiecesAttachement> result = new ArrayList<>();
        if (ts != null) {
            for (StagePiecesAttachement t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    StagePiecesAttachement loadedItem = dao.findById(t.getId()).orElse(null);
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





    public StagePiecesAttachement findByReferenceEntity(StagePiecesAttachement t) {
        return t == null || t.getId() == null ? null : findById(t.getId());
    }
    public void findOrSaveAssociatedObject(StagePiecesAttachement t){
        if( t != null) {
            t.setStage(stageService.findOrSave(t.getStage()));
            t.setPiecesAttachement(piecesAttachementService.findOrSave(t.getPiecesAttachement()));
        }
    }



    public List<StagePiecesAttachement> findAllOptimized() {
        return dao.findAll();
    }

    @Override
    public List<List<StagePiecesAttachement>> getToBeSavedAndToBeDeleted(List<StagePiecesAttachement> oldList, List<StagePiecesAttachement> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<StagePiecesAttachement> importExcel(MultipartFile file) {
        return null;
    }








    @Autowired
    private PiecesAttachementAdminService piecesAttachementService ;
    @Autowired
    private StageAdminService stageService ;

    private @Autowired StagePiecesAttachementDao dao;


}
