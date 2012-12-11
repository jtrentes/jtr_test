package big.services;

import big.repositories.MyClass84Repository;
import big.domain.MyClass84;
import big.repositories.criteria.MyClass84Criteria;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "myclass84Service")
@Transactional(readOnly = true)
public class MyClass84ServiceImpl implements MyClass84Service
{

	
	@Autowired
	private MyClass84Repository myClass84Repository;
    

	
	public List<MyClass84> findAll () 
	{
		return this.myClass84Repository.findAll();	
	}

	
	public List<MyClass84> findByCriteria (MyClass84Criteria criteria) 
	{
		return this.myClass84Repository.findByCriteria (criteria);	
	}

	
	public MyClass84 findById (Long id) 
	{
		return this.myClass84Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass84 save (MyClass84 myclass84) 
	{
		return this.myClass84Repository.save (myclass84);	
	}


}
