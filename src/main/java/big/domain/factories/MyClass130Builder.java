package big.domain.factories;

import big.domain.MyClass130;



public class MyClass130Builder
{

	
	
	private MyClass130 myclass130;
    

	
	public MyClass130 build () 
	{
		return myclass130;	
	}

	
	public MyClass130Builder id (Long id) 
	{
		myclass130.setId (id);
		return this;	
	}

	
	public MyClass130Builder initMyClass130 () 
	{
		myclass130 = new MyClass130();
		return this;	
	}


}
