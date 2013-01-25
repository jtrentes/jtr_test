package 123456879dsqfsd.domain;

//Start of user code Import bloc for Class MyClass2

//End of user code



public class MyClass2
{
	
	
	protected MyClass myclass;

	//Start of user code Attribute bloc for Class MyClass2

	//End of user code

	public MyClass2(){
		//Start of user code standard constructor bloc for Class MyClass2

		//End of user code
	}

	//Start of user code Other constructor bloc for Class MyClass2

	//End of user code

	
	
	public void basicSetMyclass(MyClass myMyclass) {
		if (this.myclass != myMyclass) {
			if (myMyclass != null){
				if (this.myclass != myMyclass) {
					MyClass oldmyclass = this.myclass;
					this.myclass = myMyclass;
					if (oldmyclass != null)
						oldmyclass.unsetMyclass2();
				}
			}
		}	
	}
	
	
	
	public MyClass getMyclass() {
		return this.myclass;	
	}
	
	
	
	public void setMyclass(MyClass myMyclass) {
		this.basicSetMyclass(myMyclass);
		myMyclass.basicSetMyclass2(this);
			
	}
	
	
	
	public void unsetMyclass() {
		if (this.myclass == null)
			return;
		MyClass oldmyclass = this.myclass;
		this.myclass = null;
		oldmyclass.unsetMyclass2();	
	}
	
	//Start of user code Method bloc for Class MyClass2

	//End of user code

}

