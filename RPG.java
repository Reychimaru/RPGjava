import java.util.Scanner;

public class RPG {

    static class Player {
        String name = "Player";
        int health = 50;
        int mana = 10;
        int strength = 3;
        int dexterity = 3;
        int intellect = 2;

        public int attack() {
            return strength + (int) (Math.random() * 20) + 1;
        };

        public int attackDamage() {
            return strength + (int) (Math.random() * 20) + 1;
        };

        public int thunderbolt() {
            return intellect + (int) ((Math.random() * 6) + 1) * 2;
        };

        public int fireball() {
            return intellect + (int) ((Math.random() * 8) + 1) * 3;
        };

        public int dodge() {
            return dexterity + (int) (Math.random() * 20) + 1;
        }

        public int escape() {
            return dexterity + (int) (Math.random() * 20) + 1;
        }
    }

    static class Goblin {
        String name = "Goblin";
        int health = 30;
        int strength = 1;
        int dexterity = 3;

        public int attack() {
            return strength + (int) (Math.random() * 20) + 1;
        };

        public int attackDamage() {
            return strength + (int) (Math.random() * 20) + 1;
        };

        public int dodge() {
            return dexterity + (int) (Math.random() * 20) + 1;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player = new Player();

        Goblin goblin = new Goblin();

        System.out.println("\nA " + goblin.name + " appears in your way.");

        combat: while (goblin.health > 0 && player.health > 0) {

            int turn = 1;
            System.out.println("\n---------------------------------------\nTurn " + turn + " | " + "Your HP: " + player.health + " MP: " + player.mana);
            System.out.println(goblin.name + " HP: " + goblin.health);
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
                            System.out.println("\n" + goblin.name + "\'s attack missed.");
                        } else {
                            int goblinDamage = goblin.attackDamage();
                            player.health -= goblinDamage;
                            System.out.println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                        }

                    } else {
                        int playerDamage = player.attackDamage();
                        goblin.health -= playerDamage;
                        System.out.println("\nYou strike the " + goblin.name + " for " + playerDamage + " damage.");

                        int goblinAttack = goblin.attack();
                        int playerDodge = player.dodge();

                        if (goblinAttack <= playerDodge) {
                            System.out.println("\n" + goblin.name + "\'s attack missed.");
                        } else {
                            int goblinDamage = goblin.attackDamage();
                            player.health -= goblinDamage;
                            System.out.println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                        }
                    }
                    break;

                case "2": // Spellbook
                    System.out.println("\nWhat do you want to do?");
                    System.out.println("[1] Thunderbolt | [2] Fireball | [X] Return");
                    String spell = scanner.nextLine().toLowerCase();

                    switch (spell) {
                        case "1": // Thunderbolt
                            if (player.mana < 3) {
                                System.out.println("Not enough MP, Thunderbolt requires 3 mana.");
                            } else {
                                int playerDamage = player.thunderbolt();
                                goblin.health -= playerDamage;
                                int manaCost = 3;
                                player.mana -= manaCost;

                                System.out.println("\nYour thunderbolt strikes the " + goblin.name + " for "
                                        + playerDamage + " damage.");

                                int goblinAttack = goblin.attack();
                                int playerDodge = player.dodge();

                                if (goblinAttack <= playerDodge) {
                                    System.out.println("\n" + goblin.name + "\'s attack missed.");
                                } else {
                                    int goblinDamage = goblin.attackDamage();
                                    player.health -= goblinDamage;
                                    System.out
                                            .println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                                }
                            }
                            break;
                        case "2": // Fireball
                            if (player.mana < 7) {
                                System.out.println("Not enough MP, Fireball requires 7 mana.");
                            } else {
                                int playerDamage = player.fireball();
                                goblin.health -= playerDamage;
                                int manaCost = 7;
                                player.mana -= manaCost;

                                System.out.println("\nYour fireball burns the " + goblin.name + " for " + playerDamage
                                        + " damage.");

                                int goblinAttack = goblin.attack();
                                int playerDodge = player.dodge();

                                if (goblinAttack <= playerDodge) {
                                    System.out.println("\n" + goblin.name + "\'s attack missed.");
                                } else {
                                    int goblinDamage = goblin.attackDamage();
                                    player.health -= goblinDamage;
                                    System.out
                                            .println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
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
                    System.out.println("\nYou have escaped the " + goblin.name + ".");
                    break combat;
                default:
                    System.out.println("\nInvalid input.");
                    break;
            }
        }

        if (goblin.health <= 0) {
            System.out.println("\nYou have slain the " + goblin.name + ".");
        } else if (player.health <= 0) {
            System.out.println("\nYou have been slain by the " + goblin.name + ".");
        }
    }
}
