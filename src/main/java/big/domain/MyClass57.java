package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class MyClass57
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass37 myclass37;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass37 getMyclass37 () 
	{
		return this.myclass37;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass37 (MyClass37 myMyclass37) 
	{
		this.myclass37 = myMyclass37;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass37 () 
	{
		this.myclass37 = null;	
	}


}
