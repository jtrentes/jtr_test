package big.domain;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass30
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass107 myclass107;
	
	@ManyToOne
	private MyClass31 myclass31;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass107 getMyclass107 () 
	{
		return this.myclass107;	
	}

	
	public MyClass31 getMyclass31 () 
	{
		return this.myclass31;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass107 (MyClass107 myMyclass107) 
	{
		this.myclass107 = myMyclass107;	
	}

	
	public void setMyclass31 (MyClass31 myMyclass31) 
	{
		this.myclass31 = myMyclass31;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass107 () 
	{
		this.myclass107 = null;	
	}

	
	public void unsetMyclass31 () 
	{
		this.myclass31 = null;	
	}


}
