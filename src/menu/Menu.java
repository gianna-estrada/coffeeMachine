/**
 * Contains the code to run the coffee machine menu.
 */
package menu;

import java.util.Scanner;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.InputMismatchException;

import coffeeType.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import exceptions.*;

/**
 * This class contains the menu for the coffee machine.
 * @author giannaestrada
 */
public class Menu {
	
	// List to contain all the coffee types
	static ArrayList<Coffee> coffees = new ArrayList<>();
	
	// English and Japanese Locales
	static Locale enLoc = new Locale("en", "IE");
	static Locale jaLoc = new Locale("ja", "JP");
	static ResourceBundle enBundle = ResourceBundle.getBundle("internationalization.trans", enLoc);
	static ResourceBundle jaBundle = ResourceBundle.getBundle("internationalization.trans", jaLoc);
	
	/**
	 * This method displays the main menu. It gives three choices: 
	 * Order Coffee, Switch Languages, Exit.
	 * @param bundle  Translation bundle
	 */
	public static void printMainMenu(ResourceBundle bundle) {
		
		System.out.println("------------------------");
		System.out.println("         " + bundle.getString("menu"));
		System.out.println("------------------------");
		System.out.println("1. " + bundle.getString("order"));
		System.out.println("2. " + bundle.getString("switch"));
		System.out.println("3. " + bundle.getString("exit"));
		System.out.println();
	}
		
