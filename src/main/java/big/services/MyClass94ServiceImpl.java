package big.services;

import big.repositories.criteria.MyClass94Criteria;
import big.repositories.MyClass94Repository;
import java.util.List;
import big.domain.MyClass94;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass94Service")
@Transactional(readOnly = true)
public class MyClass94ServiceImpl implements MyClass94Service
{

	
	@Autowired
	private MyClass94Repository myClass94Repository;
    

	
	public List<MyClass94> findAll () 
	{
		return this.myClass94Repository.findAll();	
	}

	
	public List<MyClass94> findByCriteria (MyClass94Criteria criteria) 
	{
		return this.myClass94Repository.findByCriteria (criteria);	
	}

	
	public MyClass94 findById (Long id) 
	{
		return this.myClass94Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass94 save (MyClass94 myclass94) 
	{
		return this.myClass94Repository.save (myclass94);	
	}


}
