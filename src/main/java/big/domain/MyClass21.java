package big.domain;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;


@Entity
public class MyClass21
{

	
	@Column(name = "ATTRIBUTECOLUMN")
	private String attribute;
	
	
	private String attribute2;
	
	
	private String attribute3;
	
	
	private String attribute4;
	
	
	private String attribute5;
	
	
	private String attribute6;
	
	
	private String attribute7;
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
    

	
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

	
	public String getAttribute4 () 
	{
		return this.attribute4;	
	}

	
	public String getAttribute5 () 
	{
		return this.attribute5;	
	}

	
	public String getAttribute6 () 
	{
		return this.attribute6;	
	}

	
	public String getAttribute7 () 
	{
		return this.attribute7;	
	}

	
	public Long getId () 
	{
		return this.id;	
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

	
	public void setAttribute4 (String myAttribute4) 
	{
		this.attribute4 = myAttribute4;	
	}

	
	public void setAttribute5 (String myAttribute5) 
	{
		this.attribute5 = myAttribute5;	
	}

	
	public void setAttribute6 (String myAttribute6) 
	{
		this.attribute6 = myAttribute6;	
	}

	
	public void setAttribute7 (String myAttribute7) 
	{
		this.attribute7 = myAttribute7;	
	}

	
	public void setId (Long myId) 
	{
		this.id = myId;	
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

	
	public void unsetAttribute4 () 
	{
		this.attribute4 = null;	
	}

	
	public void unsetAttribute5 () 
	{
		this.attribute5 = null;	
	}

	
	public void unsetAttribute6 () 
	{
		this.attribute6 = null;	
	}

	
	public void unsetAttribute7 () 
	{
		this.attribute7 = null;	
	}

	
	public void unsetId () 
	{
		this.id = null;	
	}


}
