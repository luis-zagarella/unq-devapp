package ar.edu.unq.examples.aroundmethod;

public class ExecuteAroundMethodExamples {

	public void execute(String param) {
		this.start();
		Repository.operate(param);
		this.close();
	}

	public void execute2(String param, String param2, int param3) {
		this.start();
		Repository.operate(param, param2, param3);
		this.close();
	}

	public void execute3(String param, String param2, String param3) {
		this.start();
		Repository.operate(param, param2, param3);
		this.close();
	}

	// /////////////////////////////////////
	// /////////////////////////////////////
	// /////////////////////////////////////
	// /////////////////////////////////////

	static class Repository {

		public static void operate(String param, String param2, String param3) {
			// TODO Auto-generated method stub

		}

		public static void operate(String param) {
			// TODO Auto-generated method stub

		}

		public static void operate(String param, String param2, int param3) {
			// TODO Auto-generated method stub

		}

	}

	private void close() {

	}

	private void start() {

	}

}
