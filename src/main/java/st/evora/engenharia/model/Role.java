package st.evora.engenharia.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   
    public Role() {
		super();
	}

	public Role(String string) {
		super();
	}
	private String name;
    public Integer getId() {
        return id;
    }
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
    
}
