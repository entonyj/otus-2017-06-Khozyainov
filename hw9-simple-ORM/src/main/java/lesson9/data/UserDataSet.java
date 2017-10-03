package lesson9.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by entony on 28.09.2017.
 */
@Entity
@Table(name = "user")
public class UserDataSet extends DataSet {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public UserDataSet(){
        this.setId(-1);
        this.name = "no name";
        this.age = -1;
    }

    public UserDataSet(String name, int age){
        this.setId(-1);
        this.name = name;
        this.age = age;
    }

    public UserDataSet(Long id, String name, Integer age){
        this.setId(id);
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserDataSet (id: " + getId() + ", name: " + getName() + ", age: " + getAge() + ")";
    }
}
