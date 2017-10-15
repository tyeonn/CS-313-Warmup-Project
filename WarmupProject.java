import java.io.*;

/**
 * The WarmupProject will attempt to read a file and encrypt or decrypt the message.
 * 
 * @author Timothy Wu
 *
 */
public class WarmupProject {
	
	public static void main(String[] args) {
		
		String fileName = "CryptographyTextFile.txt";
		String line = null;
		
		try {
			
			//Opening the text file
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
				
				//Will encrypt the message if the first two characters of the line is in the right format.
				if (line.charAt(0) == 'e' || line.charAt(0) == 'E' && Character.isDigit(line.charAt(1))) {
					
					Encrypt eMessage = new Encrypt(line);
					//Will write the encrypted message to a text file.
					eMessage.write();
					
				//Will decrypt message if first two characters are in the right format.
				} else if (line.charAt(0) == 'd' || line.charAt(0) == 'D' && Character.isDigit(line.charAt(1))) {
					
					Decrypt dMessage = new Decrypt(line);
					//Will write the decrypted message to a text file.
					dMessage.write();
					
				} else {
					
					System.out.println("Error in reading the line");
					
				}
				
			}
			
			br.close();
			
		} catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		}

	}
	
}
