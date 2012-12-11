package big.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass140
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass97 myclass97;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass97 getMyclass97 () 
	{
		return this.myclass97;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass97 (MyClass97 myMyclass97) 
	{
		this.myclass97 = myMyclass97;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass97 () 
	{
		this.myclass97 = null;	
	}


}
