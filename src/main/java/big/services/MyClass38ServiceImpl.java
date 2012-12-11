package big.services;

import big.repositories.MyClass38Repository;
import big.repositories.criteria.MyClass38Criteria;
import big.domain.MyClass38;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass38Service")
@Transactional(readOnly = true)
public class MyClass38ServiceImpl implements MyClass38Service
{

	
	@Autowired
	private MyClass38Repository myClass38Repository;
    

	
	public List<MyClass38> findAll () 
	{
		return this.myClass38Repository.findAll();	
	}

	
	public List<MyClass38> findByCriteria (MyClass38Criteria criteria) 
	{
		return this.myClass38Repository.findByCriteria (criteria);	
	}

	
	public MyClass38 findById (Long id) 
	{
		return this.myClass38Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass38 save (MyClass38 myclass38) 
	{
		return this.myClass38Repository.save (myclass38);	
	}


}
