package big.domain.factories;

import big.domain.MyClass76;



public class MyClass76Builder
{

	
	
	private MyClass76 myclass76;
    

	
	public MyClass76Builder attribute (String attribute) 
	{
		myclass76.setAttribute (attribute);
		return this;	
	}

	
	public MyClass76Builder attribute2 (String attribute2) 
	{
		myclass76.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass76Builder attribute3 (String attribute3) 
	{
		myclass76.setAttribute3 (attribute3);
		return this;	
	}

	
	public MyClass76Builder attribute4 (String attribute4) 
	{
		myclass76.setAttribute4 (attribute4);
		return this;	
	}

	
	public MyClass76Builder attribute5 (String attribute5) 
	{
		myclass76.setAttribute5 (attribute5);
		return this;	
	}

	
	public MyClass76Builder attribute6 (String attribute6) 
	{
		myclass76.setAttribute6 (attribute6);
		return this;	
	}

	
	public MyClass76Builder attribute7 (String attribute7) 
	{
		myclass76.setAttribute7 (attribute7);
		return this;	
	}

	
	public MyClass76 build () 
	{
		return myclass76;	
	}

	
	public MyClass76Builder id (Long id) 
	{
		myclass76.setId (id);
		return this;	
	}

	
	public MyClass76Builder initMyClass76 () 
	{
		myclass76 = new MyClass76();
		return this;	
	}


}
