package com.ejercico.springboot.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RestController
public class FilteringController {

    @GetMapping("/filter")
    public MappingJacksonValue getUserFiltered(@RequestParam String filterParams){
        UserFiteredDto userFiteredDto =new UserFiteredDto(1,"user1","1234");
        Set<String> filters = new HashSet<>(Arrays.asList(filterParams.split(",")));

        SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(filters);
        FilterProvider filter = new SimpleFilterProvider().addFilter("UserFilter", propertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userFiteredDto);
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;
        }
}
