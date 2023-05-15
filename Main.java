import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Recipe> recipes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create a recipe");
            System.out.println("2. Search a recipe");
            System.out.println("3. Modify a recipe");
            System.out.println("4. Rate a recipe");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Read the empty line

            switch (choice) {
                case 1 -> createRecipe();
                case 2 -> searchRecipe();
                case 3 -> modifyRecipe();
                case 4 -> rateRecipe();
                case 0 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void rateRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Rating: ");
        int rating = scanner.nextInt();
        Recipe recipe = RecipeManager.getInstance().getRecipe(name);
        if (recipe == null) {
            System.out.println("Recipe not found.");
        } else {
            recipe.setRating(rating);
            // TODO: not set add a new rating, but update the existing rating
        }
    }

    private static void modifyRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Recipe name: ");
        String name = scanner.nextLine();
        Recipe recipe = RecipeManager.getInstance().getRecipe(name);
        if (recipe == null) {
            System.out.println("Recipe not found.");
        } else {
            System.out.println("1. Modify name");
            System.out.println("2. Modify ingredients");
            System.out.println("3. Modify steps");
            System.out.println("4. Modify category");
            System.out.println("5. Modify tags");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Read the empty line
            switch (choice) {
                case 1 -> {
                    System.out.print("New name: ");
                    String newName = scanner.nextLine();
                    recipe.setName(newName);
                }
                case 2 -> {
                    System.out.print("New ingredients (separated by comma): ");
                    String[] newIngredients = scanner.nextLine().split(",");
                    recipe.setIngredients(newIngredients);
                }
                case 3 -> {
                    System.out.print("New steps (separated by comma): ");
                    String[] newSteps = scanner.nextLine().split(",");
                    recipe.setSteps(newSteps);
                }
                case 4 -> {
                    System.out.print("New category: ");
                    String newCategory = scanner.nextLine();
                    recipe.setCategory(newCategory);
                }
                case 5 -> {
                    System.out.print("New tags (separated by comma): ");
                    String[] newTags = scanner.nextLine().split(",");
                    recipe.setTags(newTags);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void searchRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Search keyword: ");
        String keyword = scanner.nextLine();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(keyword) || recipe.getRecipe().contains(keyword)) {
                System.out.println(recipe);
            }
        }
    }

    private static void createRecipe() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Ingredients (separated by comma): ");
        String[] ingredients = scanner.nextLine().split(",");
        System.out.print("Recipe: ");
        String recipe = scanner.nextLine();
        Recipe newRecipe = new Recipe(name, ingredients, recipe);
        recipes.add(newRecipe);
        System.out.println("Recipe created successfully.");
    }
}
