package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MyClass35
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass51 myclass51;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass51 getMyclass51 () 
	{
		return this.myclass51;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass51 (MyClass51 myMyclass51) 
	{
		this.myclass51 = myMyclass51;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass51 () 
	{
		this.myclass51 = null;	
	}


}
