package big.services;

import big.repositories.criteria.MyClass49Criteria;
import big.domain.MyClass49;
import java.util.List;
import big.repositories.MyClass49Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;


@Service(value = "myclass49Service")
@Transactional(readOnly = true)
public class MyClass49ServiceImpl implements MyClass49Service
{

	
	@Autowired
	private MyClass49Repository myClass49Repository;
    

	
	public List<MyClass49> findAll () 
	{
		return this.myClass49Repository.findAll();	
	}

	
	public List<MyClass49> findByCriteria (MyClass49Criteria criteria) 
	{
		return this.myClass49Repository.findByCriteria (criteria);	
	}

	
	public MyClass49 findById (Long id) 
	{
		return this.myClass49Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass49 save (MyClass49 myclass49) 
	{
		return this.myClass49Repository.save (myclass49);	
	}


}
