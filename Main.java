//Mitali Deshmukh & Aliya Shaikh; December 3, 2025
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main
{
	public static void main(String[] args)
	{

		//SingleThreaded
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
		System.out.println("Single Thread Time: "+time+ "ms.");


		//MultiThreaded

		start = System.nanoTime();

		ExecutorService executor = Executors.newFixedThreadPool(2);

		Future<?> task1 = executor.submit(() -> {
			convertFileToUpper(
				"Frankenstein.txt",
				"FrankensteinMulti.txt"
			);
		});

		 Future<?> task2 = executor.submit(() -> {
			convertFileToUpper(
				"PrideAndPrejudice.txt",
				"PrideAndPrejudiceMulti.txt"
			);
		});

		try {
			task1.get();
			task2.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		executor.shutdown();

		time = (System.nanoTime() - start) / 1_000_000;
		System.out.println("MultiThread Time: " + time + " ms.");


	}

	public static void convertFileToUpper(String inputFile, String outputFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line.toUpperCase());
				bw.newLine();
			}

			System.out.println("File converted to uppercase and saved as: " + outputFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}