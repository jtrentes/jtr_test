package big.domain;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class MyClass23
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	
	private String attribute2;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private MyClass28 myclass28;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public String getAttribute2 () 
	{
		return this.attribute2;	
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

	
	public void setAttribute2 (String myAttribute2) 
	{
		this.attribute2 = myAttribute2;	
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

	
	public void unsetAttribute2 () 
	{
		this.attribute2 = null;	
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
