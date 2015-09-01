package entities;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

/**
 * Created by bohdan on 27.08.15.
 */
@Entity(name = "PUPIL")
@FilterDef(name = "levelFilter", parameters = @ParamDef(name="levelParam", type="string"))
@Filter(name = "levelFilter", condition = ":levelParam like level")
public class Pupil {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME_PUPIL")
    private String name;
    @Column(name = "LAST_NAME_PUPIL")
    private String last;
    @Column(name = "GROUP_NAME")
    private String group;
    @Column(name = "LEVEL")
    private String level;

    @Column(name = "ADDRESS")
    private String address;
    /*@Embedded
    private Address address;*/

    public Pupil() {
    }

    public Pupil(String name, String last, String group, String level, String address) {
        this.name = name;
        this.last = last;
        this.group = group;
        this.level = level;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /*public Pupil(String name, String last, String group, String level, Address address) {
        this.name = name;
        this.last = last;
        this.group = group;
        this.level = level;
        this.address = address;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "address='" + address + '\'' +
                ", level='" + level + '\'' +
                ", group='" + group + '\'' +
                ", last='" + last + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    /*public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }*/
}
