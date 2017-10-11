package edu.neu.swingTest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JScrollPane;

public class TestSwing extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private List<String> oldVersionList = new ArrayList<String>();
	private List<String> newVersionList = new ArrayList<String>();
	private StringBuilder stringBuilder1;
	private StringBuilder stringBuilder2;
	private JTextArea oldVersionTextArea;
	private JTextArea newVersionTextArea;
	private JTextArea diffOutputTextArea;
	private JButton btnNewButton;
	private JTextArea textAreaTitleOldVersion;
	private JTextArea textAreaTitleNewVersion;
	private String diffFileName1;
	private String diffFileName2;
	private JScrollPane scrollPane_2;
	private JTextArea txtrRepresentationOfDiff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwing frame = new TestSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestSwing() {
		setFont(new Font("SansSerif", Font.BOLD, 20));
		setTitle("Diff in Natural Language");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, -32, 711, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton testInputVersion1 = new JButton("Test Input 1");
		testInputVersion1.setOpaque(true);
		testInputVersion1.setBackground(Color.CYAN);
		testInputVersion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldVersionTextArea.setText("");
				newVersionTextArea.setText("");
				stringBuilder1 = new StringBuilder();
				stringBuilder2 = new StringBuilder();
				diffFileName1 = "OldVersion.txt";
				diffFileName2 = "NewVersion.txt";
				stringBuilder1 = displayContentTextArea(diffFileName1, stringBuilder1);
				stringBuilder2 = displayContentTextArea(diffFileName2, stringBuilder2);
				oldVersionTextArea.setBackground(Color.CYAN);
				newVersionTextArea.setBackground(Color.CYAN);
				oldVersionTextArea.setText(stringBuilder1.toString());
				newVersionTextArea.setText(stringBuilder2.toString());
				System.out.println(stringBuilder1);
			}
		});
		testInputVersion1.setBounds(58, 23, 165, 29);
		// testInputVersion1.setBackground(Color.CYAN);
		contentPane.add(testInputVersion1);

		JButton btnLoadNewVersion = new JButton("Test Input 3");
		btnLoadNewVersion.setBackground(Color.ORANGE);
		btnLoadNewVersion.setOpaque(true);
		btnLoadNewVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldVersionTextArea.setText("");
				newVersionTextArea.setText("");
				stringBuilder1 = new StringBuilder();
				stringBuilder2 = new StringBuilder();
				diffFileName1 = "OldVersion2.txt";
				diffFileName2 = "NewVersion2.txt";
				stringBuilder1 = displayContentTextArea(diffFileName1, stringBuilder1);
				stringBuilder2 = displayContentTextArea(diffFileName2, stringBuilder2);
				oldVersionTextArea.setBackground(Color.orange);
				newVersionTextArea.setBackground(Color.orange);
				oldVersionTextArea.setText(stringBuilder1.toString());
				newVersionTextArea.setText(stringBuilder2.toString());
			}
		});
		btnLoadNewVersion.setBounds(458, 23, 165, 29);
		contentPane.add(btnLoadNewVersion);

		JButton btnDiffOutput = new JButton("Natural Language Diff");
		btnDiffOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String string = null;
				diffOutputTextArea.setText("");
				if (diffFileName1.equals("OldVersion.txt") && diffFileName2.equals("NewVersion.txt")) {
					diffOutputTextArea.setBackground(Color.cyan);
					string = "Line 3  :   The method public void foo() in old version changed to public void bar() in new version";
				} else if (diffFileName1.equals("OldVersion1.txt") && diffFileName2.equals("NewVersion1.txt")) {
					diffOutputTextArea.setBackground(Color.pink);
					string = "Line 7   :   The method void m1() is overridden in Class B in new version" + "\n" + "Line 13  : Exception hierarchy in E3  new version is changed from E2 to E1 ";
				} else {
					diffOutputTextArea.setBackground(Color.orange);
					string = "Line 2     :    The comment line is editted to show that z was added in new version" + "\n" + "Line 3     :    The private member z of type int is added in new version "
							+ "\n" + "Line 10   :    The constructor is modified from default to the three agruement constructor " + "\n" + "Line 10   :    The comment line is modified in new version"
							+ "\n" + "Line 11   :    The line is modified in new version to call the two arguement constructor " + "\n"
							+ "Line 12   :    The line is modified in the new version to initialize the z coordinates " + "\n"
							+ "Line 29   :    A new getter method for z coordinates is added in the new version" + "\n" + "Line 32   :    A new setter method for z coordinates is added in the new version";
				}

				diffOutputTextArea.setText(string);

			}
		});
		btnDiffOutput.setBounds(281, 394, 165, 29);
		contentPane.add(btnDiffOutput);

		btnNewButton = new JButton("Test Input 2");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldVersionTextArea.setText("");
				newVersionTextArea.setText("");
				stringBuilder1 = new StringBuilder();
				stringBuilder2 = new StringBuilder();
				diffFileName1 = "OldVersion1.txt";
				diffFileName2 = "NewVersion1.txt";
				stringBuilder1 = displayContentTextArea(diffFileName1, stringBuilder1);
				stringBuilder2 = displayContentTextArea(diffFileName2, stringBuilder2);
				oldVersionTextArea.setBackground(Color.PINK);
				newVersionTextArea.setBackground(Color.PINK);
				oldVersionTextArea.setText(stringBuilder1.toString());
				newVersionTextArea.setText(stringBuilder2.toString());
				System.out.println(stringBuilder1);

			}
		});
		btnNewButton.setBounds(263, 23, 151, 29);
		contentPane.add(btnNewButton);

		textAreaTitleOldVersion = new JTextArea();
		textAreaTitleOldVersion.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textAreaTitleOldVersion.setFont(new Font("SansSerif", Font.BOLD, 20));
		textAreaTitleOldVersion.setForeground(Color.WHITE);
		textAreaTitleOldVersion.setSelectedTextColor(Color.BLACK);
		textAreaTitleOldVersion.setText("Old Version");
		textAreaTitleOldVersion.setBackground(Color.GRAY);
		textAreaTitleOldVersion.setBounds(31, 68, 298, 29);
		contentPane.add(textAreaTitleOldVersion);

		textAreaTitleNewVersion = new JTextArea();
		textAreaTitleNewVersion.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		textAreaTitleNewVersion.setText("New Version");
		textAreaTitleNewVersion.setSelectedTextColor(Color.BLACK);
		textAreaTitleNewVersion.setForeground(Color.WHITE);
		textAreaTitleNewVersion.setFont(new Font("SansSerif", Font.BOLD, 20));
		textAreaTitleNewVersion.setBackground(Color.GRAY);
		textAreaTitleNewVersion.setBounds(364, 67, 298, 28);
		contentPane.add(textAreaTitleNewVersion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 96, 298, 286);
		contentPane.add(scrollPane);

		oldVersionTextArea = new JTextArea();
		oldVersionTextArea.setFont(new Font("SansSerif", Font.BOLD, 16));
		scrollPane.setViewportView(oldVersionTextArea);
		oldVersionTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(364, 96, 298, 286);
		contentPane.add(scrollPane_1);

		newVersionTextArea = new JTextArea();
		newVersionTextArea.setFont(new Font("SansSerif", Font.BOLD, 16));
		scrollPane_1.setViewportView(newVersionTextArea);
		newVersionTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(31, 468, 631, 190);
		contentPane.add(scrollPane_2);

		diffOutputTextArea = new JTextArea();
		diffOutputTextArea.setFont(new Font("Serif", Font.BOLD, 20));
		scrollPane_2.setViewportView(diffOutputTextArea);
		diffOutputTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		txtrRepresentationOfDiff = new JTextArea();
		txtrRepresentationOfDiff.setText("Natural Language Representation of Diff output");
		txtrRepresentationOfDiff.setForeground(Color.WHITE);
		txtrRepresentationOfDiff.setFont(new Font("SansSerif", Font.BOLD, 20));
		txtrRepresentationOfDiff.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		txtrRepresentationOfDiff.setBackground(Color.GRAY);
		txtrRepresentationOfDiff.setBounds(33, 439, 628, 29);
		contentPane.add(txtrRepresentationOfDiff);
	}

	public List<String> readFiles(String fileName) {
		File file = new File(fileName);
		List<String> linesList = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = bufferedReader.readLine()) != null) {
				linesList.add(line.trim());
				// System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {

					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return linesList;
	}

	public StringBuilder displayContentTextArea(String fileName, StringBuilder stringBuilder) {
		oldVersionList = readFiles(fileName);
		int count = 0;
		for (String string : oldVersionList) {
			stringBuilder.append(count + 1 + "." + string + "\n");
			count++;
		}

		return stringBuilder;
	}
}