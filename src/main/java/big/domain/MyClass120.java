package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;


@Entity
public class MyClass120
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass30 myclass30;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass30 getMyclass30 () 
	{
		return this.myclass30;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass30 (MyClass30 myMyclass30) 
	{
		this.myclass30 = myMyclass30;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass30 () 
	{
		this.myclass30 = null;	
	}


}
