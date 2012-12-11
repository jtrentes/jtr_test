package big.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass3
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass2 myclass2;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass2 getMyclass2 () 
	{
		return this.myclass2;	
	}

	
	public void operation () 
	{
		// TODO : to implement
			
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass2 (MyClass2 myMyclass2) 
	{
		this.myclass2 = myMyclass2;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass2 () 
	{
		this.myclass2 = null;	
	}


}
