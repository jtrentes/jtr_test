package big.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;


@Entity
public class MyClass155
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass39 myclass39;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass39 getMyclass39 () 
	{
		return this.myclass39;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass39 (MyClass39 myMyclass39) 
	{
		this.myclass39 = myMyclass39;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass39 () 
	{
		this.myclass39 = null;	
	}


}
