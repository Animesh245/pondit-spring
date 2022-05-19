package entity;

import javax.persistence.*;

@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "attachmentName")
    private String attachmentName;

    @Column(name = "attachmentPath")
    private String attachmentPath;

    @Column(name = "type")
    private String type;
}
