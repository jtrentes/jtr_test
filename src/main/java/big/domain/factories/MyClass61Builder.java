package big.domain.factories;

import big.domain.MyClass61;



public class MyClass61Builder
{

	
	
	private MyClass61 myclass61;
    

	
	public MyClass61 build () 
	{
		return myclass61;	
	}

	
	public MyClass61Builder id (Long id) 
	{
		myclass61.setId (id);
		return this;	
	}

	
	public MyClass61Builder initMyClass61 () 
	{
		myclass61 = new MyClass61();
		return this;	
	}


}
