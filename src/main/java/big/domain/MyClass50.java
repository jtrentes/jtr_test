package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;


@Entity
public class MyClass50
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass139 myclass139;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass139 getMyclass139 () 
	{
		return this.myclass139;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass139 (MyClass139 myMyclass139) 
	{
		this.myclass139 = myMyclass139;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass139 () 
	{
		this.myclass139 = null;	
	}


}
