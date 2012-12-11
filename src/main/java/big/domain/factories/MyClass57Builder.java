package big.domain.factories;

import big.domain.MyClass57;



public class MyClass57Builder
{

	
	
	private MyClass57 myclass57;
    

	
	public MyClass57 build () 
	{
		return myclass57;	
	}

	
	public MyClass57Builder id (Long id) 
	{
		myclass57.setId (id);
		return this;	
	}

	
	public MyClass57Builder initMyClass57 () 
	{
		myclass57 = new MyClass57();
		return this;	
	}


}
