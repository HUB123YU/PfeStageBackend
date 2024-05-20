package  ma.zs.stocky.ws.converter.encadrant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.BeanUtils;
import ma.zs.stocky.zynerator.converter.AbstractConverterHelper;

import java.util.ArrayList;
import java.util.List;

import ma.zs.stocky.ws.converter.appartenance.NationaliteConverter;
import ma.zs.stocky.ws.converter.appartenance.GenreConverter;



import ma.zs.stocky.zynerator.util.StringUtil;
import ma.zs.stocky.zynerator.converter.AbstractConverter;
import ma.zs.stocky.zynerator.util.DateUtil;
import ma.zs.stocky.bean.core.encadrant.EncadrantInterne;
import ma.zs.stocky.ws.dto.encadrant.EncadrantInterneDto;

@Component
public class EncadrantInterneConverter {

    @Autowired
    private NationaliteConverter nationaliteConverter ;
    @Autowired
    private GenreConverter genreConverter ;
    private boolean genre;
    private boolean nationalit;

    public  EncadrantInterneConverter() {
        initObject(true);
    }


    public EncadrantInterne toItem(EncadrantInterneDto dto) {
        if (dto == null) {
            return null;
        } else {
        EncadrantInterne item = new EncadrantInterne();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getNom()))
                item.setNom(dto.getNom());
            if(StringUtil.isNotEmpty(dto.getPrenom()))
                item.setPrenom(dto.getPrenom());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getBiographie()))
                item.setBiographie(dto.getBiographie());
            if(StringUtil.isNotEmpty(dto.getTelephone()))
                item.setTelephone(dto.getTelephone());
            if(this.genre && dto.getGenre()!=null)
                item.setGenre(genreConverter.toItem(dto.getGenre())) ;

            if(this.nationalit && dto.getNationalit()!=null)
                item.setNationalit(nationaliteConverter.toItem(dto.getNationalit())) ;




        return item;
        }
    }


    public EncadrantInterneDto toDto(EncadrantInterne item) {
        if (item == null) {
            return null;
        } else {
            EncadrantInterneDto dto = new EncadrantInterneDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getNom()))
                dto.setNom(item.getNom());
            if(StringUtil.isNotEmpty(item.getPrenom()))
                dto.setPrenom(item.getPrenom());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getBiographie()))
                dto.setBiographie(item.getBiographie());
            if(StringUtil.isNotEmpty(item.getTelephone()))
                dto.setTelephone(item.getTelephone());
            if(this.genre && item.getGenre()!=null) {
                dto.setGenre(genreConverter.toDto(item.getGenre())) ;

            }
            if(this.nationalit && item.getNationalit()!=null) {
                dto.setNationalit(nationaliteConverter.toDto(item.getNationalit())) ;

            }


        return dto;
        }
    }

    public void init(boolean value) {
        initObject(value);
    }

    public void initObject(boolean value) {
        this.genre = value;
        this.nationalit = value;
    }
	
    public List<EncadrantInterne> toItem(List<EncadrantInterneDto> dtos) {
        List<EncadrantInterne> items = new ArrayList<>();
        if (dtos != null && !dtos.isEmpty()) {
            for (EncadrantInterneDto dto : dtos) {
                items.add(toItem(dto));
            }
        }
        return items;
    }


    public List<EncadrantInterneDto> toDto(List<EncadrantInterne> items) {
        List<EncadrantInterneDto> dtos = new ArrayList<>();
        if (items != null && !items.isEmpty()) {
            for (EncadrantInterne item : items) {
                dtos.add(toDto(item));
            }
        }
        return dtos;
    }


    public void copy(EncadrantInterneDto dto, EncadrantInterne t) {
		BeanUtils.copyProperties(dto, t, AbstractConverterHelper.getNullPropertyNames(dto));
        if (dto.getGenre() != null)
        genreConverter.copy(dto.getGenre(), t.getGenre());
        if (dto.getNationalit() != null)
        nationaliteConverter.copy(dto.getNationalit(), t.getNationalit());
    }

    public List<EncadrantInterne> copy(List<EncadrantInterneDto> dtos) {
        List<EncadrantInterne> result = new ArrayList<>();
        if (dtos != null) {
            for (EncadrantInterneDto dto : dtos) {
                EncadrantInterne instance = new EncadrantInterne();
                copy(dto, instance);
                result.add(instance);
            }
        }
        return result.isEmpty() ? null : result;
    }


    public NationaliteConverter getNationaliteConverter(){
        return this.nationaliteConverter;
    }
    public void setNationaliteConverter(NationaliteConverter nationaliteConverter ){
        this.nationaliteConverter = nationaliteConverter;
    }
    public GenreConverter getGenreConverter(){
        return this.genreConverter;
    }
    public void setGenreConverter(GenreConverter genreConverter ){
        this.genreConverter = genreConverter;
    }
    public boolean  isGenre(){
        return this.genre;
    }
    public void  setGenre(boolean genre){
        this.genre = genre;
    }
    public boolean  isNationalit(){
        return this.nationalit;
    }
    public void  setNationalit(boolean nationalit){
        this.nationalit = nationalit;
    }
}
