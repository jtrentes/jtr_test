package big.domain.factories;

import big.domain.MyClass60;



public class MyClass60Builder
{

	
	
	private MyClass60 myclass60;
    

	
	public MyClass60 build () 
	{
		return myclass60;	
	}

	
	public MyClass60Builder id (Long id) 
	{
		myclass60.setId (id);
		return this;	
	}

	
	public MyClass60Builder initMyClass60 () 
	{
		myclass60 = new MyClass60();
		return this;	
	}


}
