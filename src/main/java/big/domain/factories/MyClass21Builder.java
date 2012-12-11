package big.domain.factories;

import big.domain.MyClass21;



public class MyClass21Builder
{

	
	
	private MyClass21 myclass21;
    

	
	public MyClass21Builder attribute (String attribute) 
	{
		myclass21.setAttribute (attribute);
		return this;	
	}

	
	public MyClass21Builder attribute2 (String attribute2) 
	{
		myclass21.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass21Builder attribute3 (String attribute3) 
	{
		myclass21.setAttribute3 (attribute3);
		return this;	
	}

	
	public MyClass21Builder attribute4 (String attribute4) 
	{
		myclass21.setAttribute4 (attribute4);
		return this;	
	}

	
	public MyClass21Builder attribute5 (String attribute5) 
	{
		myclass21.setAttribute5 (attribute5);
		return this;	
	}

	
	public MyClass21Builder attribute6 (String attribute6) 
	{
		myclass21.setAttribute6 (attribute6);
		return this;	
	}

	
	public MyClass21Builder attribute7 (String attribute7) 
	{
		myclass21.setAttribute7 (attribute7);
		return this;	
	}

	
	public MyClass21 build () 
	{
		return myclass21;	
	}

	
	public MyClass21Builder id (Long id) 
	{
		myclass21.setId (id);
		return this;	
	}

	
	public MyClass21Builder initMyClass21 () 
	{
		myclass21 = new MyClass21();
		return this;	
	}


}
