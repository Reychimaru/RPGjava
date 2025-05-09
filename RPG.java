import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player = new Player("Amon", 5, 3, 3);
        Goblin goblin = new Goblin(3, 3, 1);

        System.out.println("\nA " + goblin.getName() + " appears in your way.");

        int turn = 1;
        combat: while (goblin.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("\n---------------------------------------\nTurn " + turn + " | " + "Your HP: "
                    + player.getHealth() + " MP: " + player.getMana() + "\n---------------------------------------");
            System.out.println(
                    goblin.getName() + " HP: " + goblin.getHealth() + "\n---------------------------------------");
            System.out.println("\nWhat do you want to do?");
            System.out.println("[1] Attack | [2] Spellbook | [3] Escape");
            String action = scanner.nextLine().toLowerCase();

            switch (action) {

                case "1": // Attack
                    int playerAttack = player.attack();
                    int goblinDodge = goblin.dodge();

                    if (playerAttack <= goblinDodge) {
                        System.out.println("\nYour attack missed.");

                        int goblinAttack = goblin.attack();
                        int playerDodge = player.dodge();

                        if (goblinAttack <= playerDodge) {
                            System.out.println("\n" + goblin.getName() + "\'s attack missed.");
                        } else {
                            int goblinDamage = goblin.attackDamage();
                            player.setHealth(player.getHealth() - goblinDamage);
                            System.out.println("\n" + goblin.getName() + " hits you for " + goblinDamage + " damage.");
                        }

                    } else {
                        int playerDamage = player.attackDamage();
                        goblin.setHealth(goblin.getHealth() - playerDamage);
                        System.out
                                .println("\nYou strike the " + goblin.getName() + " for " + playerDamage + " damage.");

                        if (goblin.getHealth() <= 0) {
                            System.out.println("\nYou have slain the " + goblin.getName() + ".");
                            turn = 1;
                            break combat;
                        } else {
                            int goblinAttack = goblin.attack();
                            int playerDodge = player.dodge();

                            if (goblinAttack <= playerDodge) {
                                System.out.println("\n" + goblin.getName() + "\'s attack missed.");
                            } else {
                                int goblinDamage = goblin.attackDamage();
                                player.setHealth(player.getHealth() - goblinDamage);
                                System.out.println(
                                        "\n" + goblin.getName() + " hits you for " + goblinDamage + " damage.");
                            }
                        }
                    }
                    break;

                case "2": // Spellbook
                    System.out.println("\nWhat do you want to do?");
                    System.out.println("[1] Thunderbolt | [2] Fireball | [X] Return");
                    String spell = scanner.nextLine().toLowerCase();

                    switch (spell) {
                        case "1": // Thunderbolt
                            if (player.getMana() < 3) {
                                System.out.println("Not enough MP, Thunderbolt requires 3 mana.");
                            } else {
                                int playerDamage = player.thunderbolt();
                                goblin.setHealth(goblin.getHealth() - playerDamage);
                                int manaCost = 3;
                                player.setMana(player.getMana() - manaCost);

                                System.out.println("\nYour thunderbolt strikes the " + goblin.getName() + " for "
                                        + playerDamage + " damage.");

                                int goblinAttack = goblin.attack();
                                int playerDodge = player.dodge();

                                if (goblinAttack <= playerDodge) {
                                    System.out.println("\n" + goblin.getName() + "\'s attack missed.");
                                } else {
                                    int goblinDamage = goblin.attackDamage();
                                    player.setHealth(player.getHealth() - goblinDamage);
                                    System.out
                                            .println("\n" + goblin.getName() + " hits you for " + goblinDamage
                                                    + " damage.");
                                }
                            }
                            break;
                        case "2": // Fireball
                            if (player.getMana() < 7) {
                                System.out.println("Not enough MP, Fireball requires 7 mana.");
                            } else {
                                int playerDamage = player.fireball();
                                goblin.setHealth(goblin.getHealth() - playerDamage);
                                int manaCost = 7;
                                player.setMana(player.getMana() - manaCost);

                                System.out.println(
                                        "\nYour fireball burns the " + goblin.getName() + " for " + playerDamage
                                                + " damage.");

                                int goblinAttack = goblin.attack();
                                int playerDodge = player.dodge();

                                if (goblinAttack <= playerDodge) {
                                    System.out.println("\n" + goblin.getName() + "\'s attack missed.");
                                } else {
                                    int goblinDamage = goblin.attackDamage();
                                    player.setHealth(player.getHealth() - goblinDamage);
                                    System.out
                                            .println("\n" + goblin.getName() + " hits you for " + goblinDamage
                                                    + " damage.");
                                }
                            }
                            break;
                        case "x": // Return
                            break;
                        default:
                            System.out.println("\nInvalid input.");
                            break;
                    }
                    break;

                case "3": // Escape
                    int escape = player.escape();
                    System.out.println("\nYou have escaped the " + goblin.getName() + ".");
                    turn = 1;
                    break combat;
                default:
                    System.out.println("\nInvalid input.");
                    break;
            }

            turn++;
        }

        if (player.getHealth() <= 0) {
            System.out.println("\nYou have been slain by the " + goblin.getName() + ".");
        }
    }
}
