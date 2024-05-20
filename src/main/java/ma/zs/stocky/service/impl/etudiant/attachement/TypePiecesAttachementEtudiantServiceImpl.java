package ma.zs.stocky.service.impl.etudiant.attachement;


import ma.zs.stocky.zynerator.exception.EntityNotFoundException;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import ma.zs.stocky.dao.criteria.core.attachement.TypePiecesAttachementCriteria;
import ma.zs.stocky.dao.facade.core.attachement.TypePiecesAttachementDao;
import ma.zs.stocky.dao.specification.core.attachement.TypePiecesAttachementSpecification;
import ma.zs.stocky.service.facade.etudiant.attachement.TypePiecesAttachementEtudiantService;
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


import java.util.List;
@Service
public class TypePiecesAttachementEtudiantServiceImpl implements TypePiecesAttachementEtudiantService {


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypePiecesAttachement update(TypePiecesAttachement t) {
        TypePiecesAttachement loadedItem = dao.findById(t.getId()).orElse(null);
        if (loadedItem == null) {
            throw new EntityNotFoundException("errors.notFound", new String[]{TypePiecesAttachement.class.getSimpleName(), t.getId().toString()});
        } else {
            dao.save(t);
            return loadedItem;
        }
    }

    public TypePiecesAttachement findById(Long id) {
        return dao.findById(id).orElse(null);
    }


    public TypePiecesAttachement findOrSave(TypePiecesAttachement t) {
        if (t != null) {
            TypePiecesAttachement result = findByReferenceEntity(t);
            if (result == null) {
                return create(t);
            } else {
                return result;
            }
        }
        return null;
    }


    public List<TypePiecesAttachement> importData(List<TypePiecesAttachement> items) {
        List<TypePiecesAttachement> list = new ArrayList<>();
        for (TypePiecesAttachement t : items) {
            TypePiecesAttachement founded = findByReferenceEntity(t);
			if (founded == null) {
				dao.save(t);
			} else {
				list.add(founded);
			}
        }
        return list;
    }

    public List<TypePiecesAttachement> findAll() {
        return dao.findAll();
    }

    public List<TypePiecesAttachement> findByCriteria(TypePiecesAttachementCriteria criteria) {
        List<TypePiecesAttachement> content = null;
        if (criteria != null) {
            TypePiecesAttachementSpecification mySpecification = constructSpecification(criteria);
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


    private TypePiecesAttachementSpecification constructSpecification(TypePiecesAttachementCriteria criteria) {
        TypePiecesAttachementSpecification mySpecification =  (TypePiecesAttachementSpecification) RefelexivityUtil.constructObjectUsingOneParam(TypePiecesAttachementSpecification.class, criteria);
        return mySpecification;
    }

    public List<TypePiecesAttachement> findPaginatedByCriteria(TypePiecesAttachementCriteria criteria, int page, int pageSize, String order, String sortField) {
        TypePiecesAttachementSpecification mySpecification = constructSpecification(criteria);
        order = (order != null && !order.isEmpty()) ? order : "desc";
        sortField = (sortField != null && !sortField.isEmpty()) ? sortField : "id";
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString(order), sortField);
        return dao.findAll(mySpecification, pageable).getContent();
    }

    public int getDataSize(TypePiecesAttachementCriteria criteria) {
        TypePiecesAttachementSpecification mySpecification = constructSpecification(criteria);
        mySpecification.setDistinct(true);
        return ((Long) dao.count(mySpecification)).intValue();
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
    public int delete(TypePiecesAttachement t) {
        int result = 0;
        if (t != null) {
            dao.deleteById(t.getId());
            result = 1;
        }
        return result;
    }



    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypePiecesAttachement> delete(List<TypePiecesAttachement> list) {
		List<TypePiecesAttachement> result = new ArrayList();
        if (list != null) {
            for (TypePiecesAttachement t : list) {
                int count = delete(t);
				if(count == 0){
					result.add(t);
				}
            }
        }
		return result;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public TypePiecesAttachement create(TypePiecesAttachement t) {
        TypePiecesAttachement loaded = findByReferenceEntity(t);
        TypePiecesAttachement saved;
        if (loaded == null) {
            saved = dao.save(t);
        }else {
            saved = null;
        }
        return saved;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypePiecesAttachement> create(List<TypePiecesAttachement> ts) {
        List<TypePiecesAttachement> result = new ArrayList<>();
        if (ts != null) {
            for (TypePiecesAttachement t : ts) {
				TypePiecesAttachement created = create(t);
                if (created == null)
                    result.add(t);
            }
        }
        return result;
    }

    public TypePiecesAttachement findWithAssociatedLists(Long id){
        TypePiecesAttachement result = dao.findById(id).orElse(null);
        return result;
    }

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public List<TypePiecesAttachement> update(List<TypePiecesAttachement> ts, boolean createIfNotExist) {
        List<TypePiecesAttachement> result = new ArrayList<>();
        if (ts != null) {
            for (TypePiecesAttachement t : ts) {
                if (t.getId() == null) {
                    dao.save(t);
                } else {
                    TypePiecesAttachement loadedItem = dao.findById(t.getId()).orElse(null);
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





    public TypePiecesAttachement findByReferenceEntity(TypePiecesAttachement t){
        return t==null? null : dao.findByReference(t.getReference());
    }



    public List<TypePiecesAttachement> findAllOptimized() {
        return dao.findAllOptimized();
    }

    @Override
    public List<List<TypePiecesAttachement>> getToBeSavedAndToBeDeleted(List<TypePiecesAttachement> oldList, List<TypePiecesAttachement> newList) {
        return null;
    }

    @Override
    public String uploadFile(String checksumOld, String tempUpladedFile, String destinationFilePath) throws Exception {
        return null;
    }

    @Override
    public List<TypePiecesAttachement> importExcel(MultipartFile file) {
        return null;
    }









    private @Autowired TypePiecesAttachementDao dao;


}
