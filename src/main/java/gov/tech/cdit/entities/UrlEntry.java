package gov.tech.cdit.entities;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UrlEntry {

    @Id
    private String id;

    @NonNull
    @Column
    private String url;

}
