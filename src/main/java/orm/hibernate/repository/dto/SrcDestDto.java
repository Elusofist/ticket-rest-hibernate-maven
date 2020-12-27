package orm.hibernate.repository.dto;

import orm.hibernate.repository.entity.Location;

public class SrcDestDto {
    private Location source;
    private Location destination;

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public static final class SrcDestDtoBuilder {
        private Location source;
        private Location destination;

        private SrcDestDtoBuilder() {
        }


        public static SrcDestDtoBuilder aSrcDestDto() {
            return new SrcDestDtoBuilder();
        }

        public SrcDestDtoBuilder withSource(Location source) {
            this.source = source;
            return this;
        }

        public SrcDestDtoBuilder withDestination(Location destination) {
            this.destination = destination;
            return this;
        }

        public SrcDestDto build() {
            SrcDestDto srcDestDto = new SrcDestDto();
            srcDestDto.source = this.source;
            srcDestDto.destination = this.destination;
            return srcDestDto;
        }
    }
}
