/**
 * Test.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-7
 */

package execute;


public class Test {
	
	public static void main(String[] args) {
		
		SynchronizedQueue readyQueue = new SynchronizedQueue();
		SynchronizedQueue inputQueue = new SynchronizedQueue();
		SynchronizedQueue printQueue = new SynchronizedQueue();

		Memory mem = new Memory(readyQueue, inputQueue, printQueue);
		Keyboard keyboard = new Keyboard(readyQueue, inputQueue, mem);
		Printer printer = new Printer(readyQueue, printQueue, mem);
		ProcessController processcontroller = new ProcessController(readyQueue, inputQueue, printQueue, mem, keyboard, printer);
		UI ui = new UI();
		RunningMode mode = new RunningMode();
		ui.setMode(mode);
		processcontroller.setMode(mode);
		ui.setParameters(processcontroller.getPcb(), readyQueue, inputQueue, printQueue, keyboard, mem);
		processcontroller.setUi(ui);
		keyboard.start();
		printer.start();
		processcontroller.start();
//		File file;
//		FileReader input;
//		try {
//			file = new File("./3.txt");
//			file.createNewFile();/
//			input = new FileReader(file);
//			System.out.println(mem.addProcess(new BufferedReader(input)));
//			input.close();
//			
//			Thread.sleep(3000);
//			
//			file = new File("./2.txt");
//			file.createNewFile();
//			input = new FileReader(file);
//			System.out.println(mem.addProcess(new BufferedReader(input)));
//			input.close();
//			file = new File("./1.txt");
//			file.createNewFile();
//			input = new FileReader(file);
//			System.out.println(mem.addProcess(new BufferedReader(input)));
//			input.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
