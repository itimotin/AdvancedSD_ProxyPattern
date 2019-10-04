package printer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrintingService {
	@Autowired
	List<PrinterHandler> printerHandlers;
	
	public void print(PrintProperties printProperties, String content) {
		for (PrinterHandler printerHandler:  printerHandlers) {
			if (printerHandler.handle(printProperties, content))
				break;
		}
	}
}
