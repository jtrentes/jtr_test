package big.services;

import big.repositories.criteria.MyClass72Criteria;
import java.util.List;
import big.domain.MyClass72;
import big.repositories.MyClass72Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass72Service")
@Transactional(readOnly = true)
public class MyClass72ServiceImpl implements MyClass72Service
{

	
	@Autowired
	private MyClass72Repository myClass72Repository;
    

	
	public List<MyClass72> findAll () 
	{
		return this.myClass72Repository.findAll();	
	}

	
	public List<MyClass72> findByCriteria (MyClass72Criteria criteria) 
	{
		return this.myClass72Repository.findByCriteria (criteria);	
	}

	
	public MyClass72 findById (Long id) 
	{
		return this.myClass72Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass72 save (MyClass72 myclass72) 
	{
		return this.myClass72Repository.save (myclass72);	
	}


}
