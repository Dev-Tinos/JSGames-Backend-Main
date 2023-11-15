package com.example.jsgamesbackendmain.Bean.MapperBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MapperBean {
    ObjectMapper objectMapper = new ObjectMapper();

    public <T> T to(Object fromValue, Class<T> toValueType) {
        return objectMapper.convertValue(fromValue, toValueType);
    }
}
