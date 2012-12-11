package big.domain;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class MyClass43
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass34 myclass34;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass34 getMyclass34 () 
	{
		return this.myclass34;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass34 (MyClass34 myMyclass34) 
	{
		this.myclass34 = myMyclass34;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass34 () 
	{
		this.myclass34 = null;	
	}


}
