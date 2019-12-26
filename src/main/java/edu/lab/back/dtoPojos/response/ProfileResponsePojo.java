package edu.lab.back.dtoPojos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.lab.back.db.entity.ProfileEntity;
import edu.lab.back.db.entity.ProfileTypeEntity;
import edu.lab.back.dtoPojos.DtoPojo;
import edu.lab.back.util.ProfileTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileResponsePojo implements DtoPojo {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "age")
    private Integer age;

    @JsonProperty(value = "profile_type")
    private ProfileTypeEnum profileType;

    @JsonProperty(value = "class_level")
    private String classLevel;

    public static ProfileResponsePojo convert(final ProfileEntity profileEntity) {
        if (profileEntity == null) {
            return null;
        }

        final ProfileResponsePojo result = new ProfileResponsePojo();
        result.setAge(profileEntity.getAge());
        result.setClassLevel(profileEntity.getClassLevel());
        result.setId(profileEntity.getId());
        result.setName(profileEntity.getName());

        final ProfileTypeEntity profileType = profileEntity.getProfileType();
        if (profileType != null) {
            result.setProfileType(ProfileTypeEnum.getEnumByName(profileType.getName()));
        }

        return result;
    }

}
