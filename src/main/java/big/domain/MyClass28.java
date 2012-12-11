package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class MyClass28
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass115 myclass115;
	
	@ManyToOne
	private MyClass25 myclass25;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass115 getMyclass115 () 
	{
		return this.myclass115;	
	}

	
	public MyClass25 getMyclass25 () 
	{
		return this.myclass25;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass115 (MyClass115 myMyclass115) 
	{
		this.myclass115 = myMyclass115;	
	}

	
	public void setMyclass25 (MyClass25 myMyclass25) 
	{
		this.myclass25 = myMyclass25;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass115 () 
	{
		this.myclass115 = null;	
	}

	
	public void unsetMyclass25 () 
	{
		this.myclass25 = null;	
	}


}
