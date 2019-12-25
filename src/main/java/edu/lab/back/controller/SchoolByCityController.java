package edu.lab.back.controller;

import edu.lab.back.json.response.SchoolResponseJson;
import edu.lab.back.service.crud.SchoolService;
import edu.lab.back.util.exception.InvalidPayloadException;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/school_of_city")
public class SchoolByCityController {

    private final SchoolService schoolService;

    public SchoolByCityController(@NonNull final SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.GET,
        produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
        }
    )
    protected List<SchoolResponseJson> getSchoolsByCity(
        @PathVariable("id") Long id
    ) throws InvalidPayloadException {
        final List<SchoolResponseJson> schools = this.schoolService.getSchoolsByCityId(id);

        return schools;
    }

}
