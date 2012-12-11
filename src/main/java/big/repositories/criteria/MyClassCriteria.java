package big.repositories.criteria;

import big.domain.MyClass2;



public class MyClassCriteria
{

	
	
	private String attribute;
	
	
	private String attribute2;
	
	
	private Long id;
	
	
	private MyClass2 myclass2;
    

	
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

	
	public MyClass2 getMyclass2 () 
	{
		return this.myclass2;	
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

	
	public void setMyclass2 (MyClass2 myMyclass2) 
	{
		this.myclass2 = myMyclass2;	
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

	
	public void unsetMyclass2 () 
	{
		this.myclass2 = null;	
	}


}
