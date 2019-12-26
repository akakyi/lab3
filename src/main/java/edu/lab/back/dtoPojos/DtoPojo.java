package edu.lab.back.dtoPojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface DtoPojo {

    default String toJsonString() throws JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        final String jsonString = mapper.writeValueAsString(this);

        return jsonString;
    }

}
