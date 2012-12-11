package big.services;

import big.repositories.MyClass12Repository;
import big.domain.MyClass12;
import big.repositories.criteria.MyClass12Criteria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass12Service")
@Transactional(readOnly = true)
public class MyClass12ServiceImpl implements MyClass12Service
{

	
	@Autowired
	private MyClass12Repository myClass12Repository;
    

	
	public List<MyClass12> findAll () 
	{
		return this.myClass12Repository.findAll();	
	}

	
	public List<MyClass12> findByCriteria (MyClass12Criteria criteria) 
	{
		return this.myClass12Repository.findByCriteria (criteria);	
	}

	
	public MyClass12 findById (Long id) 
	{
		return this.myClass12Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass12 save (MyClass12 myclass12) 
	{
		return this.myClass12Repository.save (myclass12);	
	}


}
