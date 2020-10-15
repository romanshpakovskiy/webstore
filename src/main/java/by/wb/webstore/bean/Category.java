package by.wb.webstore.bean;

import java.io.Serializable;
import java.util.Objects;

public class Category implements Serializable {

    private static final long serialVersionUID = -3947205096666657647L;

    int id;
    String name;
    String specification;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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
        Category category = (Category) o;
        return id == category.id &&
                Objects.equals(name, category.name) &&
                Objects.equals(specification, category.specification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
