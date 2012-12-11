package big.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass37
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass54 myclass54;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass54 getMyclass54 () 
	{
		return this.myclass54;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass54 (MyClass54 myMyclass54) 
	{
		this.myclass54 = myMyclass54;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass54 () 
	{
		this.myclass54 = null;	
	}


}
