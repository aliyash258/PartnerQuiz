//Mitali Deshmukh & Aliya Shaikh; December 3, 2025
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		//Single Threaded Solution
		long start = System.nanoTime();

        String inputFile = "Frankenstein.txt";
        File file = new File("C:\\Users\\30000241\\Downloads\\GitKraken\\PartnerQuiz\\FrankensteinUpdated.txt");
        String outputFile = "FrakensteinUpdated.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)))
         {
			String line="";
            while ((line = br.readLine()) != null)
            {
                String[] words = line.split("\\s+");
                StringBuilder upperLine = new StringBuilder();
                for (String word : words) {
                    upperLine.append(word.toUpperCase()).append(" ");
                }

                bw.write(upperLine.toString().trim());
                bw.newLine();
            }

            System.out.println("File converted to uppercase and saved as: " + outputFile);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

		inputFile = "PrideAndPrejudice.txt";
		File file2 = new File("C:\\Users\\30000241\\Downloads\\GitKraken\\PartnerQuiz\\PrideAndPrejudiceUpdated.txt");
		outputFile = "PrideAndPrejudiceUpdated.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile)))
		 {
			String line="";
			while ((line = br.readLine()) != null)
			{
				String[] words = line.split("\\s+");
				StringBuilder upperLine = new StringBuilder();
				for (String word : words) {
					upperLine.append(word.toUpperCase()).append(" ");
				}

				bw.write(upperLine.toString().trim());
				bw.newLine();
			}

			System.out.println("File converted to uppercase and saved as: " + outputFile);

		}
		catch (IOException e) {
			e.printStackTrace();
		}

		long time = (System.nanoTime() - start)/1000000;
		System.out.println("Time: "+time+ "ms.");
	}
}