package launch;

import java.io.IOException;

public interface ILaunch {

	public void run() throws IOException, InterruptedException;
	
	public void close() throws IOException;
}
