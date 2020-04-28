package krenc.mirek.teaipracadomowatydzien71.model;

public class Car {

    private long id;
    private String brand;
    private int productionYear;
    private Color color;

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    private String colorString;

    public Car(long id, String brand, int productionYear, Color color) {
        this.id = id;
        this.brand = brand;
        this.productionYear = productionYear;
        this.color = color;
        this.colorString = color.name();
    }

    public Car(long id, String brand, int productionYear, String colorStr) {
        this.id = id;
        this.brand = brand;
        this.productionYear = productionYear;
        for (Color color: Color.values())
        {
            if (color.name().equals(colorStr)){
                this.color = color;
            }
        }
        this.colorString = colorStr;
    }

    public Car(String brand, int productionYear, Color color) {
        this.brand = brand;
        this.productionYear = productionYear;
        this.color = color;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", productionYear=" + productionYear +
                ", color=" + color +
                '}';
    }
}
