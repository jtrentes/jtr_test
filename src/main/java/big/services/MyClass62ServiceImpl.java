package big.services;

import big.repositories.MyClass62Repository;
import java.util.List;
import big.domain.MyClass62;
import big.repositories.criteria.MyClass62Criteria;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service(value = "myclass62Service")
@Transactional(readOnly = true)
public class MyClass62ServiceImpl implements MyClass62Service
{

	
	@Autowired
	private MyClass62Repository myClass62Repository;
    

	
	public List<MyClass62> findAll () 
	{
		return this.myClass62Repository.findAll();	
	}

	
	public List<MyClass62> findByCriteria (MyClass62Criteria criteria) 
	{
		return this.myClass62Repository.findByCriteria (criteria);	
	}

	
	public MyClass62 findById (Long id) 
	{
		return this.myClass62Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass62 save (MyClass62 myclass62) 
	{
		return this.myClass62Repository.save (myclass62);	
	}


}
