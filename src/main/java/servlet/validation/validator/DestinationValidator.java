package servlet.validation.validator;

import orm.hibernate.repository.dto.SrcDestDto;

public class DestinationValidator implements Validator<SrcDestDto> {
    private static DestinationValidator instance;

    public static DestinationValidator getInstance() {
        if (instance == null) {
            synchronized (DestinationValidator.class) {
                if (instance == null) {
                    instance = new DestinationValidator();
                }
            }
        }
        return instance;
    }

    private DestinationValidator() {
    }

    @Override
    public boolean isValid(SrcDestDto srcDestDto) {
        return srcDestDto.getDestination()
                != srcDestDto.getSource();
    }
}