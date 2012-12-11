package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class MyClass81
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass163 myclass163;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass163 getMyclass163 () 
	{
		return this.myclass163;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass163 (MyClass163 myMyclass163) 
	{
		this.myclass163 = myMyclass163;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass163 () 
	{
		this.myclass163 = null;	
	}


}
