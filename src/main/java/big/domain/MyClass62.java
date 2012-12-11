package big.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class MyClass62
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass35 myclass35;
	
	@ManyToOne
	private MyClass63 myclass63;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass35 getMyclass35 () 
	{
		return this.myclass35;	
	}

	
	public MyClass63 getMyclass63 () 
	{
		return this.myclass63;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass35 (MyClass35 myMyclass35) 
	{
		this.myclass35 = myMyclass35;	
	}

	
	public void setMyclass63 (MyClass63 myMyclass63) 
	{
		this.myclass63 = myMyclass63;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass35 () 
	{
		this.myclass35 = null;	
	}

	
	public void unsetMyclass63 () 
	{
		this.myclass63 = null;	
	}


}
