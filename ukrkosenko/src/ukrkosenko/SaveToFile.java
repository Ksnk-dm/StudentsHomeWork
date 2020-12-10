package ukrkosenko;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveToFile {
	  public static void savingGroupToDatabase(Group group) {
	        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream("group"))) {
	            write.writeObject(group);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public static Group ReadFromFile(String name){
		  Group group = null;
	        try (ObjectInputStream read = new ObjectInputStream(new FileInputStream("group"))) {
	            group = (Group) read.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return group;
	    }
	  }

