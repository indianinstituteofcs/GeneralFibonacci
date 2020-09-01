import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class WindowGUI{

    private static final int maxKValue = 8;
    
    private GeneralFibonacci gfSeries;

	private JFrame frame;
	private JSpinner spinnerKValue;
	private JTextField[] txtInitValueArray = new JTextField[maxKValue];
	private JTextField txtF0Value;
	private JTextField txtF1Value;
	private JTextField txtF2Value;
	private JTextField txtF3Value;
	private JTextField txtF4Value;
	private JTextField txtF5Value;
	private JTextField txtF6Value;
	private JTextField txtF7Value;
	
	private JTextField txtNValue;
	private JTextField txtTailRecursiveValue;
	private JTextField txtIterativeValue;
	private JTextField txtNaive;
	
	private	JLabel lblK;
	private JLabel lblF0;
	private JLabel lblF1;
	private JLabel lblF2;
	private JLabel lblF3;
	private JLabel lblF4;
	private JLabel lblF5;
	private JLabel lblF6;
	private JLabel lblF7;
	private JTextField lblTitleL1;
	private JTextField lblTitleL2;
	private JLabel lblCalculateNthTerm;
	private JLabel lblTailRecursive;
	private JLabel lblIterative;
	private JLabel lblNaive;
	
	private JButton btnSetGeneralFibonacci; 
	private	JButton btnCalculateGeneralFibonacci;
	private	JButton btnQuit;
	private JLabel lblNthTerm;
	private JTextField txtNthTermValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowGUI window = new WindowGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowGUI() {
		initializeGUI();		
		try {
			long [] initValues = {0,1};
			gfSeries = new GeneralFibonacci(2, initValues);
		} catch (ConstructorException e) {
			System.out.println("Code: "+ e.getCode() + " Exception Message : " + e.getMessage());
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeGUI() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 450); //X,Y, Width, Height.
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		lblK = new JLabel(" K (# prior terms):");
		springLayout.putConstraint(SpringLayout.WEST, lblK, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblK, 110, SpringLayout.WEST, frame.getContentPane());
		lblK.setFont(new Font("Arial", Font.PLAIN, 12));
		lblK.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblK);
		
		lblF0 = new JLabel("F1: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF0, 20, SpringLayout.SOUTH, lblK);
		springLayout.putConstraint(SpringLayout.WEST, lblF0, 0, SpringLayout.WEST, lblK);
		springLayout.putConstraint(SpringLayout.EAST, lblF0, -5, SpringLayout.EAST, lblK);
		lblF0.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF0.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF0);
		
		lblF1 = new JLabel("F2: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF1, 15, SpringLayout.SOUTH, lblF0);
		springLayout.putConstraint(SpringLayout.WEST, lblF1, 0, SpringLayout.WEST, lblK);
		springLayout.putConstraint(SpringLayout.EAST, lblF1, 0, SpringLayout.EAST, lblF0);
		lblF1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF1.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF1);
		
		lblF2 = new JLabel("F3: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF2, 15, SpringLayout.SOUTH, lblF1);
		springLayout.putConstraint(SpringLayout.WEST, lblF2, 0, SpringLayout.WEST, lblF0);
		springLayout.putConstraint(SpringLayout.EAST, lblF2, 0, SpringLayout.EAST, lblF0);
		lblF2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF2.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF2);
		
		lblF3 = new JLabel("F4: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF3, 15, SpringLayout.SOUTH, lblF2);
		springLayout.putConstraint(SpringLayout.WEST, lblF3, 0, SpringLayout.WEST, lblF0);
		springLayout.putConstraint(SpringLayout.EAST, lblF3, 0, SpringLayout.EAST, lblF0);
		lblF3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF3.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF3);
		
		lblF4 = new JLabel("F5: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF4, 15, SpringLayout.SOUTH, lblF3);
		springLayout.putConstraint(SpringLayout.WEST, lblF4, 0, SpringLayout.WEST, lblF0);
		springLayout.putConstraint(SpringLayout.EAST, lblF4, 0, SpringLayout.EAST, lblF0);
		lblF4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF4.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF4);
		
		lblF5 = new JLabel("F6: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF5, 15, SpringLayout.SOUTH, lblF4);
		springLayout.putConstraint(SpringLayout.WEST, lblF5, 0, SpringLayout.WEST, lblF0);
		springLayout.putConstraint(SpringLayout.EAST, lblF5, 0, SpringLayout.EAST, lblF0);
		lblF5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF5.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF5);
		
		lblF6 = new JLabel("F7: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF6, 15, SpringLayout.SOUTH, lblF5);
		springLayout.putConstraint(SpringLayout.WEST, lblF6, 0, SpringLayout.WEST, lblF0);
		springLayout.putConstraint(SpringLayout.EAST, lblF6, 0, SpringLayout.EAST, lblF0);
		lblF6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF6.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF6);
		
		lblF7 = new JLabel("F8: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblF7, 15, SpringLayout.SOUTH, lblF6);
		springLayout.putConstraint(SpringLayout.WEST, lblF7, 0, SpringLayout.WEST, lblF0);
		springLayout.putConstraint(SpringLayout.EAST, lblF7, 0, SpringLayout.EAST, lblF0);
		lblF7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF7.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblF7);
		
		lblTitleL1 = new JTextField("General Fibonacci: F(n) = sum{n-1 <= m <= n-k} F(m)");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleL1, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitleL1, 35, SpringLayout.NORTH, frame.getContentPane());
		lblTitleL1.setBorder(null);
		lblTitleL1.setEditable(false);
		lblTitleL1.setForeground(new Color(248, 248, 255));
		lblTitleL1.setBackground(Color.BLACK);
		lblTitleL1.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.WEST, lblTitleL1, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblTitleL1, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblTitleL1);
		
		lblTitleL2 = new JTextField("For n =>k, where k and F(0)...F(k-1) are specified");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitleL2, -5, SpringLayout.SOUTH, lblTitleL1);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTitleL2, 25, SpringLayout.SOUTH, lblTitleL1);
		lblTitleL2.setBorder(null);
		lblTitleL2.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, lblK, 25, SpringLayout.SOUTH, lblTitleL2);
		springLayout.putConstraint(SpringLayout.SOUTH, lblK, 50, SpringLayout.SOUTH, lblTitleL2);
		lblTitleL2.setForeground(new Color(248, 248, 255));
		lblTitleL2.setBackground(new Color(0, 0, 0));
		springLayout.putConstraint(SpringLayout.WEST, lblTitleL2, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblTitleL2, 0, SpringLayout.EAST, frame.getContentPane());
		lblTitleL2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblTitleL2);
		
		txtF0Value = new JTextField();
		txtInitValueArray[0] = txtF0Value;
		txtF0Value.setHorizontalAlignment(SwingConstants.LEFT);
		springLayout.putConstraint(SpringLayout.NORTH, txtF0Value, -7, SpringLayout.NORTH, lblF0);
		txtF0Value.setText("0");
		txtF0Value.setColumns(10);
		frame.getContentPane().add(txtF0Value);
		
		txtF1Value = new JTextField();
		txtInitValueArray[1] = txtF1Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF1Value, -7, SpringLayout.NORTH, lblF1);
		springLayout.putConstraint(SpringLayout.WEST, txtF1Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF1Value, 0, SpringLayout.EAST, txtF0Value);
		txtF1Value.setText("1");
		txtF1Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF1Value.setColumns(10);
		frame.getContentPane().add(txtF1Value);
		
		txtF2Value = new JTextField();
		txtInitValueArray[2] = txtF2Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF2Value, -7, SpringLayout.NORTH, lblF2);
		springLayout.putConstraint(SpringLayout.WEST, txtF2Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF2Value, 0, SpringLayout.EAST, txtF0Value);
		txtF2Value.setText("1");
		txtF2Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF2Value.setColumns(10);
		frame.getContentPane().add(txtF2Value);
		
		txtF3Value = new JTextField();
		txtInitValueArray[3] = txtF3Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF3Value, -7, SpringLayout.NORTH, lblF3);
		springLayout.putConstraint(SpringLayout.WEST, txtF3Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF3Value, 0, SpringLayout.EAST, txtF0Value);
		txtF3Value.setText("1");
		txtF3Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF3Value.setColumns(10);
		frame.getContentPane().add(txtF3Value);
		
		txtF4Value = new JTextField();
		txtInitValueArray[4] = txtF4Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF4Value, -7, SpringLayout.NORTH, lblF4);
		springLayout.putConstraint(SpringLayout.WEST, txtF4Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF4Value, 0, SpringLayout.EAST, txtF0Value);
		txtF4Value.setText("1");
		txtF4Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF4Value.setColumns(10);
		frame.getContentPane().add(txtF4Value);
		
		txtF5Value = new JTextField();
		txtInitValueArray[5] = txtF5Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF5Value, -7, SpringLayout.NORTH, lblF5);
		springLayout.putConstraint(SpringLayout.WEST, txtF5Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF5Value, 0, SpringLayout.EAST, txtF0Value);
		txtF5Value.setText("1");
		txtF5Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF5Value.setColumns(10);
		frame.getContentPane().add(txtF5Value);
		
		txtF6Value = new JTextField();
		txtInitValueArray[6] = txtF6Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF6Value, -7, SpringLayout.NORTH, lblF6);
		springLayout.putConstraint(SpringLayout.WEST, txtF6Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF6Value, 0, SpringLayout.EAST, txtF0Value);
		txtF6Value.setText("1");
		txtF6Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF6Value.setColumns(10);
		frame.getContentPane().add(txtF6Value);
		
		txtF7Value = new JTextField();
		txtInitValueArray[7] = txtF7Value;
		springLayout.putConstraint(SpringLayout.NORTH, txtF7Value, -7, SpringLayout.NORTH, lblF7);
		springLayout.putConstraint(SpringLayout.WEST, txtF7Value, 0, SpringLayout.WEST, txtF0Value);
		springLayout.putConstraint(SpringLayout.EAST, txtF7Value, 0, SpringLayout.EAST, txtF0Value);
		txtF7Value.setText("1");
		txtF7Value.setHorizontalAlignment(SwingConstants.LEFT);
		txtF7Value.setColumns(10);
		frame.getContentPane().add(txtF7Value);
		
		btnSetGeneralFibonacci = new JButton("SET GENERAL FIBONACCI");
		springLayout.putConstraint(SpringLayout.SOUTH, btnSetGeneralFibonacci, 50, SpringLayout.SOUTH, txtF7Value);
		btnSetGeneralFibonacci.setForeground(new Color(255, 140, 0));
		btnSetGeneralFibonacci.setBackground(new Color(248, 248, 255));
		springLayout.putConstraint(SpringLayout.NORTH, btnSetGeneralFibonacci, 15, SpringLayout.SOUTH, txtF7Value);
		btnSetGeneralFibonacci.setFont(new Font("Arial", Font.PLAIN, 12));
		springLayout.putConstraint(SpringLayout.WEST, btnSetGeneralFibonacci, 0, SpringLayout.WEST, lblK);
		frame.getContentPane().add(btnSetGeneralFibonacci);
		btnSetGeneralFibonacci.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int kValue = (Integer) spinnerKValue.getValue();
						long [] initValueArray = new long[kValue];
						
						for(int i = 0; i < kValue;i++) {
							initValueArray[i] = Long.parseLong(txtInitValueArray[i].getText());
						}

						try {
							gfSeries.resetGeneralFibonacci(kValue, initValueArray);
							gfSeries.printFibonacciDefinition();
						} catch (ConstructorException e1) {
							System.out.println("Code: "+ e1.getCode() + " Exception Message : " + e1.getMessage());
						}
					}
				});
		
		
		lblCalculateNthTerm = new JLabel("Calculate nth Term:");
		springLayout.putConstraint(SpringLayout.NORTH, lblCalculateNthTerm, 0, SpringLayout.NORTH, lblK);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCalculateNthTerm, 0, SpringLayout.SOUTH, lblK);
		lblCalculateNthTerm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCalculateNthTerm.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblCalculateNthTerm);
		
		txtNValue = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtNValue, 25, SpringLayout.SOUTH, lblTitleL2);
		springLayout.putConstraint(SpringLayout.EAST, lblCalculateNthTerm, -5, SpringLayout.WEST, txtNValue);
		springLayout.putConstraint(SpringLayout.EAST, txtNValue, -10, SpringLayout.EAST, frame.getContentPane());
		txtNValue.setText(" N");
		txtNValue.setColumns(10);
		frame.getContentPane().add(txtNValue);
		
		btnCalculateGeneralFibonacci = new JButton("CALCULATE NTH TERM");
		springLayout.putConstraint(SpringLayout.SOUTH, txtNValue, -12, SpringLayout.NORTH, btnCalculateGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.NORTH, btnCalculateGeneralFibonacci, 0, SpringLayout.NORTH, txtF0Value);
		springLayout.putConstraint(SpringLayout.WEST, btnCalculateGeneralFibonacci, 0, SpringLayout.WEST, lblCalculateNthTerm);
		springLayout.putConstraint(SpringLayout.SOUTH, btnCalculateGeneralFibonacci, 0, SpringLayout.NORTH, lblF1);
		springLayout.putConstraint(SpringLayout.EAST, btnCalculateGeneralFibonacci, 0, SpringLayout.EAST, txtNValue);
		btnCalculateGeneralFibonacci.setForeground(new Color(165, 42, 42));
		btnCalculateGeneralFibonacci.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCalculateGeneralFibonacci.setBackground(new Color(248, 248, 255));
		frame.getContentPane().add(btnCalculateGeneralFibonacci);
		btnCalculateGeneralFibonacci.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int nthValue = Integer.parseInt(txtNValue.getText().trim());
						//System.out.println("Calculate the " + nthValue + " term.");

						Pair<Long, Long> pairValueTailRecursive = gfSeries.calculateNthTerm(nthValue - 1);
						Pair<Long, Long> pairValueIterative = gfSeries.calculateNthTermIterative(nthValue - 1);
						Pair<Long, Long> pairValueExp = gfSeries.calculateNthTermExp(nthValue - 1);

						if(pairValueTailRecursive.first().equals(pairValueIterative.first()) &&
								pairValueIterative.first().equals(pairValueExp.first())){
							txtNthTermValue.setText(Long.toString(pairValueTailRecursive.first()));						
							txtTailRecursiveValue.setText(Long.toString(pairValueTailRecursive.second()));
							txtIterativeValue.setText(Long.toString(pairValueIterative.second()));
							txtNaive.setText(Long.toString(pairValueExp.second()));													
						} else {
							txtNthTermValue.setText(Long.toString(-1));						
							txtTailRecursiveValue.setText(Long.toString(-1));
							txtIterativeValue.setText(Long.toString(-1));
							txtNaive.setText(Long.toString(-1));
						}
					}
				});		
		
		lblTailRecursive = new JLabel("Tail Recursive Steps:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTailRecursive, 80, SpringLayout.SOUTH, btnCalculateGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTailRecursive, 100, SpringLayout.SOUTH, btnCalculateGeneralFibonacci);
		lblTailRecursive.setHorizontalAlignment(SwingConstants.RIGHT);
		springLayout.putConstraint(SpringLayout.WEST, lblTailRecursive, -30, SpringLayout.WEST, lblCalculateNthTerm);
		springLayout.putConstraint(SpringLayout.EAST, lblTailRecursive, 0, SpringLayout.EAST, lblCalculateNthTerm);
		lblTailRecursive.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTailRecursive.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblTailRecursive);
		
		txtTailRecursiveValue = new JTextField();
		txtTailRecursiveValue.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtTailRecursiveValue, -7, SpringLayout.NORTH, lblTailRecursive);
		springLayout.putConstraint(SpringLayout.WEST, txtTailRecursiveValue, 0, SpringLayout.WEST, txtNValue);
		springLayout.putConstraint(SpringLayout.SOUTH, txtTailRecursiveValue, 7, SpringLayout.SOUTH, lblTailRecursive);
		springLayout.putConstraint(SpringLayout.EAST, txtTailRecursiveValue, 0, SpringLayout.EAST, txtNValue);
		txtTailRecursiveValue.setText("# Steps");
		txtTailRecursiveValue.setColumns(10);
		frame.getContentPane().add(txtTailRecursiveValue);
		
		lblIterative = new JLabel("Iterative Steps:");
		springLayout.putConstraint(SpringLayout.NORTH, lblIterative, 20, SpringLayout.SOUTH, lblTailRecursive);
		springLayout.putConstraint(SpringLayout.WEST, lblIterative, 0, SpringLayout.WEST, lblTailRecursive);
		springLayout.putConstraint(SpringLayout.SOUTH, lblIterative, 40, SpringLayout.SOUTH, lblTailRecursive);
		springLayout.putConstraint(SpringLayout.EAST, lblIterative, 0, SpringLayout.EAST, lblTailRecursive);
		lblIterative.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIterative.setFont(new Font("Arial", Font.PLAIN, 12));
		lblIterative.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblIterative);
		
		txtIterativeValue = new JTextField();
		txtIterativeValue.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtIterativeValue, -7, SpringLayout.NORTH, lblIterative);
		springLayout.putConstraint(SpringLayout.WEST, txtIterativeValue, 0, SpringLayout.WEST, txtTailRecursiveValue);
		springLayout.putConstraint(SpringLayout.SOUTH, txtIterativeValue, 7, SpringLayout.SOUTH, lblIterative);
		springLayout.putConstraint(SpringLayout.EAST, txtIterativeValue, 0, SpringLayout.EAST, txtTailRecursiveValue);
		txtIterativeValue.setText("# Steps");
		txtIterativeValue.setColumns(10);
		frame.getContentPane().add(txtIterativeValue);
		
		lblNaive = new JLabel("Naive Steps:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNaive, 20, SpringLayout.SOUTH, lblIterative);
		springLayout.putConstraint(SpringLayout.WEST, lblNaive, 0, SpringLayout.WEST, lblTailRecursive);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNaive, 40, SpringLayout.SOUTH, lblIterative);
		springLayout.putConstraint(SpringLayout.EAST, lblNaive, 0, SpringLayout.EAST, lblTailRecursive);
		lblNaive.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNaive.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNaive.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblNaive);
		
		txtNaive = new JTextField();
		txtNaive.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtNaive, -7, SpringLayout.NORTH, lblNaive);
		springLayout.putConstraint(SpringLayout.WEST, txtNaive, 0, SpringLayout.WEST, txtIterativeValue);
		springLayout.putConstraint(SpringLayout.SOUTH, txtNaive, 7, SpringLayout.SOUTH, lblNaive);
		springLayout.putConstraint(SpringLayout.EAST, txtNaive, 0, SpringLayout.EAST, txtIterativeValue);
		txtNaive.setText("# Steps");
		txtNaive.setColumns(10);
		frame.getContentPane().add(txtNaive);
		
		spinnerKValue = new JSpinner();
		spinnerKValue.setRequestFocusEnabled(false);
		SpinnerModel kValueModel = new SpinnerNumberModel(2, 2, maxKValue, 1);//initial, min, max, increment
		spinnerKValue.setModel(kValueModel);
		springLayout.putConstraint(SpringLayout.EAST, btnSetGeneralFibonacci, 0, SpringLayout.EAST, spinnerKValue);
		springLayout.putConstraint(SpringLayout.WEST, txtF0Value, 0, SpringLayout.WEST, spinnerKValue);
		springLayout.putConstraint(SpringLayout.EAST, txtF0Value, -30, SpringLayout.EAST, spinnerKValue);
		springLayout.putConstraint(SpringLayout.NORTH, spinnerKValue, 0, SpringLayout.NORTH, lblK);
		springLayout.putConstraint(SpringLayout.WEST, spinnerKValue, 6, SpringLayout.EAST, lblK);
		springLayout.putConstraint(SpringLayout.EAST, spinnerKValue, 106, SpringLayout.EAST, lblK);
		frame.getContentPane().add(spinnerKValue);
		
		btnQuit = new JButton("QUIT");
		springLayout.putConstraint(SpringLayout.NORTH, btnQuit, 0, SpringLayout.NORTH, btnSetGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.WEST, btnQuit, 0, SpringLayout.WEST, btnCalculateGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.SOUTH, btnQuit, 0, SpringLayout.SOUTH, btnSetGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.EAST, btnQuit, 0, SpringLayout.EAST, btnCalculateGeneralFibonacci);
		btnQuit.setForeground(Color.RED);
		btnQuit.setFont(new Font("Arial", Font.PLAIN, 12));
		btnQuit.setBackground(new Color(248, 248, 255));
		frame.getContentPane().add(btnQuit);
		
		lblNthTerm = new JLabel("Nth Term:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNthTerm, 30, SpringLayout.SOUTH, btnCalculateGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.WEST, lblNthTerm, -30, SpringLayout.WEST, lblCalculateNthTerm);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNthTerm, 50, SpringLayout.SOUTH, btnCalculateGeneralFibonacci);
		springLayout.putConstraint(SpringLayout.EAST, lblNthTerm, 0, SpringLayout.EAST, lblCalculateNthTerm);
		lblNthTerm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNthTerm.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNthTerm.setBackground(new Color(230, 230, 250));
		frame.getContentPane().add(lblNthTerm);
		
		txtNthTermValue = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtNthTermValue, -7, SpringLayout.NORTH, lblNthTerm);
		springLayout.putConstraint(SpringLayout.WEST, txtNthTermValue, 0, SpringLayout.WEST, txtNValue);
		springLayout.putConstraint(SpringLayout.SOUTH, txtNthTermValue, 7, SpringLayout.SOUTH, lblNthTerm);
		springLayout.putConstraint(SpringLayout.EAST, txtNthTermValue, 0, SpringLayout.EAST, txtNValue);
		txtNthTermValue.setText(" Nth term");
		txtNthTermValue.setEditable(false);
		txtNthTermValue.setColumns(10);
		frame.getContentPane().add(txtNthTermValue);
		btnQuit.addActionListener((event) -> System.exit(0));
	}
}
