package big.services;

import java.util.List;
import big.domain.MyClass145;
import big.repositories.MyClass145Repository;
import big.repositories.criteria.MyClass145Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass145Service")
@Transactional(readOnly = true)
public class MyClass145ServiceImpl implements MyClass145Service
{

	
	@Autowired
	private MyClass145Repository myClass145Repository;
    

	
	public List<MyClass145> findAll () 
	{
		return this.myClass145Repository.findAll();	
	}

	
	public List<MyClass145> findByCriteria (MyClass145Criteria criteria) 
	{
		return this.myClass145Repository.findByCriteria (criteria);	
	}

	
	public MyClass145 findById (Long id) 
	{
		return this.myClass145Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass145 save (MyClass145 myclass145) 
	{
		return this.myClass145Repository.save (myclass145);	
	}


}
