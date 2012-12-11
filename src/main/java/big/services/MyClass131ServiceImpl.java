package big.services;

import big.domain.MyClass131;
import big.repositories.criteria.MyClass131Criteria;
import java.util.List;
import big.repositories.MyClass131Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass131Service")
@Transactional(readOnly = true)
public class MyClass131ServiceImpl implements MyClass131Service
{

	
	@Autowired
	private MyClass131Repository myClass131Repository;
    

	
	public List<MyClass131> findAll () 
	{
		return this.myClass131Repository.findAll();	
	}

	
	public List<MyClass131> findByCriteria (MyClass131Criteria criteria) 
	{
		return this.myClass131Repository.findByCriteria (criteria);	
	}

	
	public MyClass131 findById (Long id) 
	{
		return this.myClass131Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass131 save (MyClass131 myclass131) 
	{
		return this.myClass131Repository.save (myclass131);	
	}


}
