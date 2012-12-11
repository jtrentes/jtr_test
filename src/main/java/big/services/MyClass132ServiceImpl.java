package big.services;

import big.domain.MyClass132;
import java.util.List;
import big.repositories.criteria.MyClass132Criteria;
import big.repositories.MyClass132Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass132Service")
@Transactional(readOnly = true)
public class MyClass132ServiceImpl implements MyClass132Service
{

	
	@Autowired
	private MyClass132Repository myClass132Repository;
    

	
	public List<MyClass132> findAll () 
	{
		return this.myClass132Repository.findAll();	
	}

	
	public List<MyClass132> findByCriteria (MyClass132Criteria criteria) 
	{
		return this.myClass132Repository.findByCriteria (criteria);	
	}

	
	public MyClass132 findById (Long id) 
	{
		return this.myClass132Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass132 save (MyClass132 myclass132) 
	{
		return this.myClass132Repository.save (myclass132);	
	}


}
