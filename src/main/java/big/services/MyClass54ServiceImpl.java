package big.services;

import big.repositories.criteria.MyClass54Criteria;
import java.util.List;
import big.domain.MyClass54;
import big.repositories.MyClass54Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass54Service")
@Transactional(readOnly = true)
public class MyClass54ServiceImpl implements MyClass54Service
{

	
	@Autowired
	private MyClass54Repository myClass54Repository;
    

	
	public List<MyClass54> findAll () 
	{
		return this.myClass54Repository.findAll();	
	}

	
	public List<MyClass54> findByCriteria (MyClass54Criteria criteria) 
	{
		return this.myClass54Repository.findByCriteria (criteria);	
	}

	
	public MyClass54 findById (Long id) 
	{
		return this.myClass54Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass54 save (MyClass54 myclass54) 
	{
		return this.myClass54Repository.save (myclass54);	
	}


}
