package pl.regula.ksb2modul4thymeleaf;

public class Car {

    private String model;
    private String mark;

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

    public Car(String model, String mark) {
        this.model = model;
        this.mark = mark;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
