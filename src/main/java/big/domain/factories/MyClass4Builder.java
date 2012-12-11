package big.domain.factories;

import big.domain.MyClass4;



public class MyClass4Builder extends MyClass2Builder
{

	
	
	private MyClass4 myclass4;
    

	
	public MyClass4Builder attribute (String attribute) 
	{
		myclass4.setAttribute (attribute);
		return this;	
	}

	
	public MyClass4Builder attribute2 (String attribute2) 
	{
		myclass4.setAttribute2 (attribute2);
		return this;	
	}

	
	public MyClass4Builder attribute3 (String attribute3) 
	{
		myclass4.setAttribute3 (attribute3);
		return this;	
	}

	
	public MyClass4 build () 
	{
		return myclass4;	
	}

	
	public MyClass4Builder initMyClass4 () 
	{
		myclass4 = new MyClass4();
		return this;	
	}


}
