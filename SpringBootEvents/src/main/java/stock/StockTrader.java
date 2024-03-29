package stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	@Autowired
	private ApplicationEventPublisher publisher;
	
	public void changeStockValue(String stockName, double value) {
		publisher.publishEvent(new StockChangeEvent(stockName, value));
	}
}
