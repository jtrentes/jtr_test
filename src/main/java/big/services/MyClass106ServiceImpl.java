package big.services;

import big.domain.MyClass106;
import big.repositories.MyClass106Repository;
import big.repositories.criteria.MyClass106Criteria;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass106Service")
@Transactional(readOnly = true)
public class MyClass106ServiceImpl implements MyClass106Service
{

	
	@Autowired
	private MyClass106Repository myClass106Repository;
    

	
	public List<MyClass106> findAll () 
	{
		return this.myClass106Repository.findAll();	
	}

	
	public List<MyClass106> findByCriteria (MyClass106Criteria criteria) 
	{
		return this.myClass106Repository.findByCriteria (criteria);	
	}

	
	public MyClass106 findById (Long id) 
	{
		return this.myClass106Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass106 save (MyClass106 myclass106) 
	{
		return this.myClass106Repository.save (myclass106);	
	}


}
