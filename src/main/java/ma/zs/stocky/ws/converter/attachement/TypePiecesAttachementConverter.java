package  ma.zs.stocky.ws.converter.attachement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.stocky.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;




import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.attachement.TypePiecesAttachement;
import ma.zs.stocky.ws.dto.attachement.TypePiecesAttachementDto;

@Component
public class TypePiecesAttachementConverter {


    public  TypePiecesAttachementConverter() {
    }


    public TypePiecesAttachement toItem(TypePiecesAttachementDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypePiecesAttachement item = new TypePiecesAttachement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }


    public TypePiecesAttachementDto toDto(TypePiecesAttachement item) {
        if (item == null) {
            return null;
        } else {
            TypePiecesAttachementDto dto = new TypePiecesAttachementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }


	
    public List<TypePiecesAttachement> toItem(List<TypePiecesAttachementDto> dtos) {
        List<TypePiecesAttachement> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (TypePiecesAttachementDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<TypePiecesAttachementDto> toDto(List<TypePiecesAttachement> items) {
        List<TypePiecesAttachementDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (TypePiecesAttachement item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(TypePiecesAttachementDto dto, TypePiecesAttachement t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
    }

    public List<TypePiecesAttachement> copy(List<TypePiecesAttachementDto> dtos) {
        List<TypePiecesAttachement> result = new ArrayList<>();
        if (dtos != null) {
            for (TypePiecesAttachementDto dto : dtos) {
                TypePiecesAttachement instance = new TypePiecesAttachement();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


}
