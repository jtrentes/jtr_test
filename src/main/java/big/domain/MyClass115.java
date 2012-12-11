package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class MyClass115
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass50 myclass50;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass50 getMyclass50 () 
	{
		return this.myclass50;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass50 (MyClass50 myMyclass50) 
	{
		this.myclass50 = myMyclass50;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass50 () 
	{
		this.myclass50 = null;	
	}


}
