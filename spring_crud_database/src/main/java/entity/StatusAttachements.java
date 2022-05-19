package entity;

import javax.persistence.*;

@Entity
public class StatusAttachements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "attachmentId")
    private long attachmentId;

    @Column(name = "statusId")
    private long statusId;

}
