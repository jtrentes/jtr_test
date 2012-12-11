package big.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;


@Entity
public class MyClass102
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass111 myclass111;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass111 getMyclass111 () 
	{
		return this.myclass111;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass111 (MyClass111 myMyclass111) 
	{
		this.myclass111 = myMyclass111;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass111 () 
	{
		this.myclass111 = null;	
	}


}
