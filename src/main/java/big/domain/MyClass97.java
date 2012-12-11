package big.domain;

import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass97
{

	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass133 myclass133;
    

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass133 getMyclass133 () 
	{
		return this.myclass133;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass133 (MyClass133 myMyclass133) 
	{
		this.myclass133 = myMyclass133;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass133 () 
	{
		this.myclass133 = null;	
	}


}
