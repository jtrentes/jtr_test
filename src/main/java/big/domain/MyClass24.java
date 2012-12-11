package big.domain;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class MyClass24
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass6 myclass6;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass6 getMyclass6 () 
	{
		return this.myclass6;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass6 (MyClass6 myMyclass6) 
	{
		this.myclass6 = myMyclass6;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass6 () 
	{
		this.myclass6 = null;	
	}


}
