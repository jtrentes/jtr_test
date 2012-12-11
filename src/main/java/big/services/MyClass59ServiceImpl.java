package big.services;

import java.util.List;
import big.repositories.MyClass59Repository;
import big.domain.MyClass59;
import big.repositories.criteria.MyClass59Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass59Service")
@Transactional(readOnly = true)
public class MyClass59ServiceImpl implements MyClass59Service
{

	
	@Autowired
	private MyClass59Repository myClass59Repository;
    

	
	public List<MyClass59> findAll () 
	{
		return this.myClass59Repository.findAll();	
	}

	
	public List<MyClass59> findByCriteria (MyClass59Criteria criteria) 
	{
		return this.myClass59Repository.findByCriteria (criteria);	
	}

	
	public MyClass59 findById (Long id) 
	{
		return this.myClass59Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass59 save (MyClass59 myclass59) 
	{
		return this.myClass59Repository.save (myclass59);	
	}


}
