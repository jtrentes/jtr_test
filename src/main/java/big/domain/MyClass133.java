package big.domain;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class MyClass133
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass5 myclass5;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass5 getMyclass5 () 
	{
		return this.myclass5;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass5 (MyClass5 myMyclass5) 
	{
		this.myclass5 = myMyclass5;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass5 () 
	{
		this.myclass5 = null;	
	}


}
