package big.domain;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass163
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass28 myclass28;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public Long getId () 
	{
		return this.id;	
	}

	
	public MyClass28 getMyclass28 () 
	{
		return this.myclass28;	
	}

	
	public void setAttribute (String myAttribute) 
	{
		this.attribute = myAttribute;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
	}

	
	public void setMyclass28 (MyClass28 myMyclass28) 
	{
		this.myclass28 = myMyclass28;	
	}

	
	public void unsetAttribute () 
	{
		this.attribute = null;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}

	
	public void unsetMyclass28 () 
	{
		this.myclass28 = null;	
	}


}
