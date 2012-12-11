package big.domain.factories;

import big.domain.MyClass106;



public class MyClass106Builder
{

	
	
	private MyClass106 myclass106;
    

	
	public MyClass106 build () 
	{
		return myclass106;	
	}

	
	public MyClass106Builder id (Long id) 
	{
		myclass106.setId (id);
		return this;	
	}

	
	public MyClass106Builder initMyClass106 () 
	{
		myclass106 = new MyClass106();
		return this;	
	}


}
