package entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

//    @Column(name = "userId")
    private long userId;

    @Column(name = "description")
    private String description;

    @Column(name = "privacy")
    private String privacy;

//    @Column(name = "locationId")
    private long locationId;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "isDeleted")
    private Boolean isDeleted;
}
