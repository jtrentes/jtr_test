package big.domain;

import javax.persistence.Entity;
import javax.persistence.Column;


@Entity
public class MyClass4 extends MyClass2
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	
	private String attribute2;
	
	
	private String attribute3;
    

	
	public String getAttribute () 
	{
		return this.attribute;	
	}

	
	public String getAttribute2 () 
	{
		return this.attribute2;	
	}

	
	public String getAttribute3 () 
	{
		return this.attribute3;	
	}

	
	public void operation () 
	{
		// TODO : to implement
			
	}

	
	public void setAttribute (String myAttribute) 
	{
		this.attribute = myAttribute;	
	}

	
	public void setAttribute2 (String myAttribute2) 
	{
		this.attribute2 = myAttribute2;	
	}

	
	public void setAttribute3 (String myAttribute3) 
	{
		this.attribute3 = myAttribute3;	
	}

	
	public void unsetAttribute () 
	{
		this.attribute = null;	
	}

	
	public void unsetAttribute2 () 
	{
		this.attribute2 = null;	
	}

	
	public void unsetAttribute3 () 
	{
		this.attribute3 = null;	
	}


}
