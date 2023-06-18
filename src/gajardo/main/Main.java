package gajardo.main;

import gajardo.frameworks.Start;

public class Main {

	public static void main(String[] args) throws Exception {

		Start start = new Start("/config.properties");
		start.init();

	}

}
