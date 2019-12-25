package edu.lab.back.json.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import edu.lab.back.db.entity.CityEntity;
import edu.lab.back.db.entity.SchoolEntity;
import edu.lab.back.json.JsonPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@JacksonXmlRootElement(localName = "city")
public class CityResponsePojo implements JsonPojo {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    //TODO в рамках лабы норм, но лучше бы тут лежали просто айдишники
//    @JsonProperty(value = "schools")
//    private List<SchoolResponseJson> schools;
    @JsonProperty(value = "schools_ids")
    private List<Long> schoolsIds;


    public static CityResponsePojo convert(final CityEntity cityEntity) {
        if (cityEntity == null) {
            return null;
        }

        final CityResponsePojo cityResponsePojo = new CityResponsePojo();
        cityResponsePojo.setId(cityEntity.getId());
        cityResponsePojo.setName(cityEntity.getName());

        if (cityEntity.getSchools() != null) {
            final List<Long> schoolsIds = cityEntity.getSchools()
                .stream()
                .map(SchoolEntity::getId)
                .collect(Collectors.toList());

            cityResponsePojo.setSchoolsIds(schoolsIds);
        }

        return cityResponsePojo;
    }

}
