package file.io.decorator;

import java.io.*;

public class Application3 {

	public static void main(String[] args) {
		int c;
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		try {
			InputStream inputStream = new ToUppercaseInputStream(new BufferedInputStream(new FileInputStream(rootPath + "/input.txt")));

			while ((c = inputStream.read()) >= 0) {
				System.out.print((char) c);
			}
			
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
