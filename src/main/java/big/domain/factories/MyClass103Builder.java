package big.domain.factories;

import big.domain.MyClass103;



public class MyClass103Builder
{

	
	
	private MyClass103 myclass103;
    

	
	public MyClass103 build () 
	{
		return myclass103;	
	}

	
	public MyClass103Builder id (Long id) 
	{
		myclass103.setId (id);
		return this;	
	}

	
	public MyClass103Builder initMyClass103 () 
	{
		myclass103 = new MyClass103();
		return this;	
	}


}
