package big.domain.factories;

import big.domain.MyClass2;



public class MyClass2Builder
{

	
	
	private MyClass2 myclass2;
    

	
	public MyClass2Builder attribute (String attribute) 
	{
		myclass2.setAttribute (attribute);
		return this;	
	}

	
	public MyClass2Builder attribute2 (String attribute2) 
	{
		myclass2.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass2Builder attribute3 (String attribute3) 
	{
		myclass2.setAttribute3 (attribute3);
		return this;	
	}

	
	public MyClass2 build () 
	{
		return myclass2;	
	}

	
	public MyClass2Builder id (Long id) 
	{
		myclass2.setId (id);
		return this;	
	}

	
	public MyClass2Builder initMyClass2 () 
	{
		myclass2 = new MyClass2();
		return this;	
	}


}
