package com.infoTech.testEngine.user.DAO;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.fail;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.error;
import static com.infoTech.testEngine.utils.ApplicationStatusConstants.success;
import static com.infoTech.testEngine.utils.MessageBundleReader.getConfigValue;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.infoTech.testEngine.user.DTO.UserDTO;
public class UserDAO {
   public String login(UserDTO userDTO) throws IOException, ClassNotFoundException{
		String message=error;
		FileInputStream fi=null;
		
		UserDTO userDTOFromFile=null;	
		ObjectInputStream oi=null;
	String filePath=getConfigValue("userfilepath");
		try
		{
			fi=new FileInputStream(filePath);
			oi=new ObjectInputStream(fi);
	
		while(true){
			try{
				
				userDTOFromFile=(UserDTO)oi.readObject();
			if(userDTO.equals(userDTOFromFile)){
				message=success;
				return message;
			}
			}
			catch(EOFException e){

				message=fail;
				return message;
			}
			
		}
		
		}
		finally{
			
			
			if(oi!=null){
				oi.close();
			}
			if(fi!=null){
				fi.close();
			}
			
		}
		
    	
    	
    	
   // 	return message;
    	
    }
   
   public ArrayList<UserDTO> fetchData() throws ClassNotFoundException, IOException{
	   ArrayList<UserDTO> userList=new ArrayList<>();
   
   String message=error;
   FileInputStream fi=null;
   ObjectInputStream oi=null;
   UserDTO userDTOFromFile=null;
   String filePath = getConfigValue("userfilepath"); 
   try{
	   fi=new FileInputStream(filePath);
	   oi=new ObjectInputStream(fi);
	   while(true){
		   try{
			   userDTOFromFile=(UserDTO)oi.readObject();
			   userList.add(userDTOFromFile);
		   }
		   catch(EOFException e){
			   message=fail;
			   return userList;
			   
		   }
	   }
   }
    catch(EOFException e){
    	
    	return userList;
    }
   finally{
	   
	   if(oi!=null){
		   oi.close();
	   }
	   if(fi!=null){
		   fi.close();
	   }
	   
   }
   
   }
   
   
   
   
	public String Register(UserDTO userDTO) throws IOException, ClassNotFoundException{
	String message=error;
	FileOutputStream fs =null;
	ObjectOutputStream os =null;
	
	String filePath = getConfigValue("userfilepath");
	File file = new File(filePath);
	try{
		if(!file.exists()){
			if(!file.createNewFile()){
				return message;
			}
		}
		if(file.exists()){
			 ArrayList<UserDTO> userList=this.fetchData();
			 
			 userList.add(userDTO);
			 fs = new FileOutputStream(file);
			
			os = new ObjectOutputStream(fs);
			for(UserDTO user: userList ){
			 os.writeObject(user);
			 }
			message = success;
		}
		}
		finally{
			if(os!=null){
				os.close();
			}
			if(fs!=null){
				fs.close();
			}
		}
		return message;
		
	
	
	
	
	
}
}
