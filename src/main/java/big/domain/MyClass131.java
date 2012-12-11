package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MyClass131
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass120 myclass120;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass120 getMyclass120 () 
	{
		return this.myclass120;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass120 (MyClass120 myMyclass120) 
	{
		this.myclass120 = myMyclass120;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass120 () 
	{
		this.myclass120 = null;	
	}


}
