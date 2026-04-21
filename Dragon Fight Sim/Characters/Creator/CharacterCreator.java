//change
package Characters.Creator;

import java.util.*;

import Characters.Entities.Character;
import Skills.*;

import Skills.Attacks.*;
import Skills.Defensives.*;
import Skills.Buffs.*;

public class CharacterCreator {

    public static Character create(Scanner sc, List<Character> team) {

        sc.nextLine(); // clear buffer

        System.out.print("Enter character name: ");
        String name = sc.nextLine();

        System.out.print("Enter Max HP: ");
        int hp = Math.max(0, readInt(sc));

        System.out.print("Enter Attack: ");
        int attack = Math.max(0, readInt(sc));

        System.out.print("Enter Magic Attack: ");
        int magicAttack = Math.max(0, readInt(sc));

        System.out.print("Enter Defense: ");
        int defense = readInt(sc);

        System.out.print("Enter Magic Defense: ");
        int magicDefense = readInt(sc);

        System.out.println("\nChoose 3 skills:");
        printSkillMenu();

        List<Skill> skills = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Skill " + (i + 1) + ": ");
            int choice = readIntInRange(sc, 1, 8);
            skills.add(getSkill(choice));
        }

        return new CustomCharacter(
                name,
                hp,
                attack,
                magicAttack,
                defense,
                magicDefense,
                skills
        );
    }

    // ================= SKILL MENU =================
    private static void printSkillMenu() {
       System.out.println("1. Slash");
        System.out.println("2. Fireball");
        System.out.println("3. Defend");
        
        System.out.println("4. First Aid");
        System.out.println("5. Precise Cut");
        System.out.println("6. Holy Blessing");
        System.out.println("7. Hide");
        System.out.println("8. Charge");
    }

    private static Skill getSkill(int choice) {
        switch (choice) {
          case 1: return new SlashSkill();
            case 2: return new FireballSkill();
            case 3: return new DefendSkill();
            case 4: return new FirstAidSkill();
            case 5: return new PreciseCutSkill();
            case 6: return new HolyBlessingSkill();
            case 7: return new HideSkill();
            case 8: return new ChargeSkill();
            default: return new SlashSkill();
        }
    }

    // ================= SAFE INPUT =================
    private static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static int readIntInRange(Scanner sc, int min, int max) {
        int value;
        while (true) {
            value = readInt(sc);
            if (value >= min && value <= max) return value;
            System.out.print("Enter a number between " + min + " and " + max + ": ");
        }
    }
}
