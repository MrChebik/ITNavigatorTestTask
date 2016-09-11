package ru.mrchebik.model;

/**
 * Created by mrchebik on 05.09.16.
 */
public class TelephoneNumber {
    private long id;
    private String number;
    private String type;
    private String comment;

    public TelephoneNumber() {

    }

    public TelephoneNumber(final String number, final String type, final String comment) {
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
