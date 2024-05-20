package  ma.zs.stocky.ws.facade.admin.stage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import java.util.Arrays;
import java.util.ArrayList;

import ma.zs.stocky.bean.core.stage.StagePiecesAttachement;
import ma.zs.stocky.dao.criteria.core.stage.StagePiecesAttachementCriteria;
import ma.zs.stocky.service.facade.admin.stage.StagePiecesAttachementAdminService;
import ma.zs.stocky.ws.converter.stage.StagePiecesAttachementConverter;
import ma.zs.stocky.ws.dto.stage.StagePiecesAttachementDto;
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
@RequestMapping("/api/admin/stagePiecesAttachement/")
public class StagePiecesAttachementRestAdmin {




    @Operation(summary = "Finds a list of all stagePiecesAttachements")
    @GetMapping("")
    public ResponseEntity<List<StagePiecesAttachementDto>> findAll() throws Exception {
        ResponseEntity<List<StagePiecesAttachementDto>> res = null;
        List<StagePiecesAttachement> list = service.findAll();
        HttpStatus status = HttpStatus.NO_CONTENT;
            converter.initObject(true);
        List<StagePiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;
        res = new ResponseEntity<>(dtos, status);
        return res;
    }


    @Operation(summary = "Finds a stagePiecesAttachement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<StagePiecesAttachementDto> findById(@PathVariable Long id) {
        StagePiecesAttachement t = service.findById(id);
        if (t != null) {
            converter.init(true);
            StagePiecesAttachementDto dto = converter.toDto(t);
            return getDtoResponseEntity(dto);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Saves the specified  stagePiecesAttachement")
    @PostMapping("")
    public ResponseEntity<StagePiecesAttachementDto> save(@RequestBody StagePiecesAttachementDto dto) throws Exception {
        if(dto!=null){
            converter.init(true);
            StagePiecesAttachement myT = converter.toItem(dto);
            StagePiecesAttachement t = service.create(myT);
            if (t == null) {
                return new ResponseEntity<>(null, HttpStatus.IM_USED);
            }else{
                StagePiecesAttachementDto myDto = converter.toDto(t);
                return new ResponseEntity<>(myDto, HttpStatus.CREATED);
            }
        }else {
            return new ResponseEntity<>(dto, HttpStatus.NO_CONTENT);
        }
    }

    @Operation(summary = "Updates the specified  stagePiecesAttachement")
    @PutMapping("")
    public ResponseEntity<StagePiecesAttachementDto> update(@RequestBody StagePiecesAttachementDto dto) throws Exception {
        ResponseEntity<StagePiecesAttachementDto> res ;
        if (dto.getId() == null || service.findById(dto.getId()) == null)
            res = new ResponseEntity<>(HttpStatus.CONFLICT);
        else {
            StagePiecesAttachement t = service.findById(dto.getId());
            converter.copy(dto,t);
            StagePiecesAttachement updated = service.update(t);
            StagePiecesAttachementDto myDto = converter.toDto(updated);
            res = new ResponseEntity<>(myDto, HttpStatus.OK);
        }
        return res;
    }

    @Operation(summary = "Delete list of stagePiecesAttachement")
    @PostMapping("multiple")
    public ResponseEntity<List<StagePiecesAttachementDto>> delete(@RequestBody List<StagePiecesAttachementDto> dtos) throws Exception {
        ResponseEntity<List<StagePiecesAttachementDto>> res ;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dtos != null && !dtos.isEmpty()) {
            converter.init(false);
            List<StagePiecesAttachement> ts = converter.toItem(dtos);
            service.delete(ts);
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dtos, status);
        return res;
    }
    @Operation(summary = "Delete the specified stagePiecesAttachement")
    @DeleteMapping("")
    public ResponseEntity<StagePiecesAttachementDto> delete(@RequestBody StagePiecesAttachementDto dto) throws Exception {
		ResponseEntity<StagePiecesAttachementDto> res;
        HttpStatus status = HttpStatus.CONFLICT;
        if (dto != null) {
            converter.init(false);
            StagePiecesAttachement t = converter.toItem(dto);
            service.delete(Arrays.asList(t));
            status = HttpStatus.OK;
        }
        res = new ResponseEntity<>(dto, status);
        return res;
    }

    @Operation(summary = "Delete the specified stagePiecesAttachement")
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
    @Operation(summary = "Delete multiple stagePiecesAttachements by ids")
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


    @Operation(summary = "find by stage id")
    @GetMapping("stage/id/{id}")
    public List<StagePiecesAttachementDto> findByStageId(@PathVariable Long id){
        return findDtos(service.findByStageId(id));
    }
    @Operation(summary = "delete by stage id")
    @DeleteMapping("stage/id/{id}")
    public int deleteByStageId(@PathVariable Long id){
        return service.deleteByStageId(id);
    }
    @Operation(summary = "find by piecesAttachement id")
    @GetMapping("piecesAttachement/id/{id}")
    public List<StagePiecesAttachementDto> findByPiecesAttachementId(@PathVariable Long id){
        return findDtos(service.findByPiecesAttachementId(id));
    }
    @Operation(summary = "delete by piecesAttachement id")
    @DeleteMapping("piecesAttachement/id/{id}")
    public int deleteByPiecesAttachementId(@PathVariable Long id){
        return service.deleteByPiecesAttachementId(id);
    }

    @Operation(summary = "Finds a stagePiecesAttachement and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<StagePiecesAttachementDto> findWithAssociatedLists(@PathVariable Long id) {
        StagePiecesAttachement loaded =  service.findWithAssociatedLists(id);
        converter.init(true);
        StagePiecesAttachementDto dto = converter.toDto(loaded);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Operation(summary = "Finds stagePiecesAttachements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<StagePiecesAttachementDto>> findByCriteria(@RequestBody StagePiecesAttachementCriteria criteria) throws Exception {
        ResponseEntity<List<StagePiecesAttachementDto>> res = null;
        List<StagePiecesAttachement> list = service.findByCriteria(criteria);
        HttpStatus status = HttpStatus.NO_CONTENT;
        converter.initObject(true);
        List<StagePiecesAttachementDto> dtos  = converter.toDto(list);
        if (dtos != null && !dtos.isEmpty())
            status = HttpStatus.OK;

        res = new ResponseEntity<>(dtos, status);
        return res;
    }

    @Operation(summary = "Finds paginated stagePiecesAttachements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody StagePiecesAttachementCriteria criteria) throws Exception {
        List<StagePiecesAttachement> list = service.findPaginatedByCriteria(criteria, criteria.getPage(), criteria.getMaxResults(), criteria.getSortOrder(), criteria.getSortField());
        converter.initObject(true);
        List<StagePiecesAttachementDto> dtos = converter.toDto(list);
        PaginatedList paginatedList = new PaginatedList();
        paginatedList.setList(dtos);
        if (dtos != null && !dtos.isEmpty()) {
            int dateSize = service.getDataSize(criteria);
            paginatedList.setDataSize(dateSize);
        }
        return new ResponseEntity<>(paginatedList, HttpStatus.OK);
    }

    @Operation(summary = "Gets stagePiecesAttachement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody StagePiecesAttachementCriteria criteria) throws Exception {
        int count = service.getDataSize(criteria);
        return new ResponseEntity<Integer>(count, HttpStatus.OK);
    }
	
	public List<StagePiecesAttachementDto> findDtos(List<StagePiecesAttachement> list){
        converter.initObject(true);
        List<StagePiecesAttachementDto> dtos = converter.toDto(list);
        return dtos;
    }

    private ResponseEntity<StagePiecesAttachementDto> getDtoResponseEntity(StagePiecesAttachementDto dto) {
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }




    @Autowired private StagePiecesAttachementAdminService service;
    @Autowired private StagePiecesAttachementConverter converter;





}
