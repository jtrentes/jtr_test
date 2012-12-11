package big.services;

import big.repositories.criteria.MyClass46Criteria;
import big.repositories.MyClass46Repository;
import java.util.List;
import big.domain.MyClass46;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass46Service")
@Transactional(readOnly = true)
public class MyClass46ServiceImpl implements MyClass46Service
{

	
	@Autowired
	private MyClass46Repository myClass46Repository;
    

	
	public List<MyClass46> findAll () 
	{
		return this.myClass46Repository.findAll();	
	}

	
	public List<MyClass46> findByCriteria (MyClass46Criteria criteria) 
	{
		return this.myClass46Repository.findByCriteria (criteria);	
	}

	
	public MyClass46 findById (Long id) 
	{
		return this.myClass46Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass46 save (MyClass46 myclass46) 
	{
		return this.myClass46Repository.save (myclass46);	
	}


}
