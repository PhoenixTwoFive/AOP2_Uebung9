package notebook;

public class NoteBookMain {
	private NoteBookGUI view;
	private NoteBookDaten notes;
	
	public NoteBookMain(){
		view = new NoteBookGUI();
		notes = new NoteBookDaten();
		view.setNotes(notes);
	}
	
	public void aktivieren(){
		view.setVisible(true);
	}
	
	public static void main(String[] args) {
		NoteBookMain notebook = new NoteBookMain();
		notebook.aktivieren();
	}
}
