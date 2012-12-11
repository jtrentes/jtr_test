package big.services;

import big.repositories.MyClass21Repository;
import big.repositories.criteria.MyClass21Criteria;
import java.util.List;
import big.domain.MyClass21;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass21Service")
@Transactional(readOnly = true)
public class MyClass21ServiceImpl implements MyClass21Service
{

	
	@Autowired
	private MyClass21Repository myClass21Repository;
    

	
	public List<MyClass21> findAll () 
	{
		return this.myClass21Repository.findAll();	
	}

	
	public List<MyClass21> findByCriteria (MyClass21Criteria criteria) 
	{
		return this.myClass21Repository.findByCriteria (criteria);	
	}

	
	public MyClass21 findById (Long id) 
	{
		return this.myClass21Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass21 save (MyClass21 myclass21) 
	{
		return this.myClass21Repository.save (myclass21);	
	}


}
