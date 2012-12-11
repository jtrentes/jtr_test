package big.services;

import java.util.List;
import big.repositories.criteria.MyClass86Criteria;
import big.domain.MyClass86;
import big.repositories.MyClass86Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass86Service")
@Transactional(readOnly = true)
public class MyClass86ServiceImpl implements MyClass86Service
{

	
	@Autowired
	private MyClass86Repository myClass86Repository;
    

	
	public List<MyClass86> findAll () 
	{
		return this.myClass86Repository.findAll();	
	}

	
	public List<MyClass86> findByCriteria (MyClass86Criteria criteria) 
	{
		return this.myClass86Repository.findByCriteria (criteria);	
	}

	
	public MyClass86 findById (Long id) 
	{
		return this.myClass86Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass86 save (MyClass86 myclass86) 
	{
		return this.myClass86Repository.save (myclass86);	
	}


}
