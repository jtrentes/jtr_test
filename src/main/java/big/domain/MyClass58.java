package big.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass58
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass131 myclass131;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass131 getMyclass131 () 
	{
		return this.myclass131;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass131 (MyClass131 myMyclass131) 
	{
		this.myclass131 = myMyclass131;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass131 () 
	{
		this.myclass131 = null;	
	}


}
