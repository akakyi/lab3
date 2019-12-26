package edu.lab.back.service.validator.implementations;

import edu.lab.back.dtoPojos.ProfileTypePojo;
import edu.lab.back.service.validator.ProfileTypeValidator;
import edu.lab.back.util.ValidationMessages;
import edu.lab.back.util.exception.InvalidPayloadException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProfileTypeValidatorImpl implements ProfileTypeValidator {

    @Override
    public void validateSave(final ProfileTypePojo profileTypeJson) throws InvalidPayloadException {
        this.baseValidate(profileTypeJson);
    }

    @Override
    public void validateUpdate(final ProfileTypePojo profileTypeJson) throws InvalidPayloadException {
        this.baseValidate(profileTypeJson);
    }

    private void baseValidate(@NonNull final ProfileTypePojo profileTypeJson) throws InvalidPayloadException {
        if (profileTypeJson.getId() == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }
        if (profileTypeJson.getName() == null) {
            throw new InvalidPayloadException(ValidationMessages.INVALID_REQUEST_JSON);
        }
    }
}