	/**
	 * This method displays the menu for selecting a coffee.
	 * It gets the coffee types from the ArrayList called coffees
	 * from the start of the class.
	 * @param bundle  Translation bundle
	 */
	public static void printCoffeeMenu(ResourceBundle bundle) {
		System.out.println("------------------------");
		System.out.println("         " + bundle.getString("menu"));
		System.out.println("------------------------");
		// Loops through ArrayList
		for(Coffee coffee : coffees) {
			System.out.println(coffee.getName(bundle) + " | " + coffee.getDescription(bundle));
		}
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResourceBundle currentBundle = enBundle;
		Scanner in = new Scanner(System.in);
		int option;
		String coffeeChoice;
		
		// Populate the ArrayList with the coffee types
		coffees.add(new Americano());
		coffees.add(new Espresso());
		coffees.add(new Latte());
		
		printMainMenu(currentBundle);
		
		try {
			System.out.print(currentBundle.getString("chooseMain"));
			option = in.nextInt();
			// Prevents error from new line
			in.nextLine();
			
			// Choosing 3 exits the program
			while(option != 3) {
				
				// Move onto the coffee menu
				if(option == 1) {
					printCoffeeMenu(currentBundle);
					
					try {
						System.out.print(currentBundle.getString("coffeeChoice"));
						coffeeChoice = in.nextLine();
						
						// When Americano is chosen
						if(coffeeChoice.equalsIgnoreCase("americano") || coffeeChoice.equalsIgnoreCase("アメリカーノ")) {
							System.out.println(currentBundle.getString("prepAmericano"));
							
							Runnable pouringAmericano;
							new Thread(pouringAmericano = () -> {
								for(int i = 1; i < 10; i++) {
									System.out.println("..." + i);
									
									try {
				    					Thread.sleep(1000);
				    				} 
				    				catch (InterruptedException e) {
				    					e.printStackTrace();
				    				}
								}
								return;
							});
							
							try {
								File file = new File("sounds/Americano.wav");
								file.toURI();
								
								AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
								Clip clip = AudioSystem.getClip();
								
								clip.open(audioIn);
								clip.start();
							}
							catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
								System.err.println(currentBundle.getString("generalError"));
								break;
							} 
							
							Thread t = new Thread(pouringAmericano);
						    t.start();
						    
						    // Waits for the thread to finish
						    try {
		    					Thread.sleep(10000);
		    				} 
		    				catch (InterruptedException e) {
		    					System.err.println(currentBundle.getString("generalError"));
								break;
		    				}
						    
						    System.out.println(currentBundle.getString("finAmericano"));
						    System.out.println();
						}
						
						// When Espresso is chosen
						else if(coffeeChoice.equalsIgnoreCase("espresso") || coffeeChoice.equalsIgnoreCase("エスプレッソ")) {
							System.out.println(currentBundle.getString("prepEspresso"));
							
							Runnable pouringEspresso;
							new Thread(pouringEspresso = () -> {
								for(int i = 1; i < 7; i++) {
									System.out.println("..." + i);
									
									try {
				    					Thread.sleep(1000);
				    				} 
				    				catch (InterruptedException e) {
				    					e.printStackTrace();
				    				}
								}
								return;
							});
							
							try {
								File file = new File("sounds/Expresso.wav");
								file.toURI();
								
								AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
								Clip clip = AudioSystem.getClip();
								
								clip.open(audioIn);
								clip.start();
							}
							catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
								System.err.println(currentBundle.getString("generalError"));
								break;
							}
							
							Thread t = new Thread(pouringEspresso);
						    t.start();
						    
						    // Waits for the thread to finish
						    try {
		    					Thread.sleep(7000);
		    				} 
		    				catch (InterruptedException e) {
		    					System.err.println(currentBundle.getString("generalError"));
								break;
		    				}
						    
						    System.out.println(currentBundle.getString("finEspresso"));
							System.out.println();
						}
						
						// When Latte is chosen
						else if(coffeeChoice.equalsIgnoreCase("latte") || coffeeChoice.equalsIgnoreCase("ラテ")) {
							System.out.println(currentBundle.getString("prepLatte"));
							
							Runnable pouringLatte;
							new Thread(pouringLatte = () -> {
								for(int i = 1; i < 14; i++) {
									System.out.println("..." + i);
									
									try {
				    					Thread.sleep(1000);
				    				} 
				    				catch (InterruptedException e) {
				    					e.printStackTrace();
				    				}
								}
								return;
							});
							
							try {
								File file = new File("sounds/Latte.wav");
								file.toURI();
								
								AudioInputStream audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
								Clip clip = AudioSystem.getClip();
								
								clip.open(audioIn);
								clip.start();
							}
							catch(UnsupportedAudioFileException | IOException | LineUnavailableException e) {
								System.err.println(currentBundle.getString("generalError"));
								break;
							}
							
							Thread t = new Thread(pouringLatte);
						    t.start();
						    
						    // Waits for the thread to finish
						    try {
		    					Thread.sleep(14000);
		    				} 
		    				catch (InterruptedException e) {
		    					System.err.println(currentBundle.getString("generalError"));
		    					break;
		    				}
						    
						    System.out.println(currentBundle.getString("finLatte"));
						    System.out.println();
						}
						
						// If the user's input doesn't match any of the coffee types,
						// a custom error is thrown
						else {
							throw new UnrecognisedCoffeeException(currentBundle.getString("invalidCoffee"));
						}
					}
					catch(UnrecognisedCoffeeException e) {
						e.printStackTrace();
					}
					
					// Print initial menu again
					printMainMenu(currentBundle);
					System.out.print(currentBundle.getString("chooseMain"));
					option = in.nextInt();
					// Prevents error from new line
					in.nextLine();
				}
				
				// Switch languages
				else if(option == 2) {
					// Switches to Japanese if it's already in English
					// then displays the initial menu again
					if(currentBundle.equals(enBundle)) {
						currentBundle = jaBundle;
						printMainMenu(currentBundle);
						
						System.out.print(currentBundle.getString("chooseMain"));
						option = in.nextInt();
						// Prevents error from new line
						in.nextLine();
					}
					// Switches to English if it's already in Japanese
					// then displays the initial menu again
					else {
						currentBundle = enBundle;
						printMainMenu(currentBundle);
						
						System.out.print(currentBundle.getString("chooseMain"));
						option = in.nextInt();
						// Prevents error from new line
						in.nextLine();
					}
				}
				
				// If the user enters a number outside the range, display an 
				// error message and have them try again
				else if(option != 1 || option != 2 || option != 3) {
					System.out.print(currentBundle.getString("invalidOption"));
					option = in.nextInt();
					// Prevents error from new line
					in.nextLine();
				}
			}
		}
		catch(InputMismatchException e) {
			System.err.println(currentBundle.getString("notAnInt"));
		}
		catch(Exception e) {
			System.err.println(currentBundle.getString("generalError"));
		}
		
		in.close();
	}

}
