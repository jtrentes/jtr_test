package big.domain.factories;

import big.domain.MyClass160;



public class MyClass160Builder
{

	
	
	private MyClass160 myclass160;
    

	
	public MyClass160 build () 
	{
		return myclass160;	
	}

	
	public MyClass160Builder id (Long id) 
	{
		myclass160.setId (id);
		return this;	
	}

	
	public MyClass160Builder initMyClass160 () 
	{
		myclass160 = new MyClass160();
		return this;	
	}


}
