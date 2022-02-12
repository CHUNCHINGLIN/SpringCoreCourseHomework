package com.study.springcore.homework4.template;

import java.util.List;

import org.simpleflatmapper.jdbc.spring.JdbcTemplateMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.study.springcore.homework4.entity.Item;

@Repository
public class ItemDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Item> queryAll(){
		
		String sql="SELECT item.id,\n"
				+ "		item.amount ,\n"
				+ "		ip.id as ItemProduct_id, \n"
				+ "		ip.text as ItemProduct_text,\n"
				+ "		ip.price as ItemProduct_price,\n"
				+ "		ip.inventory as ItemProduct_inventory,\n"
				+ "		i.id as Invoice_id,\n"
				+ "		i.invdate as Invoice_invdate\n"
				+ "FROM Item item ,Invoice i,ItemProduct ip \n"
				+ "Where item.ipid=ip.id and item.invid=i.id\n"
				+ "order by item.id";
		
		ResultSetExtractor<List<Item>> resultSetExtractor=JdbcTemplateMapperFactory
				.newInstance()
				.addKeys("id")
				.newResultSetExtractor(Item.class);
		
		return jdbcTemplate.query(sql,resultSetExtractor);
	}
	
	
	

}
