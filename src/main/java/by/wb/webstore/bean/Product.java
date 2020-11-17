package by.wb.webstore.bean;

import java.util.Objects;

public class Product {
    private static final long serialVersionUID = -1779355022603448451L;

    int id;
    String name;
    Double price;
    int categoryId;
    int count;
    String specification;

    public Product(int id, String name, Double price, int categoryId, int count, String specification) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
        this.count = count;
        this.specification = specification;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
