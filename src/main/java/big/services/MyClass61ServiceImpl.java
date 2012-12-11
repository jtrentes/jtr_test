package big.services;

import big.domain.MyClass61;
import big.repositories.MyClass61Repository;
import big.repositories.criteria.MyClass61Criteria;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass61Service")
@Transactional(readOnly = true)
public class MyClass61ServiceImpl implements MyClass61Service
{

	
	@Autowired
	private MyClass61Repository myClass61Repository;
    

	
	public List<MyClass61> findAll () 
	{
		return this.myClass61Repository.findAll();	
	}

	
	public List<MyClass61> findByCriteria (MyClass61Criteria criteria) 
	{
		return this.myClass61Repository.findByCriteria (criteria);	
	}

	
	public MyClass61 findById (Long id) 
	{
		return this.myClass61Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass61 save (MyClass61 myclass61) 
	{
		return this.myClass61Repository.save (myclass61);	
	}


}
