package big.domain.factories;

import big.domain.MyClass140;



public class MyClass140Builder
{

	
	
	private MyClass140 myclass140;
    

	
	public MyClass140 build () 
	{
		return myclass140;	
	}

	
	public MyClass140Builder id (Long id) 
	{
		myclass140.setId (id);
		return this;	
	}

	
	public MyClass140Builder initMyClass140 () 
	{
		myclass140 = new MyClass140();
		return this;	
	}


}
