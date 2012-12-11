package big.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MyClass78
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass74 myclass74;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass74 getMyclass74 () 
	{
		return this.myclass74;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass74 (MyClass74 myMyclass74) 
	{
		this.myclass74 = myMyclass74;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass74 () 
	{
		this.myclass74 = null;	
	}


}
