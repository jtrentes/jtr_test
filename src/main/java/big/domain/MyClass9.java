package big.domain;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;


@Entity
public class MyClass9
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass81 myclass81;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass81 getMyclass81 () 
	{
		return this.myclass81;	
	}

	
	public void setAttribute (String myAttribute) 
	{
		this.attribute = myAttribute;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass81 (MyClass81 myMyclass81) 
	{
		this.myclass81 = myMyclass81;	
	}

	
	public void unsetAttribute () 
	{
		this.attribute = null;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass81 () 
	{
		this.myclass81 = null;	
	}


}
