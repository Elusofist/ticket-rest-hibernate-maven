package orm.hibernate.repository.dto;

public class TicketDto {
    private String owner;
    private Integer flightNo;

    public TicketDto() {
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(Integer flightNo) {
        this.flightNo = flightNo;
    }

    public static final class TicketDtoBuilder {
        private String owner;
        private int flightNo;

        private TicketDtoBuilder() {
        }

        public static TicketDtoBuilder aTicketDto() {
            return new TicketDtoBuilder();
        }

        public TicketDtoBuilder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public TicketDtoBuilder withFlightNo(int flightNo) {
            this.flightNo = flightNo;
            return this;
        }

        public TicketDto build() {
            TicketDto ticketDto = new TicketDto();
            ticketDto.flightNo = this.flightNo;
            ticketDto.owner = this.owner;
            return ticketDto;
        }
    }
}