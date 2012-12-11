package big.domain.factories;

import big.domain.MyClass52;



public class MyClass52Builder
{

	
	
	private MyClass52 myclass52;
    

	
	public MyClass52 build () 
	{
		return myclass52;	
	}

	
	public MyClass52Builder id (Long id) 
	{
		myclass52.setId (id);
		return this;	
	}

	
	public MyClass52Builder initMyClass52 () 
	{
		myclass52 = new MyClass52();
		return this;	
	}


}
