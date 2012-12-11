package big.domain.factories;

import big.domain.MyClass141;



public class MyClass141Builder
{

	
	
	private MyClass141 myclass141;
    

	
	public MyClass141 build () 
	{
		return myclass141;	
	}

	
	public MyClass141Builder id (Long id) 
	{
		myclass141.setId (id);
		return this;	
	}

	
	public MyClass141Builder initMyClass141 () 
	{
		myclass141 = new MyClass141();
		return this;	
	}


}
