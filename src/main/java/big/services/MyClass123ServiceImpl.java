package big.services;

import big.repositories.MyClass123Repository;
import java.util.List;
import big.repositories.criteria.MyClass123Criteria;
import big.domain.MyClass123;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass123Service")
@Transactional(readOnly = true)
public class MyClass123ServiceImpl implements MyClass123Service
{

	
	@Autowired
	private MyClass123Repository myClass123Repository;
    

	
	public List<MyClass123> findAll () 
	{
		return this.myClass123Repository.findAll();	
	}

	
	public List<MyClass123> findByCriteria (MyClass123Criteria criteria) 
	{
		return this.myClass123Repository.findByCriteria (criteria);	
	}

	
	public MyClass123 findById (Long id) 
	{
		return this.myClass123Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass123 save (MyClass123 myclass123) 
	{
		return this.myClass123Repository.save (myclass123);	
	}


}
