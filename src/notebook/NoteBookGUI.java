package notebook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NoteBookGUI extends JFrame{
	private NoteBookDaten notes;
	
	//Komponenten
	private JPanel cp;	//contenPane
	JLabel wtaglabel;	//Beschriftung
	JComboBox<String> wtag;	//Combobox
	private String[] tage = {"Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag","Sonntag"};
	
	JButton endeButton, anzeigenButton, speichernButton, clearButton;
	JTextArea textArea;
	
	//Konstruktor
	public NoteBookGUI(){
		this.setTitle("Notizbuch");
		this.setLocation(100, 100);
		this.setSize(400,400);
		this.setResizable(false);
		//ContentPane
		cp = (JPanel) this.getContentPane();
		cp.setLayout(null);
		
		wtaglabel = new JLabel("Wochentag:");
		wtaglabel.setBounds(20,5,110,30);
		cp.add(wtaglabel);
		
		wtag = new JComboBox<String>(tage);
		wtag.setBounds(20,30,110,20);
		wtag.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(notes.leseTermin(wtag.getSelectedItem().toString()));
				System.out.println(wtag.getSelectedItem()+" wurde gewählt.");
			}
		});
		cp.add(wtag);
		
		anzeigenButton = new JButton("Anzeigen");
		anzeigenButton.setBounds(20, 60, 110, 20);
		anzeigenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(notes.leseTermin(wtag.getSelectedItem().toString()));
				System.out.println("Anzeigen wurde gedrückt ("+wtag.getSelectedItem().toString()+ ") :"+notes.toString());
			}
		});
		cp.add(anzeigenButton);
		
		speichernButton = new JButton("Speichern");
		speichernButton.setBounds(20, 90, 110, 20);
		speichernButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				notes.setzeTermin(wtag.getSelectedItem().toString(), textArea.getText());
				System.out.println("Speichern wurde gedrückt: "+notes.toString());
			}
		});
		cp.add(speichernButton);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(20, 120, 110, 20);
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Clear wurde gedrückt.");
			}
		});
		cp.add(clearButton);
		
		endeButton = new JButton("Ende");
		endeButton.setBounds(20, 150, 110, 20);
		endeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Beende...");
				System.exit(0);
				
			}
		});
		cp.add(endeButton);
		
		textArea = new JTextArea();
		textArea.setBounds(150, 30, 240, 250);
		cp.add(textArea);
		
		
	}
	
	public NoteBookDaten getNotes() {
		return notes;
	}

	public void setNotes(NoteBookDaten notes) {
		this.notes = notes;
	}
	
}
