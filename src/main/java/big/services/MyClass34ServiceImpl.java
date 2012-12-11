package big.services;

import big.domain.MyClass34;
import big.repositories.MyClass34Repository;
import big.repositories.criteria.MyClass34Criteria;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass34Service")
@Transactional(readOnly = true)
public class MyClass34ServiceImpl implements MyClass34Service
{

	
	@Autowired
	private MyClass34Repository myClass34Repository;
    

	
	public List<MyClass34> findAll () 
	{
		return this.myClass34Repository.findAll();	
	}

	
	public List<MyClass34> findByCriteria (MyClass34Criteria criteria) 
	{
		return this.myClass34Repository.findByCriteria (criteria);	
	}

	
	public MyClass34 findById (Long id) 
	{
		return this.myClass34Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass34 save (MyClass34 myclass34) 
	{
		return this.myClass34Repository.save (myclass34);	
	}


}
