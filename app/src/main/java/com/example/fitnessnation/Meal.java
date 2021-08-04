package com.example.fitnessnation;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "meals")
public class Meal  implements Serializable {//serializable is for passing the object to the next activity

    public Meal(String name,String type, int imagePath, int calorie, String description, boolean choice) {
        this.name=name;
        this.imagePath = imagePath;
        this.calorie = calorie;
        this.description = description;
        this.type=type;
        this.choice=choice;
    }

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "meal_name")
    private String name;

    @ColumnInfo(name = "meal_type")
    private String type;

    @ColumnInfo(name = "meal_image")
    private int imagePath;

    @ColumnInfo(name = "meal_calorie")
    private int calorie=0;

    @ColumnInfo(name = "meal_choice")
    private boolean choice=false;//false equal weight loss, true equal weight gain

    @ColumnInfo(name = "meal_description")
    private String description;



    public String getName() { return name; }
    public String getType() { return type; }
    public int getImagePath() {
        return imagePath;
    }
    public int getCalorie() { return calorie; }
    public boolean getChoice() { return choice; }
    public String getDescription() {return description; }


    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setImagePath(int imagePath) {this.imagePath=imagePath; }
    public void setCalorie(int calorie) {this.calorie=calorie; }
    public void setDescription(String description) { this.description = description; }
    public void setChoice(boolean choice) { this.choice=choice; }

    public static Meal[] populateData() {
        return new Meal[] {
                new Meal("Grapefruit","Breakfast" ,R.drawable.grapefruitjpg,52,"Grapefruits are low in calories, high in water and rich in fiber. Studies show that they may increase weight loss and reduce calorie intake and body fat. TO DO: However, if you are taking any drugs make sure to consult your doctor or pharmacist before eating grapefruit. Certain drugs may interact with grapefruit, potentially causing some adverse effects.", false),
                new Meal("Vegan Tacos", "Breakfast",R.drawable.vegan_tacos,245,"Preheat oven to 400 degrees F (204 C). Pat dry chickpeas with paper towels then mix with the rest of the “Bacon” Chickpea ingredients. Spread onto half of a parchment paper-lined baking sheet. Toss together Roasted Tomato ingredients and spread onto the other half. Bake for 20 minutes, or until chickpeas are crispy and tomatoes have burst. Scrambled Tofu: Meanwhile, add all Tofu ingredients to a large greased or non-stick skillet and roughly break up tofu with a spatula. Set over medium heat and cook until tofu begins to brown slightly, stirring often. Assemble: Spoon scrambled tofu, chickpeas, and tomatoes evenly onto tortillas. Garnish with your favorite.", false),
                new Meal("Shakshuka", "Breakfast",R.drawable.shakshuka,165,"Preheat oven to 375°F (190°C). Heat oil in an oven-safe skillet over medium heat, then add onion, garlic, and bell pepper. Cook until softened, about 5 minutes. Tomato: Add canned tomatoes, gently mashing them with a fork if needed to form a chunky sauce. Allow tomatoes to simmer, uncovered, until a thick sauce develops, 10 to 15 minutes. Stir in spices, salt, and pepper. Taste and adjust seasonings as needed. Eggs: Using the back of a spoon, form a few holes in the tomato mixture. Crack an egg into each hole (use as many eggs as you want). Bake: Transfer skillet to a preheated oven and cook, uncovered, for 8 to 12 minutes, or until egg whites are mostly cooked. They should be white and still a little jiggly (they'll continue to cook some after removing from the oven). Serve immediately, topped with crumbled feta, herbs, and bread for dipping.", false),
                new Meal("Crispy Hash Browns", "Breakfast",R.drawable.crispyhashbrowns,211,"Scrub the potatoes clean and grate them on a large-holed cheese grater (I left the skin on, but you can peel it first if you’d like). In a fine-mesh sieve, rinse the grated potato well until the water runs clear. Drain the potatoes, and then place them potato on a clean tea towel or  several paper towels. Twist the towel to remove as much moisture from the potatoes as possible (you might need to do this in two batches). Transfer the grated potato to a bowl and toss it with the salt, garlic powder and onion powder. In a large skillet (preferably cast iron, but non-stick works, too), warm the olive oil over medium heat until shimmering and a piece of grated potato sizzles on contact. Spread the potatoes over the skillet in an even layer and press them down with a spatula. Let them cook, undisturbed, for 2 minutes. Stir again, press them down again, and cook for another 2 minutes. Repeat in 2-minute intervals, flipping in sections once they’re crispy enough to do so, until the potatoes are golden brown and crispy, about 4 to 8 more minutes. Meanwhile, line a plate with a couple of layers of paper towels to absorb excess oil, and set it near the stove. Transfer the hash browns to the lined plate and let them drain for a minute. Season to cheese grater (I left the skin on, but you can peel it first if you’d like). In a fine-mesh sieve, rinse the grated potato well until the water runs clear. Drain the potatoes, and then place them potato on a clean tea towel or  several paper towels. Twist the towel to remove as much moisture from the potatoes as possible (you might need to do this in two batches). ", false),
                new Meal("Bircher Muesli ", "Breakfast",R.drawable.birchermuesli,409,"- In a bowl combine the oats, raisins, cinnamon, nut butter and applesauce. Stir to combine. Then add the milk and stir to combine. Grate half of the apple, then stir the grated apple into the oatmeal. Place the lid on the jar and refrigerate for at least 30 minutes, or up to 5 days. When you’re ready to serve, chop the remaining half on the apple into matchsticks. Top the oatmeal with the fresh apple, a splash of milk and/or a drizzle of honey (both optional).", false),
                new Meal("Tropical Acai Bowl ", "Breakfast",R.drawable.tropical_acai_bowl,257,"- In a blender, combine the frozen mango, pineapple and banana. Run the açai packets under warm water for about 10 seconds to let them thaw a bit, then cut them open and pour the açai pulp into the blender. Pour in the cold water, securely fasten the lid, and start blending ", false),
                new Meal("Egg, tomato and scallion sandwich ", "Breakfast",R.drawable.eggtomatoscallionsandwich,213,"Assemble the sandwich by placing the egg on the bread, then the tomato, then scallion. Top with salt and pepper and spread mayonnaise on the top of the bread.", false),
                new Meal("Healthy Bacon, Egg, and Potato Breakfast Casserole ", "Breakfast",R.drawable.baconeggpotatocasserole,184,"- Preheat oven to 375 degrees. Heat oil in a large skillet and sauté onion, bell pepper, mushrooms, garlic, bacon and Fines Herbs until onions are translucent. Set aside. In large bowl, whisk together eggs, cottage cheese and cheddar cheese. Stir in shredded potatoes. Add sautéed bacon and vegetables. Spoon into lightly greased 9x9 square dish. Bake 45 minutes until casserole is firm. Serve on bed of baby kale.", false),
                new Meal("Asian Sesame Zucchini Noodles ", "Lunch",R.drawable.asiansesamezucchininoodles,85,"In a large bowl, whisk cilantro, vinegar, oil, garlic, red pepper, sugar, and 1/2 teaspoon salt. Add zucchini; toss until well-combined. Serve immediately.", false),
                new Meal("Butternut Squash and White Bean Soup ", "Lunch",R.drawable.scrambled_eggs_veggies,260,"Cut neck off butternut squash (reserve base for another use). Peel and cut into 1/2-inch pieces. Heat 1 tablespoon olive oil in nonstick skillet on medium. Add the squash and cook, covered, stirring occasionally, 8 minutes. Meanwhile, heat remaining oil in Dutch oven on medium. Add onion and cook, covered, stirring occasionally, 6 minutes. Stir in garlic and ginger and cook 1 minute. Add broth, thyme and butternut squash and bring to a boil. Using a fork, mash white beans and add to soup along with chickpeas. Cook couscous as label directs; fluff with fork and fold in pistachios, apricots, cilantro and scallion. Serve soup topped with couscous mixture.", false),
                new Meal("Vegetable Ramen with Mushrooms and Bok Choy h ", "Lunch",R.drawable.vegetableramen,300,"Slice white parts of scallions and place in large pot with ginger and 8 cups water; bring to a boil. Stir in tamari, then add noodles and cook per package directions, adding mushrooms and bok choy 3 minutes after adding noodles. Remove from heat and stir in snow peas and vinegar. Divide soup among 4 bowls and place 1 egg half on top of each. Slice remaining scallion greens and serve over soup along with cilantro and red chili.", false),
                new Meal("Tuna Poke Bowl  ", "Lunch",R.drawable.tunapokebowl,213,"- In large bowl, whisk together soy sauce, sesame oil, onion, scallions, and pinch salt. Toss with tuna and refrigerate until ready to use. In small bowl, toss cucumbers with vinegar, sugar, sesame seeds ,and pinch salt. Let stand 5 minutes. Serve tuna, marinated cucumbers, and avocado over rice if desired. Sprinkle with additional black sesame seeds if desired.", false),
                new Meal("Tomato-Quinoa Soup ", "Lunch",R.drawable.tomato,280,"Cook quinoa as label directs. In 4-quart saucepan, heat butter and oil on medium until butter melts. Add shallots, garlic, and fennel seeds. Cook 4 to 6 minutes, or until vegetables begin to soften, stirring occasionally. Add tomatoes and broth. Heat to simmering on high. Simmer 15 minutes, stirring occasionally. With immersion or regular blender, purée mixture until smooth. Reheat soup if necessary. In medium bowl, combine cooked quinoa, pepitas, chives, and red pepper. Serve soup topped with quinoa mixture.", false),
                new Meal("Roasted Salmon With Green Beans and Tomatoes ", "Lunch",R.drawable.roastedsalmon,330,"Heat oven to 425°F. On large rimmed baking sheet, toss garlic, beans, tomatoes, olives and anchovies (if using) with 1 tablespoon oil and 1/4 teaspoon pepper. Roast until vegetables are tender and beginning to brown, 12 to 15 minutes. Meanwhile, heat remaining tablespoon oil in large skillet over medium heat. Season salmon with 1/4 teaspoon each salt and pepper and cook until golden brown and opaque throughout, 4 to 5 minutes per side. Serve with vegetables and yogurt if desired", false),
                new Meal("Tomato, Peach, and Basil Salad ", "Lunch",R.drawable.tomatopeachbasilsalad,75,"- In small bowl, combine onion and vinegar with 1/4 teaspoon salt. Let sit 5 minutes. Cut tomatoes and peaches into wedges and arrange on platter. Stir oil into onion mixture and spoon over fruit, then sprinkle with basil, feta, and cracked black pepper.", false),
                new Meal("Creamy Gluten-Free Tomato Pasta ", "Dinner",R.drawable.creamytomatoglutenreepasta,353,"Sauté onions and garlic in 1 tbsp olive until fragrant, about 2 minutes. Cook your gluten free pasta, whisk together the mayo and egg yolk and Add this mix to your pasta. Then gently mix in the sautéed onion/garlic. Toss the pasta with the tomatoes, kosher salt and pepper.", false),
                new Meal("Sriracha Shredded Chicken Tacos ", "Dinner",R.drawable.srirachashreddedchickentacos,420,"Preheat oven to 375 degrees. Place the chicken breasts on a baking sheet and top with Sriracha. Bake for 30 minutes (or until they're fully cooked). While the chicken is baking, heat the tortillas up (optional). Top each tortilla with chopped red cabbage and chopped peppers. When the chicken has finished baking, shred it and place in the tortillas. Top each taco with feta cheese and a drizzle of lime.", false),
                new Meal("White Bean and Tuna Salad  ", "Dinner",R.drawable.whitebeantunasalad,300,"Bring a large pot of water to a boil. Add 1 tablespoon salt, then green beans, and cook until just tender, 3 to 4 minutes. Drain and rinse under cold water to cool. Meanwhile, in a blender, puree shallot, basil, oil, vinegar, and 1/2 teaspoon each salt and pepper until smooth. Transfer half of dressing to large bowl and toss with green beans. Fold in lettuce, white beans, and tuna and serve with remaining dressing and eggs.", false),
                new Meal("Baked Chicken with Mushrooms and Sweet Potato", "Dinner",R.drawable.chickenmushroomssweetpotato,382,"- In a 350°F oven, bake chicken, topped with mushrooms, chives, and oil, for 15 minutes. Microwave sweet potato for five to seven minutes.", false),
                new Meal("Creamy Healthy Chicken Enchilada Skillet ", "Dinner",R.drawable.creamyhealthychickenenchiladaskillet,353,"- Combine the chicken and enchilada sauce in a skillet over medium-high heat. Stir, then add in the black beans and diced peppers. Mix in the sour cream and corn tortilla pieces, continue to stir. Once everything is evenly hot, top the casserole with cheese and optional cilantro. Serve with avocado slices.", false),
                new Meal("One-Pot Basil Chicken Baked Ziti  ", "Dinner",R.drawable.potbasilchickenbakedziti,250,"Preheat oven to 375 degrees. Mix the shredded, cooked chicken, cooked penne, pasta sauce, and spinach together. Pour into a casserole dish or bakeware. Top with mozzarella (or also mix it in) and basil leaves (shredded or whole). Bake for 25-30 minutes.", false),
                new Meal("Chili Mango Zesty Quinoa Salad", "Dinner",R.drawable.chilimangozestyquinoasalad,180,"Cook the quinoa according to directions. While the quinoa is cooking, chop the spinach, slice the tomatoes, cut the mango and avocado. Once the quinoa has finished cooking, mix all of the ingredients together in a bowl except for the mango, chili powder, cayenne, and avocado. Top each salad with slices of avocado and mango, sprinkled with chili powder and cayenne.", false),





        };
    }

}
