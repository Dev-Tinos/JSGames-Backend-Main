package com.example.jsgamesbackendmain.Bean.MapperBean;

import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter@Setter
public class MajorMapperBean {
    private Map<Major, ParentMajor> map = setMap();

    public ParentMajor getParentMajor(Major major) {
        return map.get(major);
    }

    private HashMap<Major, ParentMajor> setMap() {
        HashMap<Major, ParentMajor> map = new HashMap<>();
        map.put(Major.소프트웨어학과, ParentMajor.컴퓨터공학부);
        map.put(Major.컴퓨터공학과, ParentMajor.컴퓨터공학부);
        map.put(Major.인공지능학과, ParentMajor.인공지능학과);
        map.put(Major.게임공학과, ParentMajor.게임공학과);
        map.put(Major.산업경영학과, ParentMajor.경영학부);
        map.put(Major.IT경영학과, ParentMajor.경영학부);
        map.put(Major.데이터사이언스경영학과, ParentMajor.경영학부);
        map.put(Major.글로벌융합공학과, ParentMajor.글로벌융합공학과);
        map.put(Major.기계공학과, ParentMajor.기계공학과);
        map.put(Major.기계설계공학과, ParentMajor.기계설계공학과);
        map.put(Major.나노반도체공학과, ParentMajor.나노반도체공학과);
        map.put(Major.메카트로닉스학과, ParentMajor.메가트로닉스공학부);
        map.put(Major.AI로봇학과, ParentMajor.메가트로닉스공학부);
        map.put(Major.산업디자인공학과, ParentMajor.디자인공학부);
        map.put(Major.미디어디자인학과, ParentMajor.디자인공학부);
        map.put(Major.생명화학공학과, ParentMajor.생명화학공학과);
        map.put(Major.신소재공학과, ParentMajor.신소재공학과);
        map.put(Major.애너지전기공학과, ParentMajor.애너지전기공학과);
        map.put(Major.지식융합학과, ParentMajor.지식융합학과);
        map.put(Major.전자공학과, ParentMajor.전자공학부);
        map.put(Major.암배디드시스템학과, ParentMajor.전자공학부);

        return map;
    }
}
