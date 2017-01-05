package com.testbazurton.spring;
import com.testbazurton.spring.model.Festivity;
import org.springframework.batch.item.ItemProcessor;



public class FestivityItemProcessor implements ItemProcessor<Festivity, Festivity>{

	
	@Override
	public Festivity process(Festivity result) throws Exception {
		System.out.println("Processing result :"+result);
		
		return result;
	}

}
