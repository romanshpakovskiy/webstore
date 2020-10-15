package by.wb.webstore.bean;

import java.io.Serializable;
import java.util.Objects;

public class Producer implements Serializable {

    private static final long serialVersionUID = -3873913226545402394L;

    int id;
    String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return id == producer.id &&
                Objects.equals(name, producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
