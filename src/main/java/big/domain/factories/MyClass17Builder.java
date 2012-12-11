package big.domain.factories;

import big.domain.MyClass17;



public class MyClass17Builder
{

	
	
	private MyClass17 myclass17;
    

	
	public MyClass17Builder attribute (String attribute) 
	{
		myclass17.setAttribute (attribute);
		return this;	
	}

	
	public MyClass17Builder attribute2 (String attribute2) 
	{
		myclass17.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass17Builder attribute3 (String attribute3) 
	{
		myclass17.setAttribute3 (attribute3);
		return this;	
	}

	
	public MyClass17Builder attribute4 (String attribute4) 
	{
		myclass17.setAttribute4 (attribute4);
		return this;	
	}

	
	public MyClass17Builder attribute5 (String attribute5) 
	{
		myclass17.setAttribute5 (attribute5);
		return this;	
	}

	
	public MyClass17Builder attribute6 (String attribute6) 
	{
		myclass17.setAttribute6 (attribute6);
		return this;	
	}

	
	public MyClass17 build () 
	{
		return myclass17;	
	}

	
	public MyClass17Builder id (Long id) 
	{
		myclass17.setId (id);
		return this;	
	}

	
	public MyClass17Builder initMyClass17 () 
	{
		myclass17 = new MyClass17();
		return this;	
	}


}
