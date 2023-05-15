import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        RecipeManager recipeManager = RecipeManager.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create a recipe");
            System.out.println("2. Search a recipe");
            System.out.println("3. Modify a recipe");
            System.out.println("4. Rate a recipe");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");
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
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Recipe name: ");
//        String name = scanner.nextLine();
//        System.out.println("Rating: ");
//        int rating = scanner.nextInt();
//        Recipe recipe = RecipeManager.getInstance().getRecipe(name);
//        if (recipe == null) {
//            System.out.println("Recipe not found.");
//        } else {
//            recipe.setRating(rating);
//            // TODO: not set add a new rating, but update the existing rating
//        }
    }

    private static void modifyRecipe() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Recipe name: ");
//        String name = scanner.nextLine();
//        Recipe recipe = RecipeManager.getInstance().getRecipe(name);
//        if (recipe == null) {
//            System.out.println("Recipe not found.");
//        } else {
//            System.out.println("1. Modify name");
//            System.out.println("2. Modify ingredients");
//            System.out.println("3. Modify steps");
//            System.out.println("4. Modify category");
//            System.out.println("5. Modify tags");
//            System.out.println("Your choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Read the empty line
//            switch (choice) {
//                case 1 -> {
//                    System.out.println("New name: ");
//                    String newName = scanner.nextLine();
//                    recipe.setName(newName);
//                }
//                case 2 -> {
//                    System.out.println("New ingredients (separated by comma): ");
//                    String[] newIngredients = scanner.nextLine().split(",");
//                    recipe.setIngredients(newIngredients);
//                }
//                case 3 -> {
//                    System.out.println("New steps (separated by comma): ");
//                    String[] newSteps = scanner.nextLine().split(",");
//                    recipe.setSteps(newSteps);
//                }
//                case 4 -> {
//                    System.out.println("New category: ");
//                    String newCategory = scanner.nextLine();
//                    recipe.setCategory(newCategory);
//                }
//                case 5 -> {
//                    System.out.println("New tags (separated by comma): ");
//                    String[] newTags = scanner.nextLine().split(",");
//                    recipe.setTags(newTags);
//                }
//                default -> System.out.println("Invalid choice.");
//            }
//        }
    }

    private static void searchRecipe() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Search keyword: ");
//        String keyword = scanner.nextLine();
//        for (Recipe recipe : recipes) {
//            if (recipe.getName().contains(keyword) || recipe.getRecipe().contains(keyword)) {
//                System.out.println(recipe);
//            }
//        }
    }

    private static void createRecipe() {
        Scanner scanner = new Scanner(System.in);
        RecipeBuilder builder = new RecipeBuilder();

        System.out.println("Recipe name: ");
        String name = scanner.nextLine();
        if (RecipeManager.getInstance().getRecipe(name) != null) {
            System.out.println("Recipe already exists.");
            return;
        }
        else if (name.equals("")) {
            System.out.println("Recipe name cannot be empty.");
            return;
        }
        else builder.setName(name);

        System.out.println("Ingredients ");
        List<Ingredient> ingredients = new ArrayList<>();
        while (true) {
            System.out.println("(enter 'q' to stop): ");
            String ingredient = scanner.nextLine();
            if (ingredient.equals("q")) break;
            else if (ingredient.equals("")) {
                System.out.println("Ingredient cannot be empty.");
                continue;
            }
            System.out.println("Quantity: ");
            String quantity = scanner.nextLine();
            if (quantity.equals("")) {
                System.out.println("Quantity cannot be empty.");
                continue;
            }
            Ingredient newIngredient = new Ingredient(ingredient, quantity);
            ingredients.add(newIngredient);
        }
        builder.setIngredients(ingredients);

        System.out.println("Steps (enter 'q' to stop): ");
        List<Step> steps = new ArrayList<>();
        int stepNumber = 1;
        while (true) {
            System.out.println(stepNumber + ". ");
            String step = scanner.nextLine();
            if (step.equals("q")) break;
            else if (step.equals("")) {
                System.out.println("Step cannot be empty.");
                continue;
            }
            Step newStep = new Step(stepNumber, step);
            steps.add(newStep);
            stepNumber++;
        }
        builder.setSteps(steps);

        System.out.println("Category: ");
        System.out.println("1. Appetizers");
        System.out.println("2. Main dishes");
        System.out.println("3. Desserts");
        String category = scanner.nextLine();
        while (true) {
            if (category.equals("")) {
                System.out.println("Category cannot be empty.");
            }
            else if (category.equals("1") || category.equals("2") || category.equals("3")) {
                break;
            }
            else if (category.equals("q")) {
                return;
            }
            else {
                System.out.println("Invalid category.");
            }
        }
        if (category.equals("1")) category = "Appetizers";
        else if (category.equals("2")) category = "Main dishes";
        else category = "Desserts";
        builder.setCategory(category);

        System.out.println("Tags ");
        System.out.println("1. Vegetarian \n2. Gluten-free \n3. Spicy: ");
        List<String> tags = new ArrayList<>();
        while (true) {
            System.out.println("(enter 'q' to stop): ");
            String tag = scanner.nextLine();
            if (tag.equals("q")) break;
            else if (tag.equals("")) {
                System.out.println("Tag cannot be empty.");
                continue;
            }
            else if (tag.equals("1") || tag.equals("2") || tag.equals("3")) {
                if (tag.equals("1")) tag = "Vegetarian";
                else if (tag.equals("2")) tag = "Gluten-free";
                else tag = "Spicy";
                tags.add(tag);
            }
            else {
                System.out.println("Invalid tag.");
            }
        }
        Set<String> set = new HashSet<>(tags);
        builder.setTags(set);

        System.out.println("Rating: ");
        String rating = scanner.nextLine();
        while (true) {
            if (rating.equals("")) {
                System.out.println("Rating cannot be empty.");
            }
            else if (rating.equals("q")) {
                return;
            }
            else {
                int ratingInt = Integer.parseInt(rating);
                if (ratingInt < 1 || ratingInt > 5) {
                    System.out.println("Rating must be between 1 and 5.");
                }
                else {
                    builder.setRating(ratingInt);
                    break;
                }
            }
        }

        Recipe recipe = builder.build();
        if (category.equals("Appetizers")) RecipeManager.getInstance().addAppetizer(recipe);
        else if (category.equals("Main dishes")) RecipeManager.getInstance().addMainDish(recipe);
        else RecipeManager.getInstance().addDessert(recipe);
        System.out.println("Recipe created successfully.");
    }
}





































