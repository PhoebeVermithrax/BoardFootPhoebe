/*
 * Created by: Phoebe Vermithrax
 * Created on: 16-Feb-2018
 * Created for: ICS4U
 * Daily Assignment – Day #10
 * This program calculates the unknown variable, depth, for the boardfoot equation. It has the user enter in the width 
 * and the length.
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BoardFoot {
	
	protected Shell shell;
	private Text txtFirstNum;
	private Text txtSecondNum;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BoardFoot window = new BoardFoot();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public double CalculateBoardFoot(double lengthText, double widthText)
	{
		// Set the variables for the answer gathered within the first step.
		double answer;
		double depth;
		double boardFoot = 1;
		
		//Calculate the answer.
		answer = (lengthText * widthText * boardFoot)/144;
		
		//Calculate the depth.
		depth = 1 / answer;
		
		//Return the depth.
		return depth; 
	}
	
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Board Foot");
		
		txtFirstNum = new Text(shell, SWT.BORDER);
		txtFirstNum.setBounds(188, 48, 236, 21);
		
		txtSecondNum = new Text(shell, SWT.BORDER);
		txtSecondNum.setBounds(188, 85, 236, 21);
		
		Label lblEnterFirstDimension = new Label(shell, SWT.NONE);
		lblEnterFirstDimension.setBounds(25, 51, 142, 15);
		lblEnterFirstDimension.setText("Enter First Dimension: ");
		
		Label lblEnterSecondDimension = new Label(shell, SWT.NONE);
		lblEnterSecondDimension.setBounds(25, 88, 142, 15);
		lblEnterSecondDimension.setText("Enter Second Dimension: ");
		
		Label lblTheThirdDimension = new Label(shell, SWT.NONE);
		lblTheThirdDimension.setBounds(54, 189, 177, 15);
		lblTheThirdDimension.setText("The third dimension, depth, is: ");
		
		Label lblDepth = new Label(shell, SWT.NONE);
		lblDepth.setBounds(239, 189, 55, 15);
		lblDepth.setText("New Label");
		//Make this invisible.
		lblDepth.setVisible(false);
		
		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Set the variables for the board length and width, to send them to the function.
				double boardLength;
				double boardWidth;
				double theDepth;
				
				//Parse the text in the textboxes and store them in the variables.
				boardLength = Integer.parseInt(txtFirstNum.getText());
				boardWidth = Integer.parseInt(txtSecondNum.getText());
				
				//Send the integers to the function, CalculateBoardFoot. Store the return value to theDepth.
				theDepth = CalculateBoardFoot(boardLength, boardWidth);
				
				//Output this to the label.
				lblDepth.setVisible(true);
				lblDepth.setText("" + theDepth);
			}
		});
		btnCalculate.setBounds(188, 123, 75, 25);
		btnCalculate.setText("Calculate");

	}
}
