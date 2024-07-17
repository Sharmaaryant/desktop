package in.co.common;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseDTO {

    @Id
    @GeneratedValue(generator = "ncsPk")
    @GenericGenerator(name = "ncsPk", strategy = "native")
    @Column(name = "ID", unique = true, nullable = false)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
