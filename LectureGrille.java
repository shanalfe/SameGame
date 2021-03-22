/**
* @version 1.0
* @author Shana LEFEVRE & Arthur DECORBEZ
*/

import java.io.*;

public class LectureGrille
{
	public static final String ANSI_RESET	= "\u001B[0m";
	public static final String ANSI_RED		= "\u001B[31m";
	public static final String ANSI_GREEN	= "\u001B[32m";
	public static final String ANSI_BLUE	= "\u001B[34m";

	public LectureGrille(File file)
	{
		char tab[][] = new char[10][15];

		try
		{
			//File file = new File("./Grille/luc.gri");
			FileReader reader = new FileReader(file);

			try
			{
				// Lecture du fichier
				for(int j = 0; j < 10; j++)
				{
					for(int i = 0; i < 15; i++)
					{
						tab[j][i] = (char) reader.read();
					}
					reader.read();
				}

				// Affichage de tab[][] dans le terminal
				for(int j = 0; j < 10; j++)
				{
					for(int i = 0; i < 15; i++)
					{
						if(tab[j][i] == 'R')
						{
							System.out.print(ANSI_RED + tab[j][i] + ANSI_RESET);
						}
						else if(tab[j][i] == 'V')
						{
							System.out.print(ANSI_GREEN + tab[j][i] + ANSI_RESET);
						}
						else if(tab[j][i] == 'B')
						{
							System.out.print(ANSI_BLUE + tab[j][i] + ANSI_RESET);
						}
					}
					System.out.println("");
				}
			}
			catch(IOException e)
			{
				System.err.println("Impossible de lire dans le fichier reels.bin !");
			}

			try
			{
				reader.close();
			}
			catch(IOException e)
			{
				System.err.println("Impossible de fermer le fichier reels.bin !");
			}
		}
		catch(FileNotFoundException e)
		{
			System.err.println("Impossible d'ouvrir le fichier reels.bin en lecture !");
		}
	}
}