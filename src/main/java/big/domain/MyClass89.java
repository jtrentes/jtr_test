package big.domain;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;


@Entity
public class MyClass89
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass124 myclass124;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass124 getMyclass124 () 
	{
		return this.myclass124;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass124 (MyClass124 myMyclass124) 
	{
		this.myclass124 = myMyclass124;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass124 () 
	{
		this.myclass124 = null;	
	}


}
