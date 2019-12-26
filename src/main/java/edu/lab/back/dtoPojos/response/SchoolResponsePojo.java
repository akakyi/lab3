package edu.lab.back.dtoPojos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.lab.back.db.entity.ProfileEntity;
import edu.lab.back.db.entity.SchoolEntity;
import edu.lab.back.dtoPojos.DtoPojo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SchoolResponsePojo implements DtoPojo {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    //TODO в рамках лабы норм, но лучше бы тут лежали просто айдишники
//    @JsonProperty(value = "profiles")
//    private List<ProfileResponsePojo> profiles;
    private List<Long> profilesIds;

    public static SchoolResponsePojo convert(final SchoolEntity schoolEntity) {
        if (schoolEntity == null) {
            return null;
        }

        SchoolResponsePojo result = new SchoolResponsePojo();
        result.setId(schoolEntity.getId());
        result.setName(schoolEntity.getName());

        if (schoolEntity.getProfiles() != null) {
            final List<Long> profilesIds = schoolEntity.getProfiles()
                .stream()
                .map(ProfileEntity::getId)
                .collect(Collectors.toList());

            result.setProfilesIds(profilesIds);
        }

        return result;
    }

}
