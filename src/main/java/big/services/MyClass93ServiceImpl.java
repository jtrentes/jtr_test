package big.services;

import java.util.List;
import big.repositories.criteria.MyClass93Criteria;
import big.domain.MyClass93;
import big.repositories.MyClass93Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass93Service")
@Transactional(readOnly = true)
public class MyClass93ServiceImpl implements MyClass93Service
{

	
	@Autowired
	private MyClass93Repository myClass93Repository;
    

	
	public List<MyClass93> findAll () 
	{
		return this.myClass93Repository.findAll();	
	}

	
	public List<MyClass93> findByCriteria (MyClass93Criteria criteria) 
	{
		return this.myClass93Repository.findByCriteria (criteria);	
	}

	
	public MyClass93 findById (Long id) 
	{
		return this.myClass93Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass93 save (MyClass93 myclass93) 
	{
		return this.myClass93Repository.save (myclass93);	
	}


}
