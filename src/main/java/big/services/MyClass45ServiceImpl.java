package big.services;

import big.domain.MyClass45;
import java.util.List;
import big.repositories.MyClass45Repository;
import big.repositories.criteria.MyClass45Criteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass45Service")
@Transactional(readOnly = true)
public class MyClass45ServiceImpl implements MyClass45Service
{

	
	@Autowired
	private MyClass45Repository myClass45Repository;
    

	
	public List<MyClass45> findAll () 
	{
		return this.myClass45Repository.findAll();	
	}

	
	public List<MyClass45> findByCriteria (MyClass45Criteria criteria) 
	{
		return this.myClass45Repository.findByCriteria (criteria);	
	}

	
	public MyClass45 findById (Long id) 
	{
		return this.myClass45Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass45 save (MyClass45 myclass45) 
	{
		return this.myClass45Repository.save (myclass45);	
	}


}
