package esd.carlos.learningspring.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publisherName;
    private String address;
    private String city;
    private String state;
    private String zip;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new HashSet<>();

    public Publisher(String publisherName, String address, String city, String state, String zip) {
        this.publisherName = publisherName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Publisher(String publisherName) {
        this(publisherName, "fake address", "madrid", "es", "28047");
    }
}
