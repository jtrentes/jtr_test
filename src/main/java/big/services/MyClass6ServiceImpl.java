package big.services;

import big.repositories.criteria.MyClass6Criteria;
import big.repositories.MyClass6Repository;
import java.util.List;
import big.domain.MyClass6;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass6Service")
@Transactional(readOnly = true)
public class MyClass6ServiceImpl implements MyClass6Service
{

	
	@Autowired
	private MyClass6Repository myClass6Repository;
    

	
	public List<MyClass6> findAll () 
	{
		return this.myClass6Repository.findAll();	
	}

	
	public List<MyClass6> findByCriteria (MyClass6Criteria criteria) 
	{
		return this.myClass6Repository.findByCriteria (criteria);	
	}

	
	public MyClass6 findById (Long id) 
	{
		return this.myClass6Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass6 save (MyClass6 myclass6) 
	{
		return this.myClass6Repository.save (myclass6);	
	}


}
