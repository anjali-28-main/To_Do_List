package todolist;

import javax.swing.*;
public class App {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ToDoListGui().setVisible(true);
			}
		});

	}

}
