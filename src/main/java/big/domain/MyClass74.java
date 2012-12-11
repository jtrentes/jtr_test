package big.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass74
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass117 myclass117;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass117 getMyclass117 () 
	{
		return this.myclass117;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass117 (MyClass117 myMyclass117) 
	{
		this.myclass117 = myMyclass117;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass117 () 
	{
		this.myclass117 = null;	
	}


}
