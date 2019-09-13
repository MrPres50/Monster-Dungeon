import java.util.Scanner;

public class MonsterDungeon
	{
		static int playerHealth;
		static int[] playerStats;
		static int monsterHealth;
		static int[] monsterStats;

		public static void main(String[] args)
			{
				playerWelcome();
				classSelection();
				monsterBattle();

			}

		// Player welcome
		public static void playerWelcome()
			{
				Scanner userInput = new Scanner(System.in);
				System.out.println("Welcome adventurer, what is your name?");
				String name = userInput.nextLine();
				System.out.println("Ah, well met " + name
						+ ", welcome to the dungeon. I am the dungeon keeper, I am here to guide you. By choice or otherwise you have come here to face many challenges.");
				try
					{
						Thread.sleep(3000);
					} catch (InterruptedException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println("Your fate is not yet sealed, based upon your choices, you may survive.");
			}

		// Class Selection
		public static void classSelection()
			{
				System.out.println("What skills do you posses?");
				Scanner classChoice = new Scanner(System.in);
				System.out.println("Press 1 for Fighter, 2 for Ranger, and 3 for Rogue.");
				int dndClass = classChoice.nextInt();

				if (dndClass == 1)
					{
						System.out.println(
								"You have chosen the Fighter Class, a noble warrior and master of arms. Your prowess with the blade is unmatched, your foes shall surely fall.");
						int fighterHealth = 20;
						int[] fighterStats = new int[4];
						fighterStats[0] = 9; // Strength- Damage your attacks do
						fighterStats[1] = 3; // Agility- How fast your character is, determines who attacks first, and
												// if you are able to dodge attacks
						// fighterStats[2] = 2; // Charisma
						fighterStats[2] = 3; // Dexterity- How likely your attacks are to land
						fighterStats[3] = 8; // Defense- Number that needs to be rolled above to deal damage and lessens
												// damage.
						playerStats = fighterStats;
						playerHealth = fighterHealth;
					}
				else if (dndClass == 2)
					{
						System.out.println(
								"You have chosen the Ranger Class, a skilled bowman and marksman. As long as you aim true, victory is within reach.");
						int rangerHealth = 13;
						int[] rangerStats = new int[4];
						rangerStats[0] = 5;
						rangerStats[1] = 7;
						// rangerStats[2] = 5;
						rangerStats[2] = 9;
						rangerStats[3] = 5;
						playerStats = rangerStats;
						playerHealth = rangerHealth;
					}
				else if (dndClass == 3)
					{
						System.out.println(
								"You have chosen the Rogue Class, cunning creatures of the dagger and dark. Keep to the shadows and your oppenants shall know fear.");
						int rogueHealth = 11;
						int[] rogueStats = new int[4];
						rogueStats[0] = 4;
						rogueStats[1] = 10;
						// rogueStats[2] = 7;
						rogueStats[2] = 8;
						rogueStats[3] = 4;
						playerStats = rogueStats;
						playerHealth = rogueHealth;

					}

			}

		// Monster Battle
		public static void monsterBattle()
			{
				System.out.println("May your choice serve you well, the dungeon is not kind to the foolish.");
				System.out.println("You may now enter, may the dungeon have mercy upon you.");
				System.out.println("");
				System.out.println(
						"You take your first steps through the threshhold and find yourself to be all alone in this place, you light your torch, it's solitary flame is your only company.");
				System.out.println(
						"Before you there are three pathways, none of which reasure your quest, but still you must choose.");
				System.out.println("Press 1 for the first pathway, 2 for the second and 3 for the third.");
				Scanner pathChoice = new Scanner(System.in);
				int path = pathChoice.nextInt();

				if (path == 1)
					{
						int skeletonHealth = 14;
						int[] skeletonStats = new int[4];
						skeletonStats[0] = 6;
						skeletonStats[1] = 3;
						skeletonStats[2] = 4;
						skeletonStats[3] = 4;
						monsterHealth = skeletonHealth;
						monsterStats = skeletonStats;

						System.out.println(
								"You have chosen the first path. The way is barren, void of life and paved with cold stone. Bones lay along the path, likely the remnants of the ones who came before you.");
						System.out.println(
								"Your footsteps disturb the earth, as the bones begin to rattle and shake. They move without prompting, and assemble to form a full skeleton.");
						System.out.println(
								"The skeleton's movements are erratic and awkward, as if getting used to it's own limbs. There is no doubt that it is hostile as it begins to charge at you.");
						if (monsterStats[1] > playerStats[1])
							{
								System.out.println("The skeleton rushes and swings it's bony, brutish arm at you.");

								if (rollD20() + monsterStats[2] > playerStats[1])
									{
										if (rollD20() > playerStats[3])
											{
												playerHealth = playerHealth - (skeletonStats[0]- (playerStats[3]/2));
												System.out.println("You took damage! Your Health is at " + playerHealth + "!");
											}
									}

							}
						else if (playerStats[1] > monsterStats[1])
							{
								System.out.println("The skeleton takes it's time to attack, giving you an opportunity!");
								System.out.println("Press 1 to attempt a melee attack, 2 for a ranged attack.");
								Scanner attackChoice = new Scanner(System.in);
								int attack = attackChoice.nextInt();
								
								if (attack == 1)
									{
										if (rollD20() + playerStats[2] > monsterStats[1])
											{
												10
											}
									}
							}
					}
			}

		// Dice Roll
		public static int rollD20()
			{
				return (int) (Math.random() * 20 + 1);
			}

	}
