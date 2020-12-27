package orm.hibernate.repository.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private int id;
    @Column(name = "city_name")
    private String cityName;
    private int x;
    private int y;
    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Flight> sourceOfFlights;
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Flight> destinationOfFlights;

    public Location() {
        destinationOfFlights = new HashSet<>();
        sourceOfFlights = new HashSet<>();
    }

    public Set<Flight> getSourceOfFlights() {
        return sourceOfFlights;
    }

    public void setSourceOfFlights(Set<Flight> sourceOfFlights) {
        this.sourceOfFlights = sourceOfFlights;
    }

    public Set<Flight> getDestinationOfFlights() {
        return destinationOfFlights;
    }

    public void setDestinationOfFlights(Set<Flight> destinationOfFlights) {
        this.destinationOfFlights = destinationOfFlights;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + cityName + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }


    public static final class LocationBuilder {
        private String cityName;
        private int x;
        private int y;

        private LocationBuilder() {
        }

        public static LocationBuilder aLocation() {
            return new LocationBuilder();
        }

        public LocationBuilder withCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public LocationBuilder withX(int x) {
            this.x = x;
            return this;
        }

        public LocationBuilder withY(int y) {
            this.y = y;
            return this;
        }

        public Location build() {
            Location location = new Location();
            location.setCityName(cityName);
            location.setX(x);
            location.setY(y);
            return location;
        }
    }
}
