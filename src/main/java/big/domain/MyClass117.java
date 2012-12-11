package big.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass117
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass58 myclass58;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass58 getMyclass58 () 
	{
		return this.myclass58;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass58 (MyClass58 myMyclass58) 
	{
		this.myclass58 = myMyclass58;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass58 () 
	{
		this.myclass58 = null;	
	}


}
