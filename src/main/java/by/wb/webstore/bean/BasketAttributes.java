package by.wb.webstore.bean;

import java.util.Objects;

public class BasketAttributes {
    int id;
    String name;
    double price;
    int count;
    String specification;

    public BasketAttributes(int id, String name, double price, int count, String specification) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.count = count;
        this.specification = specification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BasketAttributes basketAttributes = (BasketAttributes) obj;
        return id == basketAttributes.id &&
                Objects.equals(name, basketAttributes.name) &&
                Objects.equals(price, basketAttributes.price) &&
                Objects.equals(count, basketAttributes.count) &&
                Objects.equals(specification, basketAttributes.specification);
    }
}
