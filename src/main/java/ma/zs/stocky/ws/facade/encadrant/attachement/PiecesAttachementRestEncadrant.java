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

import ma.zs.stocky.bean.core.attachement.PiecesAttachement;
import ma.zs.stocky.dao.criteria.core.attachement.PiecesAttachementCriteria;
import ma.zs.stocky.service.facade.encadrant.attachement.PiecesAttachementEncadrantService;
import ma.zs.stocky.ws.converter.attachement.PiecesAttachementConverter;
import ma.zs.stocky.ws.dto.attachement.PiecesAttachementDto;
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
@RequestMapping("/api/encadrant/piecesAttachement/")
public class PiecesAttachementRestEncadrant {




    @Operation(summary = "Finds a list of all piecesAttachements")
    @GetMapping("")
    public ResponseEntity<List<PiecesAttachementDto>> findAll() throws Exception {
        ResponseEntity<List<PiecesAttachementDto>> res = null;
        List<PiecesAttachement> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<PiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }


    @Operation(summary = "Finds a piecesAttachement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<PiecesAttachementDto> findById(@PathVariable Long id) {
        PiecesAttachement t = service.findById(id);
        if (t != null) {
            converter.init(true);
            PiecesAttachementDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Saves the specified  piecesAttachement")
    @PostMapping("")
    public ResponseEntity<PiecesAttachementDto> save(@RequestBody PiecesAttachementDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            PiecesAttachement myT = converter.toItem(dto);
            PiecesAttachement t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                PiecesAttachementDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  piecesAttachement")
    @PutMapping("")
    public ResponseEntity<PiecesAttachementDto> update(@RequestBody PiecesAttachementDto dto) throws Exception {
        ResponseEntity<PiecesAttachementDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            PiecesAttachement t = service.findById(dto.getId());
            converter.copy(dto,t);
            PiecesAttachement updated = service.update(t);
            PiecesAttachementDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of piecesAttachement")
    @PostMapping("multiple")
    public ResponseEntity<List<PiecesAttachementDto>> delete(@RequestBody List<PiecesAttachementDto> dtos) throws Exception {
        ResponseEntity<List<PiecesAttachementDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<PiecesAttachement> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified piecesAttachement")
    @DeleteMapping("")
    public ResponseEntity<PiecesAttachementDto> delete(@RequestBody PiecesAttachementDto dto) throws Exception {
		ResponseEntity<PiecesAttachementDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            PiecesAttachement t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified piecesAttachement")
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
    @Operation(summary = "Delete multiple piecesAttachements by ids")
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



    @Operation(summary = "Finds a piecesAttachement and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<PiecesAttachementDto> findWithAssociatedLists(@PathVariable Long id) {
        PiecesAttachement loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        PiecesAttachementDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds piecesAttachements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<PiecesAttachementDto>> findByCriteria(@RequestBody PiecesAttachementCriteria criteria) throws Exception {
        ResponseEntity<List<PiecesAttachementDto>> res = null;
        List<PiecesAttachement> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<PiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated piecesAttachements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody PiecesAttachementCriteria criteria) throws Exception {
        List<PiecesAttachement> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<PiecesAttachementDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets piecesAttachement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody PiecesAttachementCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<PiecesAttachementDto> findDtos(List<PiecesAttachement> list){
        converter.initObject(true);
        List<PiecesAttachementDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<PiecesAttachementDto> getDtoResponseEntity(PiecesAttachementDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private PiecesAttachementEncadrantService service;
    @Autowired private PiecesAttachementConverter converter;





}
