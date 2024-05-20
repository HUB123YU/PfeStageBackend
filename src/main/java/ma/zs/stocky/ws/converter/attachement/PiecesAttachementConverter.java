package  ma.zs.stocky.ws.converter.attachement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.stocky.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.stocky.ws.converter.attachement.TypePiecesAttachementConverter;
import ma.zs.stocky.ws.converter.stage.StageConverter;

import ma.zs.stocky.bean.core.stage.Stage;


import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.attachement.PiecesAttachement;
import ma.zs.stocky.ws.dto.attachement.PiecesAttachementDto;

@Component
public class PiecesAttachementConverter {

    @Autowired
    private TypePiecesAttachementConverter typePiecesAttachementConverter ;
    @Autowired
    private StageConverter stageConverter ;
    private boolean typePiecesAttachement;
    private boolean stage;

    public  PiecesAttachementConverter() {
        initObject(true);
    }


    public PiecesAttachement toItem(PiecesAttachementDto dto) {
        if (dto == null) {
            return null;
        } else {
        PiecesAttachement item = new PiecesAttachement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getContenu()))
                item.setContenu(dto.getContenu());
            if(StringUtil.isNotEmpty(dto.getTaille()))
                item.setTaille(dto.getTaille());
            if(this.typePiecesAttachement && dto.getTypePiecesAttachement()!=null)
                item.setTypePiecesAttachement(typePiecesAttachementConverter.toItem(dto.getTypePiecesAttachement())) ;

            if(dto.getStage() != null && dto.getStage().getId() != null){
                item.setStage(new Stage());
                item.getStage().setId(dto.getStage().getId());
                item.getStage().setId(dto.getStage().getId());
            }




        return item;
        }
    }


    public PiecesAttachementDto toDto(PiecesAttachement item) {
        if (item == null) {
            return null;
        } else {
            PiecesAttachementDto dto = new PiecesAttachementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getContenu()))
                dto.setContenu(item.getContenu());
            if(StringUtil.isNotEmpty(item.getTaille()))
                dto.setTaille(item.getTaille());
            if(this.typePiecesAttachement && item.getTypePiecesAttachement()!=null) {
                dto.setTypePiecesAttachement(typePiecesAttachementConverter.toDto(item.getTypePiecesAttachement())) ;

            }
            if(this.stage && item.getStage()!=null) {
                dto.setStage(stageConverter.toDto(item.getStage())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.typePiecesAttachement = value;
        this.stage = value;
    }
	
    public List<PiecesAttachement> toItem(List<PiecesAttachementDto> dtos) {
        List<PiecesAttachement> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (PiecesAttachementDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<PiecesAttachementDto> toDto(List<PiecesAttachement> items) {
        List<PiecesAttachementDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (PiecesAttachement item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(PiecesAttachementDto dto, PiecesAttachement t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getTypePiecesAttachement() != null)
        typePiecesAttachementConverter.copy(dto.getTypePiecesAttachement(), t.getTypePiecesAttachement());
        if (dto.getStage() != null)
        stageConverter.copy(dto.getStage(), t.getStage());
    }

    public List<PiecesAttachement> copy(List<PiecesAttachementDto> dtos) {
        List<PiecesAttachement> result = new ArrayList<>();
        if (dtos != null) {
            for (PiecesAttachementDto dto : dtos) {
                PiecesAttachement instance = new PiecesAttachement();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public TypePiecesAttachementConverter getTypePiecesAttachementConverter(){
        return this.typePiecesAttachementConverter;
    }
    public void setTypePiecesAttachementConverter(TypePiecesAttachementConverter typePiecesAttachementConverter ){
        this.typePiecesAttachementConverter = typePiecesAttachementConverter;
    }
    public StageConverter getStageConverter(){
        return this.stageConverter;
    }
    public void setStageConverter(StageConverter stageConverter ){
        this.stageConverter = stageConverter;
    }
    public boolean  isTypePiecesAttachement(){
        return this.typePiecesAttachement;
    }
    public void  setTypePiecesAttachement(boolean typePiecesAttachement){
        this.typePiecesAttachement = typePiecesAttachement;
    }
    public boolean  isStage(){
        return this.stage;
    }
    public void  setStage(boolean stage){
        this.stage = stage;
    }
}
