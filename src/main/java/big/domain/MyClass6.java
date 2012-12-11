package big.domain;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;


@Entity
public class MyClass6
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass12 myclass12;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass12 getMyclass12 () 
	{
		return this.myclass12;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass12 (MyClass12 myMyclass12) 
	{
		this.myclass12 = myMyclass12;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass12 () 
	{
		this.myclass12 = null;	
	}


}
