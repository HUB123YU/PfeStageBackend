package  ma.zs.stocky.ws.converter.stage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.stocky.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.stocky.ws.converter.attachement.PiecesAttachementConverter;
import ma.zs.stocky.ws.converter.stage.StageConverter;

import ma.zs.stocky.bean.core.stage.Stage;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.stage.StagePiecesAttachement;
import ma.zs.stocky.ws.dto.stage.StagePiecesAttachementDto;

@Component
public class StagePiecesAttachementConverter {

    @Autowired
    private PiecesAttachementConverter piecesAttachementConverter ;
    @Autowired
    private StageConverter stageConverter ;
    private boolean stage;
    private boolean piecesAttachement;

    public  StagePiecesAttachementConverter() {
        initObject(true);
    }


    public StagePiecesAttachement toItem(StagePiecesAttachementDto dto) {
        if (dto == null) {
            return null;
        } else {
        StagePiecesAttachement item = new StagePiecesAttachement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getStage() != null && dto.getStage().getId() != null){
                item.setStage(new Stage());
                item.getStage().setId(dto.getStage().getId());
                item.getStage().setId(dto.getStage().getId());
            }

            if(this.piecesAttachement && dto.getPiecesAttachement()!=null)
                item.setPiecesAttachement(piecesAttachementConverter.toItem(dto.getPiecesAttachement())) ;




        return item;
        }
    }


    public StagePiecesAttachementDto toDto(StagePiecesAttachement item) {
        if (item == null) {
            return null;
        } else {
            StagePiecesAttachementDto dto = new StagePiecesAttachementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(this.stage && item.getStage()!=null) {
                dto.setStage(stageConverter.toDto(item.getStage())) ;

            }
            if(this.piecesAttachement && item.getPiecesAttachement()!=null) {
                dto.setPiecesAttachement(piecesAttachementConverter.toDto(item.getPiecesAttachement())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.stage = value;
        this.piecesAttachement = value;
    }
	
    public List<StagePiecesAttachement> toItem(List<StagePiecesAttachementDto> dtos) {
        List<StagePiecesAttachement> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (StagePiecesAttachementDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<StagePiecesAttachementDto> toDto(List<StagePiecesAttachement> items) {
        List<StagePiecesAttachementDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (StagePiecesAttachement item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(StagePiecesAttachementDto dto, StagePiecesAttachement t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getStage() != null)
        stageConverter.copy(dto.getStage(), t.getStage());
        if (dto.getPiecesAttachement() != null)
        piecesAttachementConverter.copy(dto.getPiecesAttachement(), t.getPiecesAttachement());
    }

    public List<StagePiecesAttachement> copy(List<StagePiecesAttachementDto> dtos) {
        List<StagePiecesAttachement> result = new ArrayList<>();
        if (dtos != null) {
            for (StagePiecesAttachementDto dto : dtos) {
                StagePiecesAttachement instance = new StagePiecesAttachement();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public PiecesAttachementConverter getPiecesAttachementConverter(){
        return this.piecesAttachementConverter;
    }
    public void setPiecesAttachementConverter(PiecesAttachementConverter piecesAttachementConverter ){
        this.piecesAttachementConverter = piecesAttachementConverter;
    }
    public StageConverter getStageConverter(){
        return this.stageConverter;
    }
    public void setStageConverter(StageConverter stageConverter ){
        this.stageConverter = stageConverter;
    }
    public boolean  isStage(){
        return this.stage;
    }
    public void  setStage(boolean stage){
        this.stage = stage;
    }
    public boolean  isPiecesAttachement(){
        return this.piecesAttachement;
    }
    public void  setPiecesAttachement(boolean piecesAttachement){
        this.piecesAttachement = piecesAttachement;
    }
}
