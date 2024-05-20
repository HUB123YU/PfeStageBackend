package  ma.zs.stocky.ws.facade.encadrant.attachement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import ma.zs.stocky.dao.criteria.core.attachement.TypePiecesAttachementCriteria;
import ma.zs.stocky.service.facade.encadrant.attachement.TypePiecesAttachementEncadrantService;
import ma.zs.stocky.ws.converter.attachement.TypePiecesAttachementConverter;
import ma.zs.stocky.ws.dto.attachement.TypePiecesAttachementDto;
import ma.zs.stocky.zynerator.controller.AbstractController;
import ma.zs.stocky.zynerator.dto.AuditEntityDto;
import ma.zs.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/encadrant/typePiecesAttachement/")
public class TypePiecesAttachementRestEncadrant {




    @Operation(summary = "Finds a list of all typePiecesAttachements")
    @GetMapping("")
    public ResponseEntity<List<TypePiecesAttachementDto>> findAll() throws Exception {
        ResponseEntity<List<TypePiecesAttachementDto>> res = null;
        List<TypePiecesAttachement> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypePiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds an optimized list of all typePiecesAttachements")
    @GetMapping("optimized")
    public ResponseEntity<List<TypePiecesAttachementDto>> findAllOptimized() throws Exception {
        ResponseEntity<List<TypePiecesAttachementDto>> res = null;
        List<TypePiecesAttachement> list = service.findAllOptimized();
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypePiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds a typePiecesAttachement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<TypePiecesAttachementDto> findById(@PathVariable Long id) {
        TypePiecesAttachement t = service.findById(id);
        if (t != null) {
            TypePiecesAttachementDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Finds a typePiecesAttachement by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<TypePiecesAttachementDto> findByLibelle(@PathVariable String libelle) {
	    TypePiecesAttachement t = service.findByReferenceEntity(new TypePiecesAttachement(libelle));
        if (t != null) {
            TypePiecesAttachementDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Saves the specified  typePiecesAttachement")
    @PostMapping("")
    public ResponseEntity<TypePiecesAttachementDto> save(@RequestBody TypePiecesAttachementDto dto) throws Exception {
        if(dto!=null){
            TypePiecesAttachement myT = converter.toItem(dto);
            TypePiecesAttachement t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                TypePiecesAttachementDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  typePiecesAttachement")
    @PutMapping("")
    public ResponseEntity<TypePiecesAttachementDto> update(@RequestBody TypePiecesAttachementDto dto) throws Exception {
        ResponseEntity<TypePiecesAttachementDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            TypePiecesAttachement t = service.findById(dto.getId());
            converter.copy(dto,t);
            TypePiecesAttachement updated = service.update(t);
            TypePiecesAttachementDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of typePiecesAttachement")
    @PostMapping("multiple")
    public ResponseEntity<List<TypePiecesAttachementDto>> delete(@RequestBody List<TypePiecesAttachementDto> dtos) throws Exception {
        ResponseEntity<List<TypePiecesAttachementDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            List<TypePiecesAttachement> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified typePiecesAttachement")
    @DeleteMapping("")
    public ResponseEntity<TypePiecesAttachementDto> delete(@RequestBody TypePiecesAttachementDto dto) throws Exception {
		ResponseEntity<TypePiecesAttachementDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            TypePiecesAttachement t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified typePiecesAttachement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        ResponseEntity<Long> res;
        HttpStatus status = HttpStatus.PRECONDITION_FAILED;
        if (id != null) {
            boolean resultDelete = service.deleteById(id);
            if (resultDelete) {
                status = HttpStatus.OK;
            }
        }
        res = new ResponseEntity<>(id, status);
        return res;
    }
    @Operation(summary = "Delete multiple typePiecesAttachements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
        ResponseEntity<List<Long>> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (ids != null) {
            service.deleteByIdIn(ids);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(ids, status);
        return res;
     }



    @Operation(summary = "Finds a typePiecesAttachement and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<TypePiecesAttachementDto> findWithAssociatedLists(@PathVariable Long id) {
        TypePiecesAttachement loaded =  service.findWithAssociatedLists(id);
        TypePiecesAttachementDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds typePiecesAttachements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<TypePiecesAttachementDto>> findByCriteria(@RequestBody TypePiecesAttachementCriteria criteria) throws Exception {
        ResponseEntity<List<TypePiecesAttachementDto>> res = null;
        List<TypePiecesAttachement> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        List<TypePiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated typePiecesAttachements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody TypePiecesAttachementCriteria criteria) throws Exception {
        List<TypePiecesAttachement> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        List<TypePiecesAttachementDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets typePiecesAttachement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody TypePiecesAttachementCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<TypePiecesAttachementDto> findDtos(List<TypePiecesAttachement> list){
        List<TypePiecesAttachementDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<TypePiecesAttachementDto> getDtoResponseEntity(TypePiecesAttachementDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private TypePiecesAttachementEncadrantService service;
    @Autowired private TypePiecesAttachementConverter converter;





}
