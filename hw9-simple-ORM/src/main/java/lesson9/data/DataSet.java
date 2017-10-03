package lesson9.data;

import javax.persistence.*;

/**
 * Created by entony on 28.09.2017.
 */

@MappedSuperclass
@Entity
@Table(name = "user")
public abstract class DataSet {

    @Id
    @Column(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
