package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class MyClass8
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass7 myclass7;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass7 getMyclass7 () 
	{
		return this.myclass7;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass7 (MyClass7 myMyclass7) 
	{
		this.myclass7 = myMyclass7;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass7 () 
	{
		this.myclass7 = null;	
	}


}
