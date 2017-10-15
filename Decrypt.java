import java.io.*;

/**
 * Decrypt will put the message into a 2d array then use
 * columnar transposition to decrypt the message.
 * @author Tim
 *
 */
public class Decrypt {

	private int row; //row of 2d array
	private int column; //column of 2d character array
	private char[][] message;
	private StringBuilder newMessage = new StringBuilder(); //the string with the encrypted message
	private int position; //index of the character I am copying into the array

	public Decrypt(String line) {
		
		column = Character.getNumericValue(line.charAt(1));//column is from the 2nd character in the txt file.
		row = (line.length() - 2) / column;
		position = 2; //starting from 2nd index of the txt file.
		message = new char[row][column];
		
		for (int j = 0; j < column; j++) {
			
			for (int i = 0; i < row; i++) {
				
				if (position < line.length() - 1) {

					message[i][j] = line.charAt(position); //places the message into the array
					position++;
					
				} else {
					
					message[i][j] = 'Z'; //fills up left over space with Z
					position++;
					
				}
				
			}
			
		}

		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < column; j++) {
				
				newMessage.append(message[i][j]); //This is to put the decrypted message into a String.
				
			}
			
		}

		for (int i = 0; i < row; i++) {
			
			for (int j = 0; j < column; j++) {
				
				System.out.print(message[i][j]); //Just for the user to see how the message looks like in the 2d array.
				
			}
			System.out.println();
			
		}
		
	}

	public void write() {
		
		String fileName = "DecryptedFile.txt";
		BufferedWriter bw = null;
		
		try {
			
			FileWriter fw = new FileWriter(fileName); //writes the message into a new text file.
			bw = new BufferedWriter(fw);
			bw.write(newMessage.toString());

		} catch (IOException ioe) {
			
			ioe.printStackTrace();
			
		} finally {
			
			try {
				
				if (bw != null) {
					
					bw.flush();
					bw.close();
					
				} else {
					
					System.out.println("Error in writing file.");
					
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}

	}
	
}
