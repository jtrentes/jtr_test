package big.domain.factories;

import big.domain.MyClass6;



public class MyClass6Builder
{

	
	
	private MyClass6 myclass6;
    

	
	public MyClass6 build () 
	{
		return myclass6;	
	}

	
	public MyClass6Builder id (Long id) 
	{
		myclass6.setId (id);
		return this;	
	}

	
	public MyClass6Builder initMyClass6 () 
	{
		myclass6 = new MyClass6();
		return this;	
	}


}
