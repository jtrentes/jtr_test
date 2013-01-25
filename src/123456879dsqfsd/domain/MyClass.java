package 123456879dsqfsd.domain;

//Start of user code Import bloc for Class MyClass

//End of user code



public class MyClass extends MyClass3
{
	
	
	protected MyClass2 myclass2;

	//Start of user code Attribute bloc for Class MyClass

	//End of user code

	public MyClass(){
		//Start of user code standard constructor bloc for Class MyClass

		//End of user code
	}

	//Start of user code Other constructor bloc for Class MyClass

	//End of user code

	
	
	public void basicSetMyclass2(MyClass2 myMyclass2) {
		if (this.myclass2 != myMyclass2) {
			if (myMyclass2 != null){
				if (this.myclass2 != myMyclass2) {
					MyClass2 oldmyclass2 = this.myclass2;
					this.myclass2 = myMyclass2;
					if (oldmyclass2 != null)
						oldmyclass2.unsetMyclass();
				}
			}
		}	
	}
	
	
	
	public MyClass2 getMyclass2() {
		return this.myclass2;	
	}
	
	
	
	public void setMyclass2(MyClass2 myMyclass2) {
		this.basicSetMyclass2(myMyclass2);
		myMyclass2.basicSetMyclass(this);
			
	}
	
	
	
	public void unsetMyclass2() {
		if (this.myclass2 == null)
			return;
		MyClass2 oldmyclass2 = this.myclass2;
		this.myclass2 = null;
		oldmyclass2.unsetMyclass();	
	}
	
	//Start of user code Method bloc for Class MyClass

	//End of user code

}

