package notebook;

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
}
