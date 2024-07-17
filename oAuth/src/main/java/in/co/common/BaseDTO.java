package in.co.common;


import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;


@MappedSuperclass
public abstract class BaseDTO {
  @Id
    @GeneratedValue(generator = "ncsPk")
    @GenericGenerator(name = "ncsPk",strategy = "native")
    @Column(name = "ID" , unique = true,nullable = false)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
