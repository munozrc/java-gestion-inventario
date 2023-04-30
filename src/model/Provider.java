package model;

public class Provider {

    private int id;
    private String name;
    private String email;

    public Provider(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Provider(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Provider() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
