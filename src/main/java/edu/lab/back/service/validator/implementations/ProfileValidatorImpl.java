package edu.lab.back.service.validator.implementations;

import edu.lab.back.db.repositories.ProfileTypeRepository;
import edu.lab.back.db.repositories.SchoolRepository;
import edu.lab.back.db.entity.SchoolEntity;
import edu.lab.back.dtoPojos.request.ProfileRequestPojo;
import edu.lab.back.service.validator.ProfileValidator;
import edu.lab.back.util.ProfileTypeEnum;
import edu.lab.back.util.ValidationMessages;
import edu.lab.back.util.exception.InvalidPayloadException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProfileValidatorImpl implements ProfileValidator {

    @NonNull
    private final ProfileTypeRepository profileTypeRepository;

    @NonNull
    private final SchoolRepository schoolRepository;

    @Override
    public void validateSave(final ProfileRequestPojo requestJson) throws InvalidPayloadException {
        if (requestJson == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }
        if (requestJson.getId() != null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }

        this.baseValidate(requestJson);
    }

    @Override
    public void validateUpdate(final ProfileRequestPojo requestJson) throws InvalidPayloadException {
        if (requestJson == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }
        if (requestJson.getId() == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }

        this.baseValidate(requestJson);
    }

    private void baseValidate(@NonNull final ProfileRequestPojo requestJson) throws InvalidPayloadException {
        final String name = requestJson.getName();
        if (name == null || name.equals("")) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }

        final ProfileTypeEnum profileType = requestJson.getProfileType();
        if (profileType == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }
//        final ProfileTypeEntity type = this.profileTypeDao.getByName(profileType.getName());
//        if (type == null) {
//            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
//        }

        final Long schoolId = requestJson.getSchoolId();
        if (schoolId == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }
        final Optional<SchoolEntity> school = this.schoolRepository.findById(schoolId);
        if (!school.isPresent()) {
            throw new InvalidPayloadException(ValidationMessages.REFERRED_ENTITY_NOT_EXIST);
        }
    }
}
