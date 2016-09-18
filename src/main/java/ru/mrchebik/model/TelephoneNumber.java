package ru.mrchebik.model;

import javax.persistence.*;

/**
 * Created by mrchebik on 05.09.16.
 */
@Entity
@Table(name = "TelephoneNumber")
public class TelephoneNumber {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;

    @Column(nullable = false, length = 19)
    private String number;

    @Column(nullable = false, length = 12)
    private String type;

    @Column(nullable = false)
    private String comment;

    public TelephoneNumber() {

    }

    public TelephoneNumber(final String number, final String type, final String comment) {
        this.number = number;
        this.type = type;
        this.comment = comment;
    }

    public TelephoneNumber(final long id, final String number, final String type, final String comment) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
