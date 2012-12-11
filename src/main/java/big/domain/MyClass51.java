package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class MyClass51
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass17 myclass17;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass17 getMyclass17 () 
	{
		return this.myclass17;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass17 (MyClass17 myMyclass17) 
	{
		this.myclass17 = myMyclass17;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass17 () 
	{
		this.myclass17 = null;	
	}


}
