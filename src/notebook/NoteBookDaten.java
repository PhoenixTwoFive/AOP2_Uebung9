package notebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class NoteBookDaten {
	private Map<String, String> notesMap;
	
	public NoteBookDaten(){
		notesMap = new HashMap<String, String>();
	}
	
	public void setzeTermin(String key, String value){
		notesMap.put(key, value);
	}
	public String leseTermin(String key){
		return notesMap.get(key);
	}
	public void loescheTermin(String key){
		
	}
	
	public void loescheAlles(){
		notesMap.clear();
	}
	@Override
	public String toString(){
		return notesMap.toString();
	}
	
	public void saveToFile(String filename) throws IOException{
		OutputStream os = new FileOutputStream(filename);
		ObjectOutput oo = new ObjectOutputStream(os);
		oo.writeObject(notesMap);
		os.close();
	}
	
	public void loadFromFile(String filename) throws ClassNotFoundException, IOException{
		InputStream is = new FileInputStream(filename);
		ObjectInput oi = new ObjectInputStream(is);
		notesMap = (HashMap<String,String>) oi.readObject();
		
	}
}
