package big.services;

import big.domain.MyClass7;
import java.util.List;
import big.repositories.criteria.MyClass7Criteria;
import big.repositories.MyClass7Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass7Service")
@Transactional(readOnly = true)
public class MyClass7ServiceImpl implements MyClass7Service
{

	
	@Autowired
	private MyClass7Repository myClass7Repository;
    

	
	public List<MyClass7> findAll () 
	{
		return this.myClass7Repository.findAll();	
	}

	
	public List<MyClass7> findByCriteria (MyClass7Criteria criteria) 
	{
		return this.myClass7Repository.findByCriteria (criteria);	
	}

	
	public MyClass7 findById (Long id) 
	{
		return this.myClass7Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass7 save (MyClass7 myclass7) 
	{
		return this.myClass7Repository.save (myclass7);	
	}


}
