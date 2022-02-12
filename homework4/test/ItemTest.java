package com.study.springcore.homework4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.homework4.entity.Item;
import com.study.springcore.homework4.template.ItemDao;



public class ItemTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("jdbc-config.xml");
		ItemDao itemDao=ctx.getBean("itemDao",ItemDao.class);
		
		List<Item> items=itemDao.queryAll();
		
		//
		System.out.println("1.每一張發票有那些商品");
        Map<Integer, List<Item>> map1=items.stream()
                .collect(Collectors.groupingBy(item -> item.getInvoice().getId(), Collectors.toList())); //,前為key，後為value
									        //groupingBy(key,value)groupingBy分組方法回傳值絕對是Map
		map1.keySet()
           .stream()
           .forEach(id -> System.out.println("發票號碼:" + id + " 項目:" + map1.get(id).stream().map(item -> item.getItemProduct().getText()).collect(Collectors.toList())));
        
		System.out.println("==============================");
		System.out.println("2.每一張發票有幾件商品");
		Map<Integer,Long> map2=items.stream()
				.collect(Collectors.groupingBy(item->item.getInvoice().getId(),Collectors.counting()));
		
		map2.keySet()
			.stream()
			.forEach(id->System.out.println("發票號碼:"+id +" 商品數量："+map2.get(id)));
		
		System.out.println("==============================");
		System.out.println("3.每一張發票價值多少");
		Map<Integer,Integer> map3=items.stream()
				.collect(Collectors.groupingBy(item->item.getInvoice().getId(),Collectors.summingInt(item->item.getItemProduct().getPrice()*item.getAmount())));
        
		map3.keySet()
		.stream()
		.forEach(id->System.out.println("發票號碼:"+id +" 發票價值："+map3.get(id)));
	
		System.out.println("==============================");
		System.out.println("4.每一樣商品各賣了多少？");
		Map<String,Long> map4=items.stream()
				.collect(Collectors.groupingBy(item->item.getItemProduct().getText(),Collectors.counting()));

		map4.keySet()
		.stream()
		.forEach(id->System.out.println("商品名稱:"+id +" 售出數量："+map4.get(id)));
	
		System.out.println("==============================");
		System.out.println("5.哪一樣商品賣的錢最多？");
		Map<String,Integer> map5=items.stream()
				.collect(Collectors.groupingBy(item->item.getItemProduct().getText(),Collectors.summingInt(item->item.getItemProduct().getPrice()*item.getAmount())));
		
		System.out.println(
			map5.keySet()
			.stream()
			.max(Comparator.comparing(key->map5.get(key)))
			.get()
		);
		
		System.out.println("==============================");
		System.out.println("6.哪一張發票價值最高？");
		
		System.out.println(
			map3.keySet()
			.stream()
			.max(Comparator.comparing(key->map3.get(key)))
			.get()
		);
		
		
		
	}

}
