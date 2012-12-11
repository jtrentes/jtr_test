package big.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass56
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}


}
