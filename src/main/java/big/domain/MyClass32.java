package big.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;


@Entity
public class MyClass32
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass62 myclass62;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass62 getMyclass62 () 
	{
		return this.myclass62;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass62 (MyClass62 myMyclass62) 
	{
		this.myclass62 = myMyclass62;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass62 () 
	{
		this.myclass62 = null;	
	}


}
