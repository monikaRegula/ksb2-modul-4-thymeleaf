package pl.regula.ksb2modul4thymeleaf;

public class Car {

    private String model;
    private String mark;
    private Long id;

    public Car(Long id, String model, String mark) {
        this.model = model;
        this.mark = mark;
        this.id = id;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                ", id=" + id +
                '}';
    }
}
