package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MyClass63
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass8 myclass8;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass8 getMyclass8 () 
	{
		return this.myclass8;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass8 (MyClass8 myMyclass8) 
	{
		this.myclass8 = myMyclass8;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass8 () 
	{
		this.myclass8 = null;	
	}


}
