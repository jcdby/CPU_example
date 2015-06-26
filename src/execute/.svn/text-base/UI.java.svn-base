/**
 * UI.java
 * 
 * 
 * @author Õ²µÀéª
 * @date 2008-5-14
 */

package execute;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Dimension;

public class UI extends JFrame implements Parameters {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea jtaConsole = null;
	private JLabel jlConsole = null;
	private JTextField jtfInput = null;
	private JLabel jlInput = null;
	private JButton jbOK_Button = null;
	private JTextArea jtaPrinter = null;
	private JLabel jlPrinter = null;
	private JPanel jpProcessState = null;
	private JPanel jpProcessID = null;
	private JLabel jlProcessID = null;
	private JTextField jtfProcessID = null;
	private JPanel jpPC = null;
	private JLabel jlPC = null;
	private JTextField jtfPC = null;
	private JPanel jpAC = null;
	private JLabel jlAC = null;
	private JTextField jtfAC = null;
	private JPanel jpPSW = null;
	private JLabel jlPSW = null;
	private JPanel jpPrinter = null;
	private JPanel jpConsole = null;
	private JPanel jpInput = null;
	private JPanel jpIR = null;
	private JLabel jlIR = null;
	private JTextField jtfIR = null;
	private JPanel jpR0 = null;
	private JLabel jlR0 = null;
	private JTextField jtfR0 = null;
	private JPanel jpR1 = null;
	private JLabel jlR1 = null;
	private JTextField jtfR1 = null;
	private JPanel jpR2 = null;
	private JLabel jlR2 = null;
	private JTextField jtfR2 = null;
	private JPanel jpR3 = null;
	private JLabel jlR3 = null;
	private JTextField jtfR3 = null;
	private JPanel jpR4 = null;
	private JLabel jlR4 = null;
	private JTextField jtfR4 = null;
	private JPanel jpR5 = null;
	private JLabel jlR5 = null;
	private JTextField jtfR5 = null;
	private JPanel jpR6 = null;
	private JLabel jlR6 = null;
	private JTextField jtfR6 = null;
	private JPanel jpR7 = null;
	private JLabel jlR7 = null;
	private JTextField jtfR7 = null;
	private JScrollPane jspConsole = null;
	private JScrollPane jspPrinter = null;
	private JPanel jpProcessEditer = null;
	private JLabel jlProcessEditer = null;
	private JScrollPane jspProcessEditer = null;
	private JTextArea jtaProcessEditer = null;
	private JPanel jpReadyQueue = null;
	private JLabel jlReadyQueue = null;
	private JTextField jtfReadyQueue = null;
	private JPanel jpInputQueue = null;
	private JLabel jlInputQueue = null;
	private JTextField jtfInputQueue = null;
	private JPanel jpPrintQueue = null;
	private JLabel jlPrintQueue = null;
	private JTextField jtfPrintQueue = null;
	private JPanel jpQueueMoniter = null;
	private JPanel jpButtons = null;
	private JButton jbExecute = null;
	private JButton jbSave = null;
	private JButton jbLoad = null;
	private JButton jbClear = null;
	
