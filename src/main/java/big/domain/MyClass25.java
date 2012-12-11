package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;


@Entity
public class MyClass25
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass57 myclass57;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass57 getMyclass57 () 
	{
		return this.myclass57;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass57 (MyClass57 myMyclass57) 
	{
		this.myclass57 = myMyclass57;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass57 () 
	{
		this.myclass57 = null;	
	}


}
