package big.services;

import big.repositories.MyClass36Repository;
import java.util.List;
import big.domain.MyClass36;
import big.repositories.criteria.MyClass36Criteria;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass36Service")
@Transactional(readOnly = true)
public class MyClass36ServiceImpl implements MyClass36Service
{

	
	@Autowired
	private MyClass36Repository myClass36Repository;
    

	
	public List<MyClass36> findAll () 
	{
		return this.myClass36Repository.findAll();	
	}

	
	public List<MyClass36> findByCriteria (MyClass36Criteria criteria) 
	{
		return this.myClass36Repository.findByCriteria (criteria);	
	}

	
	public MyClass36 findById (Long id) 
	{
		return this.myClass36Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass36 save (MyClass36 myclass36) 
	{
		return this.myClass36Repository.save (myclass36);	
	}


}