	private PCB pcb = null;  //  @jve:decl-index=0:
	private SynchronizedQueue readyQueue = null;  //  @jve:decl-index=0:
	private SynchronizedQueue inputQueue = null;
	private SynchronizedQueue printQueue = null;  //  @jve:decl-index=0:
	//private Keyboard keyboard = null;  //  @jve:decl-index=0:
	private RunningMode mode = null;
	private Memory mem;
	private MemCell mc;
	private JPanel jpPSWS = null;
	private JLabel jlPSWs[] = new JLabel[8];
	private JPanel jpControll = null;
	private JLabel jlControllButton = null;
	private JPanel jpControllButton = null;
	private JPanel jpAutoMode = null;
	private JRadioButton jrbAutoMode = null;
	private JLabel jlAutoMode = null;
	private JPanel jpManualMode = null;
	private JRadioButton jrbManualMode = null;
	private JButton jbNext = null;
	private JTextField jtfAuto = null;
	private JPanel jpMunal = null;
	private JLabel jlManual = null;
	private JPanel jpAuto = null;
	private JLabel jlAuto = null;
	private JLabel jlManualMode = null;
	/**
	 * This is the default constructor
	 */
	public UI() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(844, 575);
		this.setPreferredSize(new Dimension(500, 35));
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setName("CPU");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("CPU Simulation");
		this.setVisible(true);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jlPrinter = new JLabel();
			jlPrinter.setText("Printer");
			jlPrinter.setPreferredSize(new Dimension(39, 20));
			jlInput = new JLabel();
			jlInput.setVerticalAlignment(SwingConstants.CENTER);
			jlInput.setPreferredSize(new Dimension(34, 20));
			jlInput.setText("Input");
			jlConsole = new JLabel();
			jlConsole.setText("Console");
			jlConsole.setPreferredSize(new Dimension(46, 20));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJpProcessState(), null);
			jContentPane.add(getJpPrinter(), null);
			jContentPane.add(getJpConsole(), null);
			jContentPane.add(getJpInput(), null);
			jContentPane.add(getJpProcessEditer(), null);
			jContentPane.add(getJpQueueMoniter(), null);
			jContentPane.add(getJpControll(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jtaConsole	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJtaConsole() {
		if (jtaConsole == null) {
			jtaConsole = new JTextArea();
			jtaConsole.setEditable(false);
			jtaConsole.setLineWrap(true);
			jtaConsole.setWrapStyleWord(true);
			jtaConsole.setText("");
		}
		return jtaConsole;
	}

	/**
	 * This method initializes jtfInput	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfInput() {
		if (jtfInput == null) {
			jtfInput = new JTextField();
			jtfInput.setPreferredSize(new Dimension(4, 25));
		}
		return jtfInput;
	}

	/**
	 * This method initializes jbOK_Button	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbOK_Button() {
		if (jbOK_Button == null) {
			jbOK_Button = new JButton();
			jbOK_Button.setText("Input");
			jbOK_Button.setMnemonic(KeyEvent.VK_UNDEFINED);
			jbOK_Button.setPreferredSize(new Dimension(62, 25));
			jbOK_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String s = jtfInput.getText();
					if(s.length() >= 1) {
						mc.setContent(s);
					}
				}
			});
		}
		return jbOK_Button;
	}

	/**
	 * This method initializes jtaPrinter	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJtaPrinter() {
		if (jtaPrinter == null) {
			jtaPrinter = new JTextArea();
			jtaPrinter.setEditable(false);
		}
		return jtaPrinter;
	}

	/**
	 * This method initializes jpProcessState	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpProcessState() {
		if (jpProcessState == null) {
			jpProcessState = new JPanel();
			jpProcessState.setLayout(null);
			jpProcessState.setLocation(new Point(10, 260));
			jpProcessState.setSize(new Dimension(250, 275));
			jpProcessState.add(getJpProcessID(), null);
			jpProcessState.add(getJpPC(), null);
			jpProcessState.add(getJpAC(), null);
			jpProcessState.add(getJpPSW(), null);
			jpProcessState.add(getJpIR(), null);
			jpProcessState.add(getJpR0(), null);
			jpProcessState.add(getJpR1(), null);
			jpProcessState.add(getJpR2(), null);
			jpProcessState.add(getJpR3(), null);
			jpProcessState.add(getJpR4(), null);
			jpProcessState.add(getJpR5(), null);
			jpProcessState.add(getJpR6(), null);
			jpProcessState.add(getJpR7(), null);
		}
		return jpProcessState;
	}

	/**
	 * This method initializes jpProcessID	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpProcessID() {
		if (jpProcessID == null) {
			jlProcessID = new JLabel();
			jlProcessID.setText("Current Process ID");
			jlProcessID.setPreferredSize(new Dimension(59, 25));
			jlProcessID.setSize(new Dimension(120, 25));
			jlProcessID.setLocation(new Point(0, 0));
			jlProcessID.setHorizontalAlignment(SwingConstants.LEFT);
			jpProcessID = new JPanel();
			jpProcessID.setLayout(null);
			jpProcessID.setLocation(new Point(35, 5));
			jpProcessID.setSize(new Dimension(180, 25));
			jpProcessID.add(jlProcessID, null);
			jpProcessID.add(getJtfProcessID(), null);
		}
		return jpProcessID;
	}

	/**
	 * This method initializes jtfProcessID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfProcessID() {
		if (jtfProcessID == null) {
			jtfProcessID = new JTextField();
			jtfProcessID.setLocation(new Point(130, 0));
			jtfProcessID.setEditable(false);
			jtfProcessID.setHorizontalAlignment(JTextField.RIGHT);
			jtfProcessID.setSize(new Dimension(50, 25));
		}
		return jtfProcessID;
	}

	/**
	 * This method initializes jpPC	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpPC() {
		if (jpPC == null) {
			jlPC = new JLabel();
			jlPC.setText("  PC");
			jlPC.setHorizontalTextPosition(SwingConstants.LEFT);
			jlPC.setSize(new Dimension(25, 25));
			jlPC.setLocation(new Point(0, 0));
			jlPC.setPreferredSize(new Dimension(16, 25));
			jlPC.setHorizontalAlignment(SwingConstants.LEFT);
			jpPC = new JPanel();
			jpPC.setLayout(null);
			jpPC.setLocation(new Point(0, 35));
			jpPC.setSize(new Dimension(125, 25));
			jpPC.add(jlPC, null);
			jpPC.add(getJtfPC(), null);
		}
		return jpPC;
	}

	/**
	 * This method initializes jtfPC1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfPC() {
		if (jtfPC == null) {
			jtfPC = new JTextField();
			jtfPC.setLocation(new Point(40, 0));
			jtfPC.setHorizontalAlignment(JTextField.RIGHT);
			jtfPC.setEditable(false);
			jtfPC.setSize(new Dimension(80, 25));
		}
		return jtfPC;
	}

	/**
	 * This method initializes jpAC	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpAC() {
		if (jpAC == null) {
			jlAC = new JLabel();
			jlAC.setLocation(new Point(0, 0));
			jlAC.setPreferredSize(new Dimension(16, 25));
			jlAC.setHorizontalAlignment(SwingConstants.LEFT);
			jlAC.setHorizontalTextPosition(SwingConstants.LEFT);
			jlAC.setText("  AC");
			jlAC.setSize(new Dimension(25, 25));
			jpAC = new JPanel();
			jpAC.setLayout(null);
			jpAC.setLocation(new Point(125, 35));
			jpAC.setSize(new Dimension(125, 25));
			jpAC.add(jlAC, null);
			jpAC.add(getJtfAC(), null);
		}
		return jpAC;
	}

	/**
	 * This method initializes jtfAC	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfAC() {
		if (jtfAC == null) {
			jtfAC = new JTextField();
			jtfAC.setLocation(new Point(40, 0));
			jtfAC.setEditable(false);
			jtfAC.setHorizontalAlignment(JTextField.RIGHT);
			jtfAC.setSize(new Dimension(80, 25));
		}
		return jtfAC;
	}

	/**
	 * This method initializes jpPSW	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpPSW() {
		if (jpPSW == null) {
			jlPSW = new JLabel();
			jlPSW.setLocation(new Point(0, 0));
			jlPSW.setPreferredSize(new Dimension(16, 25));
			jlPSW.setHorizontalAlignment(SwingConstants.LEFT);
			jlPSW.setHorizontalTextPosition(SwingConstants.LEFT);
			jlPSW.setText("PSW");
			jlPSW.setSize(new Dimension(33, 25));
			jpPSW = new JPanel();
			jpPSW.setLayout(null);
			jpPSW.setLocation(new Point(0, 65));
			jpPSW.setSize(new Dimension(250, 25));
			jpPSW.add(jlPSW, null);
			jpPSW.add(getJpPSWS(), null);
		}
		return jpPSW;
	}

	/**
	 * This method initializes jpPrinter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpPrinter() {
		if (jpPrinter == null) {
			BorderLayout borderLayout2 = new BorderLayout();
			borderLayout2.setVgap(3);
			jpPrinter = new JPanel();
			jpPrinter.setLayout(borderLayout2);
			jpPrinter.setLocation(new Point(10, 10));
			jpPrinter.setSize(new Dimension(250, 240));
			jpPrinter.add(jlPrinter, BorderLayout.NORTH);
			jpPrinter.add(getJspPrinter(), BorderLayout.CENTER);
		}
		return jpPrinter;
	}

	/**
	 * This method initializes jpConsole	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpConsole() {
		if (jpConsole == null) {
			BorderLayout borderLayout1 = new BorderLayout();
			borderLayout1.setVgap(3);
			jpConsole = new JPanel();
			jpConsole.setLayout(borderLayout1);
			jpConsole.setSize(new Dimension(300, 350));
			jpConsole.setLocation(new Point(270, 10));
			jpConsole.add(jlConsole, BorderLayout.NORTH);
			jpConsole.add(getJspConsole(), BorderLayout.CENTER);
		}
		return jpConsole;
	}

	/**
	 * This method initializes jpInput	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpInput() {
		if (jpInput == null) {
			jpInput = new JPanel();
			jpInput.setLayout(new BorderLayout());
			jpInput.setLocation(new Point(270, 490));
			jpInput.setSize(new Dimension(300, 45));
			jpInput.add(getJtfInput(), BorderLayout.CENTER);
			jpInput.add(getJbOK_Button(), BorderLayout.EAST);
			jpInput.add(jlInput, BorderLayout.NORTH);
		}
		return jpInput;
	}

	/**
	 * This method initializes jpIR	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpIR() {
		if (jpIR == null) {
			jlIR = new JLabel();
			jlIR.setLocation(new Point(0, 0));
			jlIR.setPreferredSize(new Dimension(16, 25));
			jlIR.setHorizontalAlignment(SwingConstants.LEFT);
			jlIR.setHorizontalTextPosition(SwingConstants.LEFT);
			jlIR.setText("IR");
			jlIR.setSize(new Dimension(25, 25));
			jpIR = new JPanel();
			jpIR.setLayout(null);
			jpIR.setLocation(new Point(0, 125));
			jpIR.setSize(new Dimension(250, 25));
			jpIR.add(jlIR, null);
			jpIR.add(getJtfIR(), null);
		}
		return jpIR;
	}

	/**
	 * This method initializes jtfR	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfIR() {
		if (jtfIR == null) {
			jtfIR = new JTextField();
			jtfIR.setLocation(new Point(40, 0));
			jtfIR.setEditable(false);
			jtfIR.setHorizontalAlignment(JTextField.RIGHT);
			jtfIR.setSize(new Dimension(205, 25));
		}
		return jtfIR;
	}

	/**
	 * This method initializes jpR0	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR0() {
		if (jpR0 == null) {
			jlR0 = new JLabel();
			jlR0.setLocation(new Point(0, 0));
			jlR0.setPreferredSize(new Dimension(16, 25));
			jlR0.setHorizontalAlignment(SwingConstants.LEFT);
			jlR0.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR0.setText("  R0");
			jlR0.setSize(new Dimension(25, 25));
			jpR0 = new JPanel();
			jpR0.setLayout(null);
			jpR0.setLocation(new Point(0, 155));
			jpR0.setSize(new Dimension(125, 25));
			jpR0.add(jlR0, null);
			jpR0.add(getJtfR0(), null);
		}
		return jpR0;
	}

	/**
	 * This method initializes jtfR0	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR0() {
		if (jtfR0 == null) {
			jtfR0 = new JTextField();
			jtfR0.setLocation(new Point(40, 0));
			jtfR0.setEditable(false);
			jtfR0.setHorizontalAlignment(JTextField.RIGHT);
			jtfR0.setSize(new Dimension(80, 25));
		}
		return jtfR0;
	}

	/**
	 * This method initializes jpR1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR1() {
		if (jpR1 == null) {
			jlR1 = new JLabel();
			jlR1.setLocation(new Point(0, 0));
			jlR1.setPreferredSize(new Dimension(16, 25));
			jlR1.setHorizontalAlignment(SwingConstants.LEFT);
			jlR1.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR1.setText("  R1");
			jlR1.setSize(new Dimension(25, 25));
			jpR1 = new JPanel();
			jpR1.setLayout(null);
			jpR1.setLocation(new Point(125, 155));
			jpR1.setSize(new Dimension(125, 25));
			jpR1.add(jlR1, null);
			jpR1.add(getJtfR1(), null);
		}
		return jpR1;
	}

	/**
	 * This method initializes jtfR1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR1() {
		if (jtfR1 == null) {
			jtfR1 = new JTextField();
			jtfR1.setLocation(new Point(40, 0));
			jtfR1.setEditable(false);
			jtfR1.setHorizontalAlignment(JTextField.RIGHT);
			jtfR1.setSize(new Dimension(80, 25));
		}
		return jtfR1;
	}

	/**
	 * This method initializes jpR2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR2() {
		if (jpR2 == null) {
			jlR2 = new JLabel();
			jlR2.setLocation(new Point(0, 0));
			jlR2.setPreferredSize(new Dimension(16, 25));
			jlR2.setHorizontalAlignment(SwingConstants.LEFT);
			jlR2.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR2.setText("  R2");
			jlR2.setSize(new Dimension(25, 25));
			jpR2 = new JPanel();
			jpR2.setLayout(null);
			jpR2.setLocation(new Point(0, 185));
			jpR2.setSize(new Dimension(125, 25));
			jpR2.add(jlR2, null);
			jpR2.add(getJtfR2(), null);
		}
		return jpR2;
	}

	/**
	 * This method initializes jtfR2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR2() {
		if (jtfR2 == null) {
			jtfR2 = new JTextField();
			jtfR2.setLocation(new Point(40, 0));
			jtfR2.setEditable(false);
			jtfR2.setHorizontalAlignment(JTextField.RIGHT);
			jtfR2.setSize(new Dimension(80, 25));
		}
		return jtfR2;
	}

	/**
	 * This method initializes jpR3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR3() {
		if (jpR3 == null) {
			jlR3 = new JLabel();
			jlR3.setLocation(new Point(0, 0));
			jlR3.setPreferredSize(new Dimension(16, 25));
			jlR3.setHorizontalAlignment(SwingConstants.LEFT);
			jlR3.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR3.setText("  R3");
			jlR3.setSize(new Dimension(25, 25));
			jpR3 = new JPanel();
			jpR3.setLayout(null);
			jpR3.setLocation(new Point(125, 185));
			jpR3.setSize(new Dimension(125, 25));
			jpR3.add(jlR3, null);
			jpR3.add(getJtfR3(), null);
		}
		return jpR3;
	}

	/**
	 * This method initializes jtfR3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR3() {
		if (jtfR3 == null) {
			jtfR3 = new JTextField();
			jtfR3.setLocation(new Point(40, 0));
			jtfR3.setEditable(false);
			jtfR3.setHorizontalAlignment(JTextField.RIGHT);
			jtfR3.setSize(new Dimension(80, 25));
		}
		return jtfR3;
	}

	/**
	 * This method initializes jpR4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR4() {
		if (jpR4 == null) {
			jlR4 = new JLabel();
			jlR4.setLocation(new Point(0, 0));
			jlR4.setPreferredSize(new Dimension(16, 25));
			jlR4.setHorizontalAlignment(SwingConstants.LEFT);
			jlR4.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR4.setText("  R4");
			jlR4.setSize(new Dimension(25, 25));
			jpR4 = new JPanel();
			jpR4.setLayout(null);
			jpR4.setLocation(new Point(0, 215));
			jpR4.setSize(new Dimension(125, 25));
			jpR4.add(jlR4, null);
			jpR4.add(getJtfR4(), null);
		}
		return jpR4;
	}

	/**
	 * This method initializes jtfR4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR4() {
		if (jtfR4 == null) {
			jtfR4 = new JTextField();
			jtfR4.setLocation(new Point(40, 0));
			jtfR4.setEditable(false);
			jtfR4.setHorizontalAlignment(JTextField.RIGHT);
			jtfR4.setSize(new Dimension(80, 25));
		}
		return jtfR4;
	}

	/**
	 * This method initializes jpR5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR5() {
		if (jpR5 == null) {
			jlR5 = new JLabel();
			jlR5.setLocation(new Point(0, 0));
			jlR5.setPreferredSize(new Dimension(16, 25));
			jlR5.setHorizontalAlignment(SwingConstants.LEFT);
			jlR5.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR5.setText("  R5");
			jlR5.setSize(new Dimension(25, 25));
			jpR5 = new JPanel();
			jpR5.setLayout(null);
			jpR5.setLocation(new Point(125, 215));
			jpR5.setSize(new Dimension(125, 25));
			jpR5.add(jlR5, null);
			jpR5.add(getJtfR5(), null);
		}
		return jpR5;
	}

	/**
	 * This method initializes jtfR5	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR5() {
		if (jtfR5 == null) {
			jtfR5 = new JTextField();
			jtfR5.setLocation(new Point(40, 0));
			jtfR5.setEditable(false);
			jtfR5.setHorizontalAlignment(JTextField.RIGHT);
			jtfR5.setSize(new Dimension(80, 25));
		}
		return jtfR5;
	}

	/**
	 * This method initializes jpR6	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR6() {
		if (jpR6 == null) {
			jlR6 = new JLabel();
			jlR6.setLocation(new Point(0, 0));
			jlR6.setPreferredSize(new Dimension(16, 25));
			jlR6.setHorizontalAlignment(SwingConstants.LEFT);
			jlR6.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR6.setText("  R6");
			jlR6.setSize(new Dimension(25, 25));
			jpR6 = new JPanel();
			jpR6.setLayout(null);
			jpR6.setLocation(new Point(0, 245));
			jpR6.setSize(new Dimension(125, 25));
			jpR6.add(jlR6, null);
			jpR6.add(getJtfR6(), null);
		}
		return jpR6;
	}

	/**
	 * This method initializes jtfR6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR6() {
		if (jtfR6 == null) {
			jtfR6 = new JTextField();
			jtfR6.setLocation(new Point(40, 0));
			jtfR6.setEditable(false);
			jtfR6.setHorizontalAlignment(JTextField.RIGHT);
			jtfR6.setSize(new Dimension(80, 25));
		}
		return jtfR6;
	}

	/**
	 * This method initializes jpR7	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpR7() {
		if (jpR7 == null) {
			jlR7 = new JLabel();
			jlR7.setLocation(new Point(0, 0));
			jlR7.setPreferredSize(new Dimension(16, 25));
			jlR7.setHorizontalAlignment(SwingConstants.LEFT);
			jlR7.setHorizontalTextPosition(SwingConstants.LEFT);
			jlR7.setText("  R7");
			jlR7.setSize(new Dimension(25, 25));
			jpR7 = new JPanel();
			jpR7.setLayout(null);
			jpR7.setLocation(new Point(125, 245));
			jpR7.setSize(new Dimension(125, 25));
			jpR7.add(jlR7, null);
			jpR7.add(getJtfR7(), null);
		}
		return jpR7;
	}

	/**
	 * This method initializes jtfR7	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfR7() {
		if (jtfR7 == null) {
			jtfR7 = new JTextField();
			jtfR7.setLocation(new Point(40, 0));
			jtfR7.setEditable(false);
			jtfR7.setHorizontalAlignment(JTextField.RIGHT);
			jtfR7.setSize(new Dimension(80, 25));
		}
		return jtfR7;
	}

	/**
	 * This method initializes jspConsole	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJspConsole() {
		if (jspConsole == null) {
			jspConsole = new JScrollPane();
			jspConsole.setViewportView(getJtaConsole());
		}
		return jspConsole;
	}

	/**
	 * This method initializes jspPrinter	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJspPrinter() {
		if (jspPrinter == null) {
			jspPrinter = new JScrollPane();
			jspPrinter.setViewportView(getJtaPrinter());
		}
		return jspPrinter;
	}

	/**
	 * This method initializes jpProcessEditer	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpProcessEditer() {
		if (jpProcessEditer == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(3);
			jlProcessEditer = new JLabel();
			jlProcessEditer.setText("Assemble Language Editor");
			jlProcessEditer.setPreferredSize(new Dimension(152, 20));
			jpProcessEditer = new JPanel();
			jpProcessEditer.setLayout(borderLayout);
			jpProcessEditer.setLocation(new Point(580, 10));
			jpProcessEditer.setSize(new Dimension(250, 390));
			jpProcessEditer.add(getJpButtons(), BorderLayout.SOUTH);
			jpProcessEditer.add(jlProcessEditer, BorderLayout.NORTH);
			jpProcessEditer.add(getJspProcessEditer(), BorderLayout.CENTER);
		}
		return jpProcessEditer;
	}

	/**
	 * This method initializes jspProcessEditer	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJspProcessEditer() {
		if (jspProcessEditer == null) {
			jspProcessEditer = new JScrollPane();
			jspProcessEditer.setViewportView(getJtaProcessEditer());
		}
		return jspProcessEditer;
	}

	/**
	 * This method initializes jtaProcessEditer	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJtaProcessEditer() {
		if (jtaProcessEditer == null) {
			jtaProcessEditer = new JTextArea();
			jtaProcessEditer.setText("");
			jtaProcessEditer.setLineWrap(true);
			jtaProcessEditer.setWrapStyleWord(true);
			jtaProcessEditer.setEditable(true);
		}
		return jtaProcessEditer;
	}

	/**
	 * This method initializes jpReadyQueue	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpReadyQueue() {
		if (jpReadyQueue == null) {
			jlReadyQueue = new JLabel();
			jlReadyQueue.setText("Ready Process: ");
			jlReadyQueue.setPreferredSize(new Dimension(100, 25));
			jpReadyQueue = new JPanel();
			jpReadyQueue.setSize(new Dimension(300, 25));
			jpReadyQueue.setLocation(new Point(0, 0));
			jpReadyQueue.setLayout(new BorderLayout());
			jpReadyQueue.add(jlReadyQueue, BorderLayout.WEST);
			jpReadyQueue.add(getJtfReadyQueue(), BorderLayout.CENTER);
		}
		return jpReadyQueue;
	}

	/**
	 * This method initializes jtfReadyQueue	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfReadyQueue() {
		if (jtfReadyQueue == null) {
			jtfReadyQueue = new JTextField();
			jtfReadyQueue.setEditable(false);
			jtfReadyQueue.setHorizontalAlignment(JTextField.RIGHT);
		}
		return jtfReadyQueue;
	}

	/**
	 * This method initializes jpInputQueue	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpInputQueue() {
		if (jpInputQueue == null) {
			jlInputQueue = new JLabel();
			jlInputQueue.setText("Input Process:    ");
			jlInputQueue.setPreferredSize(new Dimension(100, 25));
			jpInputQueue = new JPanel();
			jpInputQueue.setLayout(new BorderLayout());
			jpInputQueue.setLocation(new Point(0, 30));
			jpInputQueue.setSize(new Dimension(300, 25));
			jpInputQueue.add(jlInputQueue, BorderLayout.WEST);
			jpInputQueue.add(getJtfInputQueue(), BorderLayout.CENTER);
		}
		return jpInputQueue;
	}

	/**
	 * This method initializes jtfInputQueue	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfInputQueue() {
		if (jtfInputQueue == null) {
			jtfInputQueue = new JTextField();
			jtfInputQueue.setEditable(false);
			jtfInputQueue.setHorizontalAlignment(JTextField.RIGHT);
		}
		return jtfInputQueue;
	}

	/**
	 * This method initializes jpPrintQueue	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpPrintQueue() {
		if (jpPrintQueue == null) {
			jlPrintQueue = new JLabel();
			jlPrintQueue.setText("Print Process: ");
			jlPrintQueue.setPreferredSize(new Dimension(100, 25));
			jpPrintQueue = new JPanel();
			jpPrintQueue.setLayout(new BorderLayout());
			jpPrintQueue.setSize(new Dimension(300, 25));
			jpPrintQueue.setLocation(new Point(0, 60));
			jpPrintQueue.add(jlPrintQueue, BorderLayout.WEST);
			jpPrintQueue.add(getJtfPrintQueue(), BorderLayout.CENTER);
		}
		return jpPrintQueue;
	}

	/**
	 * This method initializes jtfPrintQueue	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfPrintQueue() {
		if (jtfPrintQueue == null) {
			jtfPrintQueue = new JTextField();
			jtfPrintQueue.setEditable(false);
			jtfPrintQueue.setHorizontalAlignment(JTextField.RIGHT);
		}
		return jtfPrintQueue;
	}

	/**
	 * This method initializes jpQueueMoniter	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpQueueMoniter() {
		if (jpQueueMoniter == null) {
			jpQueueMoniter = new JPanel();
			jpQueueMoniter.setLayout(null);
			jpQueueMoniter.setLocation(new Point(270, 380));
			jpQueueMoniter.setSize(new Dimension(300, 85));
			jpQueueMoniter.add(getJpPrintQueue(), null);
			jpQueueMoniter.add(getJpReadyQueue(), null);
			jpQueueMoniter.add(getJpInputQueue(), null);
		}
		return jpQueueMoniter;
	}

	/**
	 * This method initializes jpButtons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpButtons() {
		if (jpButtons == null) {
			jpButtons = new JPanel();
			jpButtons.setLayout(null);
			jpButtons.setPreferredSize(new Dimension(250, 55));
			jpButtons.add(getJbExecute(), null);
			jpButtons.add(getJbSave(), null);
			jpButtons.add(getJbLoad(), null);
			jpButtons.add(getJbClear(), null);
		}
		return jpButtons;
	}

	/**
	 * This method initializes jbExecute	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbExecute() {
		if (jbExecute == null) {
			jbExecute = new JButton();
			jbExecute.setText("Execute");
			jbExecute.setSize(new Dimension(150, 25));
			jbExecute.setLocation(new Point(50, 30));
			jbExecute.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					mem.addProcess(new BufferedReader(new StringReader(getJtaProcessEditer().getText())));
				}
			});
		}
		return jbExecute;
	}

	/**
	 * This method initializes jbSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbSave() {
		if (jbSave == null) {
			jbSave = new JButton();
			jbSave.setText("Save");
			jbSave.setSize(new Dimension(70, 25));
			jbSave.setLocation(new Point(90, 0));
			jbSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser("./");
					chooser.addChoosableFileFilter(new FileNameExtensionFilter("Assemble Language File", "asm", "jii"));
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setMultiSelectionEnabled(false);
					int option = chooser.showSaveDialog(UI.this);
					if(option == JFileChooser.APPROVE_OPTION) {
						File file = chooser.getSelectedFile();
						if(file != null) {
							try {
								file.createNewFile();
								FileWriter writer = new FileWriter(file, false);
								writer.write(getJtaProcessEditer().getText());
								writer.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return jbSave;
	}

	/**
	 * This method initializes jbLoad	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbLoad() {
		if (jbLoad == null) {
			jbLoad = new JButton();
			jbLoad.setPreferredSize(new Dimension(70, 30));
			jbLoad.setMnemonic(KeyEvent.VK_UNDEFINED);
			jbLoad.setLocation(new Point(170, 0));
			jbLoad.setSize(new Dimension(70, 25));
			jbLoad.setText("Load");
			jbLoad.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser("./");
					chooser.addChoosableFileFilter(new FileNameExtensionFilter("Assemble Language File", "asm", "jii"));
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setMultiSelectionEnabled(false);
					int option = chooser.showOpenDialog(UI.this);
					if(option == JFileChooser.APPROVE_OPTION) {
						File file = chooser.getSelectedFile();
						if(file.exists()) {
							try {
								BufferedReader reader = new BufferedReader(new FileReader(file));
								String s;
								getJtaProcessEditer().setText("");
								while((s = reader.readLine()) != null)
									getJtaProcessEditer().append(s + '\n');
								reader.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return jbLoad;
	}

	/**
	 * This method initializes jbClear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbClear() {
		if (jbClear == null) {
			jbClear = new JButton();
			jbClear.setText("Clear");
			jbClear.setLocation(new Point(10, 0));
			jbClear.setSize(new Dimension(70, 25));
			jbClear.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJtaProcessEditer().setText("");
				}
			});
		}
		return jbClear;
	}
	
	public void setParameters(PCB pcb, SynchronizedQueue readyQueue, SynchronizedQueue inputQueue, SynchronizedQueue printQueue, Keyboard keyboard, Memory mem) {
		
		this.pcb = pcb;
		this.readyQueue = readyQueue;
		this.inputQueue = inputQueue;
		this.printQueue = printQueue;
		//this.keyboard = keyboard;
		this.mc = keyboard.getMc();
		this.mem = mem;
		
	}
	
	public void updatePCB() {
		
		getJtfProcessID().setText(new Integer(pcb.getProcessID()).toString());
		getJtfPC().setText(pcb.getRegisters().getPc().toString());
		getJtfAC().setText(pcb.getRegisters().getAc().toString());
		int n = pcb.getRegisters().getPsw().getState();
		int m = HALT;
		for(int j = 0; j < jlPSWs.length; j++) {
			jlPSWs[j].setText((n & m) == 0 ? "0" : "1");
			m /= 2;
		}
		getJtfIR().setText(pcb.getRegisters().getIr().toString());
		getJtfR0().setText(pcb.getRegisters().getRn(0).toString());
		getJtfR1().setText(pcb.getRegisters().getRn(1).toString());
		getJtfR2().setText(pcb.getRegisters().getRn(2).toString());
		getJtfR3().setText(pcb.getRegisters().getRn(3).toString());
		getJtfR4().setText(pcb.getRegisters().getRn(4).toString());
		getJtfR5().setText(pcb.getRegisters().getRn(5).toString());
		getJtfR6().setText(pcb.getRegisters().getRn(6).toString());
		getJtfR7().setText(pcb.getRegisters().getRn(7).toString());
		
	}
	
	public void updateQueue() {
		
		getJtfReadyQueue().setText(readyQueue.toString());
		getJtfInputQueue().setText(inputQueue.toString());
		getJtfPrintQueue().setText(printQueue.toString());
		
	}
	
	public void setJlInputText(String s) {
		
		jlInput.setText("Input" + s);
		
	}
	
	public synchronized void print(String s) {
		
		getJtaPrinter().append(s);
		
	}
	
	public synchronized void clearPrinter() {
		
		getJtaPrinter().setText("");
		
	}
	
	public synchronized void display(String s) {
		
		getJtaConsole().append(s + '\n');
		
	}

	/**
	 * This method initializes jpPSWS	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpPSWS() {
		if (jpPSWS == null) {
			jpPSWS = new JPanel();
			jpPSWS.setLayout(new GridBagLayout());
			jpPSWS.setLocation(new Point(40, 0));
			jpPSWS.setSize(new Dimension(205, 25));
			for(int i = 0; i < jlPSWs.length; i++) {
				jlPSWs[i] = new JLabel();
				jlPSWs[i].setHorizontalAlignment(SwingConstants.RIGHT);
				jlPSWs[i].setHorizontalTextPosition(SwingConstants.RIGHT);
				jlPSWs[i].setText("");
				jlPSWs[i].setBorder(BorderFactory.createLineBorder(Color.lightGray, 1));
				jlPSWs[i].setPreferredSize(new Dimension(25, 22));
				jpPSWS.add(jlPSWs[i], null);
			}
		}
		return jpPSWS;
	}

	/**
	 * This method initializes jpControll	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpControll() {
		if (jpControll == null) {
			jlControllButton = new JLabel();
			jlControllButton.setText("Controll Buttons");
			jlControllButton.setPreferredSize(new Dimension(34, 20));
			jpControll = new JPanel();
			jpControll.setLayout(new BorderLayout());
			jpControll.setSize(new Dimension(250, 120));
			jpControll.setLocation(new Point(580, 415));
			jpControll.add(jlControllButton, BorderLayout.NORTH);
			jpControll.add(getJpControllButton(), BorderLayout.CENTER);
		}
		return jpControll;
	}

	/**
	 * This method initializes jpControllButton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpControllButton() {
		if (jpControllButton == null) {
			jpControllButton = new JPanel();
			jpControllButton.setLayout(null);
			jpControllButton.add(getJpMunal(), null);
			jpControllButton.add(getJpAuto(), null);
			ButtonGroup bg = new ButtonGroup();
			bg.add(getJrbAutoMode());
			bg.add(getJrbManualMode());
		}
		return jpControllButton;
	}

	/**
	 * This method initializes jpAutoMode	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpAutoMode() {
		if (jpAutoMode == null) {
			jlAutoMode = new JLabel();
			jlAutoMode.setText("Auto");
			jlAutoMode.setHorizontalTextPosition(SwingConstants.CENTER);
			jlAutoMode.setHorizontalAlignment(SwingConstants.CENTER);
			jpAutoMode = new JPanel();
			jpAutoMode.setLayout(new BorderLayout());
			jpAutoMode.setPreferredSize(new Dimension(75, 25));
			jpAutoMode.add(getJrbAutoMode(), BorderLayout.WEST);
			jpAutoMode.add(jlAutoMode, java.awt.BorderLayout.CENTER);
		}
		return jpAutoMode;
	}

	/**
	 * This method initializes jrbAutoMode	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJrbAutoMode() {
		if (jrbAutoMode == null) {
			jrbAutoMode = new JRadioButton();
			jrbAutoMode.setSelected(true);
			jrbAutoMode.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJbNext().setEnabled(false);
					getJtfAuto().setEnabled(true);
					mode.setMode(RunningMode.AUTO);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jrbAutoMode;
	}

	/**
	 * This method initializes jpManualMode	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpManualMode() {
		if (jpManualMode == null) {
			jlManualMode = new JLabel();
			jlManualMode.setHorizontalAlignment(SwingConstants.CENTER);
			jlManualMode.setText("Manual");
			jlManualMode.setHorizontalTextPosition(SwingConstants.CENTER);
			jpManualMode = new JPanel();
			jpManualMode.setLayout(new BorderLayout());
			jpManualMode.setPreferredSize(new Dimension(75, 25));
			jpManualMode.add(getJrbManualMode(), BorderLayout.WEST);
			jpManualMode.add(jlManualMode, BorderLayout.CENTER);
		}
		return jpManualMode;
	}

	/**
	 * This method initializes jrbManualMode	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJrbManualMode() {
		if (jrbManualMode == null) {
			jrbManualMode = new JRadioButton();
			jrbManualMode.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJbNext().setEnabled(true);
					getJtfAuto().setEnabled(false);
					mode.setMode(RunningMode.MANUAL);
					//System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jrbManualMode;
	}

	/**
	 * This method initializes jbNext	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJbNext() {
		if (jbNext == null) {
			jbNext = new JButton();
			jbNext.setPreferredSize(new Dimension(75, 25));
			jbNext.setEnabled(false);
			jbNext.setText("Next");
			jbNext.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getJbNext().setEnabled(false);
					mode.setButtonPressed(true);
					System.out.println("actionPerformed()"); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return jbNext;
	}

	/**
	 * This method initializes jtfAuto	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJtfAuto() {
		if (jtfAuto == null) {
			jtfAuto = new JTextField();
			jtfAuto.setPreferredSize(new Dimension(75, 25));
			jtfAuto.setHorizontalAlignment(JTextField.TRAILING);
			jtfAuto.setToolTipText("Should be a value between 1 to 20");
			jtfAuto.setText("2");
		}
		return jtfAuto;
	}

	/**
	 * This method initializes jpMunal	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpMunal() {
		if (jpMunal == null) {
			jlManual = new JLabel();
			jlManual.setText("Press next to run step by step");
			jpMunal = new JPanel();
			jpMunal.setLayout(new BorderLayout());
			jpMunal.setLocation(new Point(40, 50));
			jpMunal.setSize(new Dimension(170, 45));
			jpMunal.add(getJpManualMode(), BorderLayout.WEST);
			jpMunal.add(getJbNext(), BorderLayout.EAST);
			jpMunal.add(jlManual, BorderLayout.NORTH);
		}
		return jpMunal;
	}

	/**
	 * This method initializes jpAuto	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJpAuto() {
		if (jpAuto == null) {
			jlAuto = new JLabel();
			jlAuto.setText("Set the frequency of the cpu");
			jpAuto = new JPanel();
			jpAuto.setLayout(new BorderLayout());
			jpAuto.setLocation(new Point(40, 5));
			jpAuto.setSize(new Dimension(170, 45));
			jpAuto.add(getJpAutoMode(), BorderLayout.WEST);
			jpAuto.add(getJtfAuto(), BorderLayout.EAST);
			jpAuto.add(jlAuto, BorderLayout.NORTH);
		}
		return jpAuto;
	}

	/**
	 * Return the mode.
	 */
	
	public RunningMode getMode() {
	
		return mode;
	
	}

	/**
	 * Reset the mode.
	 */
	
	public void setMode(RunningMode mode) {
	
		this.mode = mode;
	
	}
	
	public int getSleepTime() {
		
		String s = getJtfAuto().getText();
		int i;
		try {
			i = Integer.parseInt(s);
		}
		catch (NumberFormatException ex) {
			i = 2;
		}
		
		if(i < 1 || i > 20)
			i = 2;
		
		//display("CPU frequency set to be " + new Integer(i).toString());
		
		return (int) (1000 / i);
		
	}
	
	public void enableButton() {
		synchronized (mode) {
			mode.setButtonPressed(false);
			if(mode.getMode() == RunningMode.MANUAL)
				getJbNext().setEnabled(true);
		}
	}

}  //  @jve:decl-index=0:visual-constraint="-27,-42"
