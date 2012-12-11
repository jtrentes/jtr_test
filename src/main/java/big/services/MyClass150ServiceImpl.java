package big.services;

import big.repositories.MyClass150Repository;
import big.repositories.criteria.MyClass150Criteria;
import big.domain.MyClass150;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Service(value = "myclass150Service")
@Transactional(readOnly = true)
public class MyClass150ServiceImpl implements MyClass150Service
{

	
	@Autowired
	private MyClass150Repository myClass150Repository;
    

	
	public List<MyClass150> findAll () 
	{
		return this.myClass150Repository.findAll();	
	}

	
	public List<MyClass150> findByCriteria (MyClass150Criteria criteria) 
	{
		return this.myClass150Repository.findByCriteria (criteria);	
	}

	
	public MyClass150 findById (Long id) 
	{
		return this.myClass150Repository.findById(id);	
	}

	@Transactional(readOnly = false)
	public MyClass150 save (MyClass150 myclass150) 
	{
		return this.myClass150Repository.save (myclass150);	
	}


}
