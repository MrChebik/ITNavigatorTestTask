package ru.mrchebik.model;

/**
 * Created by mrchebik on 13.09.16.
 */
public class FullClient {
    private long id;
    private String name;
    private String number;
    private String type;
    private String comment;

    public FullClient(final long id, final String name, final String number, final String type, final String comment) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
