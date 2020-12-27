package orm.hibernate.repository.adaptor;

import orm.hibernate.repository.dto.SrcDestDto;
import orm.hibernate.repository.entity.Ticket;

public class TicketAdaptor {
    public static SrcDestDto toSrcDestDto(Ticket ticket) {
        return SrcDestDto.SrcDestDtoBuilder.aSrcDestDto()
                .withDestination(ticket.getFlight().getDestination())
                .withSource(ticket.getFlight().getSource())
                .build();
    }
}
