package todolist;

import javax.swing.*;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoListGui extends JFrame implements ActionListener  {
	//taskPanel will act as the container for the taskcomponentpanel
	//taskcomponent panel will store all the taskcomponents
	private JPanel taskPanel,taskComponentPanel;
	
	public ToDoListGui() {
		super("To Do List Application");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(CommonConstants.GUI_SIZE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		
		addGuiComponents();
		
		}
	private void addGuiComponents() {
		//banner text
		JLabel bannerLabel=new JLabel("To Do List");
		bannerLabel.setFont(new Font("Times New Roman",Font.BOLD,40));
		bannerLabel.setBounds(
				(CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
				15,
				CommonConstants.BANNER_SIZE.width,
				CommonConstants.BANNER_SIZE.height);
		
		
		//taskpanel
		taskPanel=new JPanel();
		//task component panel
		taskComponentPanel=new JPanel();
		taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
		taskPanel.add(taskComponentPanel);
		
		//add scrolling to new task panel
		JScrollPane scrollPane=new JScrollPane(taskPanel);
		scrollPane.setBounds(8,70,CommonConstants.TASK_PANEL_SIZE.width,CommonConstants.TASK_PANEL_SIZE.height);
		scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
		scrollPane.setMaximumSize(CommonConstants.TASK_PANEL_SIZE);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//changing speed of scroll bar
		JScrollBar verticalScrollBar=scrollPane.getVerticalScrollBar();
		verticalScrollBar.setUnitIncrement(20);
				
		//add task button
		JButton addTaskButton=new JButton("Add Task");
		addTaskButton.setFont(new Font("Times New Roman",Font.PLAIN,20));
		addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addTaskButton.setBounds(-5,CommonConstants.GUI_SIZE.height - 88,CommonConstants.ADDTASK_BUTTON_SIZE.width,CommonConstants.ADDTASK_BUTTON_SIZE.height);
		addTaskButton.addActionListener(this);
		
		//add to frame
		this.getContentPane().add(bannerLabel);
		this.getContentPane().add(scrollPane);
		this.getContentPane().add(addTaskButton);
			
	}
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equalsIgnoreCase("Add Task")) {
			TaskComponent taskComponent=new TaskComponent(taskComponentPanel);
			taskComponentPanel.add(taskComponent);
			
			// make the previous task appear disabled
			if(taskComponentPanel.getComponentCount()>1) {
				TaskComponent previousTask=(TaskComponent) taskComponentPanel.getComponent(
						taskComponentPanel.getComponentCount() - 2);
				previousTask.getTaskField().setBackground(null);
			}
			
			//make the task field request focus after creation 
			taskComponent.getTaskField().requestFocus();
			repaint();
			revalidate();
		}
	}


}
