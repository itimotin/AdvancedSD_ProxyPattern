package timer;


public class StopWatch {
	private long start = 0 ;
	private long finish = 0;
	
	public void start() {
		start = System.currentTimeMillis();
	}
	
	public void stop() {
		finish = System.currentTimeMillis();
	}
	public long getMillis() {
		return finish - start;
	}
}
