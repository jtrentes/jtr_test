package big.services;

import big.repositories.MyClass74Repository;
import big.repositories.criteria.MyClass74Criteria;
import java.util.List;
import big.domain.MyClass74;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass74Service")
@Transactional(readOnly = true)
public class MyClass74ServiceImpl implements MyClass74Service
{

	
	@Autowired
	private MyClass74Repository myClass74Repository;
    

	
	public List<MyClass74> findAll () 
	{
		return this.myClass74Repository.findAll();	
	}

	
	public List<MyClass74> findByCriteria (MyClass74Criteria criteria) 
	{
		return this.myClass74Repository.findByCriteria (criteria);	
	}

	
	public MyClass74 findById (Long id) 
	{
		return this.myClass74Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass74 save (MyClass74 myclass74) 
	{
		return this.myClass74Repository.save (myclass74);	
	}


}
