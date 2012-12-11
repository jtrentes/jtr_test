package big.services;

import java.util.List;
import big.repositories.MyClass162Repository;
import big.domain.MyClass162;
import big.repositories.criteria.MyClass162Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass162Service")
@Transactional(readOnly = true)
public class MyClass162ServiceImpl implements MyClass162Service
{

	
	@Autowired
	private MyClass162Repository myClass162Repository;
    

	
	public List<MyClass162> findAll () 
	{
		return this.myClass162Repository.findAll();	
	}

	
	public List<MyClass162> findByCriteria (MyClass162Criteria criteria) 
	{
		return this.myClass162Repository.findByCriteria (criteria);	
	}

	
	public MyClass162 findById (Long id) 
	{
		return this.myClass162Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass162 save (MyClass162 myclass162) 
	{
		return this.myClass162Repository.save (myclass162);	
	}


}
