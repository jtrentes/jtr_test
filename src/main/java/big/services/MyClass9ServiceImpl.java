package big.services;

import big.repositories.criteria.MyClass9Criteria;
import java.util.List;
import big.domain.MyClass9;
import big.repositories.MyClass9Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass9Service")
@Transactional(readOnly = true)
public class MyClass9ServiceImpl implements MyClass9Service
{

	
	@Autowired
	private MyClass9Repository myClass9Repository;
    

	
	public List<MyClass9> findAll () 
	{
		return this.myClass9Repository.findAll();	
	}

	
	public List<MyClass9> findByCriteria (MyClass9Criteria criteria) 
	{
		return this.myClass9Repository.findByCriteria (criteria);	
	}

	
	public MyClass9 findById (Long id) 
	{
		return this.myClass9Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass9 save (MyClass9 myclass9) 
	{
		return this.myClass9Repository.save (myclass9);	
	}


}
