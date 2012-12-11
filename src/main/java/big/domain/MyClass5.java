package big.domain;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass5
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass9 myclass9;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass9 getMyclass9 () 
	{
		return this.myclass9;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass9 (MyClass9 myMyclass9) 
	{
		this.myclass9 = myMyclass9;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass9 () 
	{
		this.myclass9 = null;	
	}


}
