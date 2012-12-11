package big.services;

import java.util.List;
import big.repositories.criteria.MyClass114Criteria;
import big.domain.MyClass114;
import big.repositories.MyClass114Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass114Service")
@Transactional(readOnly = true)
public class MyClass114ServiceImpl implements MyClass114Service
{

	
	@Autowired
	private MyClass114Repository myClass114Repository;
    

	
	public List<MyClass114> findAll () 
	{
		return this.myClass114Repository.findAll();	
	}

	
	public List<MyClass114> findByCriteria (MyClass114Criteria criteria) 
	{
		return this.myClass114Repository.findByCriteria (criteria);	
	}

	
	public MyClass114 findById (Long id) 
	{
		return this.myClass114Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass114 save (MyClass114 myclass114) 
	{
		return this.myClass114Repository.save (myclass114);	
	}


}
