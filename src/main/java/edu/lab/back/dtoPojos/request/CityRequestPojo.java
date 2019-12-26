package edu.lab.back.dtoPojos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.lab.back.db.entity.CityEntity;
import edu.lab.back.dtoPojos.DtoPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CityRequestPojo implements DtoPojo {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    public static CityRequestPojo convert(final CityEntity cityEntity) {
        if (cityEntity == null) {
            return null;
        }

        final CityRequestPojo cityJson = new CityRequestPojo();
        cityJson.setId(cityEntity.getId());
        cityJson.setName(cityEntity.getName());

        return cityJson;
    }

}
