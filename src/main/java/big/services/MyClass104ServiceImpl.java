package big.services;

import big.repositories.MyClass104Repository;
import big.domain.MyClass104;
import java.util.List;
import big.repositories.criteria.MyClass104Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass104Service")
@Transactional(readOnly = true)
public class MyClass104ServiceImpl implements MyClass104Service
{

	
	@Autowired
	private MyClass104Repository myClass104Repository;
    

	
	public List<MyClass104> findAll () 
	{
		return this.myClass104Repository.findAll();	
	}

	
	public List<MyClass104> findByCriteria (MyClass104Criteria criteria) 
	{
		return this.myClass104Repository.findByCriteria (criteria);	
	}

	
	public MyClass104 findById (Long id) 
	{
		return this.myClass104Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass104 save (MyClass104 myclass104) 
	{
		return this.myClass104Repository.save (myclass104);	
	}


}
