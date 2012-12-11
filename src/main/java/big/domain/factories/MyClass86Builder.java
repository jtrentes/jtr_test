package big.domain.factories;

import big.domain.MyClass86;



public class MyClass86Builder
{

	
	
	private MyClass86 myclass86;
    

	
	public MyClass86 build () 
	{
		return myclass86;	
	}

	
	public MyClass86Builder id (Long id) 
	{
		myclass86.setId (id);
		return this;	
	}

	
	public MyClass86Builder initMyClass86 () 
	{
		myclass86 = new MyClass86();
		return this;	
	}


}
