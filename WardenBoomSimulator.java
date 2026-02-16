import java.util.Scanner;
import java.util.Random;

public class WardenBoomSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Player stats
        int playerHealth = 100;
        int cooldown = 0;           // Cooldown for boom (in "turns")
        String weapon = "WARDEN BOOM stick";

        System.out.println("=====================================");
        System.out.println("   WELCOME TO WARDEN BOOM SIMULATOR   ");
        System.out.println("   Made by David u arnante - 2026    ");
        System.out.println("=====================================");
        System.out.println("You hold the enchanted " + weapon + "!");
        System.out.println("Commands: boom | teleport | status | quit");
        System.out.println("=====================================\n");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("quit")) {
                System.out.println("You put away the WARDEN BOOM stick. Goodbye!");
                break;
            }

            if (command.equals("status")) {
                System.out.println("\n--- STATUS ---");
                System.out.println("Health: " + playerHealth + "/100");
                if (cooldown > 0) {
                    System.out.println("Boom on cooldown: " + cooldown + " turns left");
                } else {
                    System.out.println("Boom ready!");
                }
                System.out.println("Weapon: " + weapon);
                System.out.println("--------------\n");
                continue;
            }

            if (cooldown > 0) {
                cooldown--;
            }

            if (command.equals("boom")) {
                if (cooldown > 0) {
                    System.out.println("The stick is still charging... (" + cooldown + " turns left)!");
                } else {
                    System.out.println("\nYou swing the WARDEN BOOM stick...");
                    System.out.println("Warden sonic boom sound: *KRRRRR-SHOOOOM!* 🔊💥");

                    int damage = random.nextInt(10) + 8;  // 8-17 damage
                    int knockback = random.nextInt(3) + 2; // 2-4 "blocks"

                    System.out.println("Sonic boom hits for " + damage + " damage!");
                    System.out.println("Enemies are knocked back " + knockback + " blocks!");

                    // Random fun outcome
                    int chance = random.nextInt(100);
                    if (chance < 20) {
                        System.out.println("Critical hit! Extra shockwave! +5 damage!");
                        damage += 5;
                    } else if (chance < 40) {
                        System.out.println("The boom echoes... you feel unstoppable!");
                    } else if (chance < 60) {
                        System.out.println("A zombie screams in the distance... nice!");
                    }

                    cooldown = 3; // 3-turn cooldown
                    playerHealth -= random.nextInt(6); // Tiny self-damage risk (0-5)
                    if (playerHealth < 0) playerHealth = 0;

                    System.out.println("Your health now: " + playerHealth);
                    if (playerHealth <= 0) {
                        System.out.println("You overdid it... the boom took you out! Game over.");
                        break;
                    }
                }
            } else if (command.equals("teleport")) {
                int distance = random.nextInt(10) + 1; // 1-10 blocks
                System.out.println("\nYou point the stick where you're looking...");
                System.out.println("Reality bends... *whoosh!*");

                if (distance >= 8) {
                    System.out.println("Perfect teleport! You moved " + distance + " blocks forward!");
                } else if (distance >= 4) {
                    System.out.println("Smooth blink! " + distance + " blocks away.");
                } else {
                    System.out.println("Short hop... only " + distance + " blocks. Meh.");
                }

                // Tiny chance of glitch
                if (random.nextInt(100) < 15) {
                    System.out.println("Teleport glitch! You took 8 damage from void energy.");
                    playerHealth -= 8;
                    if (playerHealth <= 0) {
                        System.out.println("You fell into the void... Game over!");
                        break;
                    }
                }

                System.out.println("Health now: " + playerHealth + "\n");
            } else {
                System.out.println("Unknown command. Try: boom, teleport, status, quit");
            }
        }

        scanner.close();
        System.out.println("\nThanks for playing! Create more in the future?");
    }
                      }
