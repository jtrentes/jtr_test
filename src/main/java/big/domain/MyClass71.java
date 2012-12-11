package big.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;


@Entity
public class MyClass71
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass78 myclass78;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass78 getMyclass78 () 
	{
		return this.myclass78;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass78 (MyClass78 myMyclass78) 
	{
		this.myclass78 = myMyclass78;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass78 () 
	{
		this.myclass78 = null;	
	}


}
