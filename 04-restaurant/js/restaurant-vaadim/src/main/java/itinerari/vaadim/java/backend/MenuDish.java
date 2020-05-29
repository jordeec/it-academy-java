package itinerari.vaadim.java.backend;

public class MenuDish {
    private String dishName;
    private Float price;

    public MenuDish(String dishName, Float price) {
        this.dishName = dishName;
        this.price = price;
    }

    public String getDishName(){
        return this.dishName;
    }

    public Float getPrice(){
        return this.price;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.dishName + "(" + this.price + "€) ";
    }
}
