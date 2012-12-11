package big.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass18
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass153 myclass153;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass153 getMyclass153 () 
	{
		return this.myclass153;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass153 (MyClass153 myMyclass153) 
	{
		this.myclass153 = myMyclass153;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass153 () 
	{
		this.myclass153 = null;	
	}


}
