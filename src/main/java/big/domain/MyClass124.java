package big.domain;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;


@Entity
public class MyClass124
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass140 myclass140;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass140 getMyclass140 () 
	{
		return this.myclass140;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass140 (MyClass140 myMyclass140) 
	{
		this.myclass140 = myMyclass140;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass140 () 
	{
		this.myclass140 = null;	
	}


}
