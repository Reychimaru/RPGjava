import java.util.Scanner;

public class RPG {

    static class Character {
        String name = "Character";
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

        boolean playerIsAlive = true;

        Character character = new Character();
        Goblin goblin = new Goblin();

        System.out.println("\nA " + goblin.name + " appears in your way.");

        combat: while (goblin.health > 0 && character.health > 0) {

            int turn = 1;
            System.out.println("Turn " + turn + " | " + "Your HP: " + character.health + " MP: " + character.mana);
            System.out.println(goblin.name + " HP: " + goblin.health);
            System.out.println("\nWhat do you want to do?");
            System.out.println("[1] Attack | [2] Spellbook | [3] Escape");
            String action = scanner.nextLine();

            switch (action) {

                case "1": // Attack
                    int characterAttack = character.attack();
                    int goblinDodge = goblin.dodge();

                    if (characterAttack <= goblinDodge) {
                        System.out.println("\nYour attack missed.");

                        int goblinAttack = goblin.attack();
                        int characterDodge = character.dodge();

                        if (goblinAttack <= characterDodge) {
                            System.out.println("\n" + goblin.name + "\'s attack missed.");
                        } else {
                            int goblinDamage = goblin.attackDamage();
                            character.health -= goblinDamage;
                            System.out.println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                        }

                    } else {
                        int characterDamage = character.attackDamage();
                        goblin.health -= characterDamage;
                        System.out.println("\nYou strike the " + goblin.name + " for " + characterDamage + " damage.");

                        int goblinAttack = goblin.attack();
                        int characterDodge = character.dodge();

                        if (goblinAttack <= characterDodge) {
                            System.out.println("\n" + goblin.name + "\'s attack missed.");
                        } else {
                            int goblinDamage = goblin.attackDamage();
                            character.health -= goblinDamage;
                            System.out.println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                        }
                    }
                    break;

                case "2": // Spellbook
                System.out.println("\nWhat do you want to do?");
                System.out.println("[1] Thunderbolt | [2] Fireball | [3] Return");
                String spell = scanner.nextLine();

                    switch (spell) {
                        case "1": // Thunderbolt
                            if (character.mana < 3) {
                                System.out.println("Not enough MP, Thunderbolt requires 3 mana.");
                            } else {
                                int characterDamage = character.thunderbolt();
                                goblin.health -= characterDamage;
                                int manaCost = 3;
                                character.mana -= manaCost;

                                System.out.println("\nYour thunderbolt strikes the " + goblin.name + " for " + characterDamage + " damage.");

                                int goblinAttack = goblin.attack();
                                int characterDodge = character.dodge();

                                if (goblinAttack <= characterDodge) {
                                    System.out.println("\n" + goblin.name + "\'s attack missed.");
                                } else {
                                    int goblinDamage = goblin.attackDamage();
                                    character.health -= goblinDamage;
                                    System.out.println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                                }
                            }
                            break;
                        case "2": // Fireball
                            if (character.mana < 7) {
                                System.out.println("Not enough MP, Fireball requires 7 mana.");
                            } else {
                                int characterDamage = character.fireball();
                                goblin.health -= characterDamage;
                                int manaCost = 7;
                                character.mana -= manaCost;

                                System.out.println("\nYour fireball burns the " + goblin.name + " for " + characterDamage + " damage.");

                                int goblinAttack = goblin.attack();
                                int characterDodge = character.dodge();

                                if (goblinAttack <= characterDodge) {
                                    System.out.println("\n" + goblin.name + "\'s attack missed.");
                                } else {
                                    int goblinDamage = goblin.attackDamage();
                                    character.health -= goblinDamage;
                                    System.out.println("\n" + goblin.name + " hits you for " + goblinDamage + " damage.");
                                }
                            }
                            break;
                        case "3": // Return
                            break;
                        default:
                            System.out.println("\nInvalid input.");
                            break;
                    }
                    break;

                case "3": // Escape
                    int escape = character.escape();
                    System.out.println("\nYou have escaped the " + goblin.name + ".");
                    break combat;
                default:
                    System.out.println("\nInvalid input.");
                    break;
            }
        }

        if (goblin.health <= 0) {
            System.out.println("\nYou have slain the " + goblin.name + ".");
        } else if (character.health <= 0) {
            System.out.println("\nYou have been slain by the " + goblin.name + ".");
        }
    }
}
