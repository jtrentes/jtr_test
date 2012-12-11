package big.domain.factories;

import big.domain.MyClass7;



public class MyClass7Builder
{

	
	
	private MyClass7 myclass7;
    

	
	public MyClass7Builder attribute (String attribute) 
	{
		myclass7.setAttribute (attribute);
		return this;	
	}

	
	public MyClass7Builder attribute2 (String attribute2) 
	{
		myclass7.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass7Builder attribute3 (String attribute3) 
	{
		myclass7.setAttribute3 (attribute3);
		return this;	
	}

	
	public MyClass7Builder attribute4 (String attribute4) 
	{
		myclass7.setAttribute4 (attribute4);
		return this;	
	}

	
	public MyClass7Builder attribute5 (String attribute5) 
	{
		myclass7.setAttribute5 (attribute5);
		return this;	
	}

	
	public MyClass7Builder attribute6 (String attribute6) 
	{
		myclass7.setAttribute6 (attribute6);
		return this;	
	}

	
	public MyClass7Builder attribute7 (String attribute7) 
	{
		myclass7.setAttribute7 (attribute7);
		return this;	
	}

	
	public MyClass7 build () 
	{
		return myclass7;	
	}

	
	public MyClass7Builder id (Long id) 
	{
		myclass7.setId (id);
		return this;	
	}

	
	public MyClass7Builder initMyClass7 () 
	{
		myclass7 = new MyClass7();
		return this;	
	}


}
