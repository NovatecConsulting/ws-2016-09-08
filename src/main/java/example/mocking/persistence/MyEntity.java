package example.mocking.persistence;

public class MyEntity {

    private Long id;
    private String value;

    public MyEntity() {
    }

    public MyEntity(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
