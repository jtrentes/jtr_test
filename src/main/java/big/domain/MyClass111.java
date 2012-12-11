package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MyClass111
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass23 myclass23;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass23 getMyclass23 () 
	{
		return this.myclass23;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass23 (MyClass23 myMyclass23) 
	{
		this.myclass23 = myMyclass23;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass23 () 
	{
		this.myclass23 = null;	
	}


}
