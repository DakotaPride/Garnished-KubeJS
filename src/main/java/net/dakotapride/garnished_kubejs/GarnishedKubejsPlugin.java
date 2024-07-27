package net.dakotapride.garnished_kubejs;

import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import net.dakotapride.garnished.registry.GarnishedRecipeTypes;

import java.util.Map;

public class GarnishedKubejsPlugin extends KubeJSPlugin {

    private static final Map<GarnishedRecipeTypes, RecipeSchema> standardSchema = Map.of(
            GarnishedRecipeTypes.FREEZING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.RED_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.ORANGE_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.YELLOW_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.GREEN_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.BLUE_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.PURPLE_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING
    );

    private static final Map<GarnishedRecipeTypes, RecipeSchema> additionalSchema = Map.of(
            GarnishedRecipeTypes.LIME_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.LIGHT_BLUE_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.CYAN_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.MAGENTA_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.PINK_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.BLACK_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.GRAY_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.LIGHT_GRAY_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.WHITE_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING,
            GarnishedRecipeTypes.BROWN_DYE_BLOWING, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING
    );

    @Override
    public void init() {
        RegistryInfo.ITEM.addType("garnished:hatchet", HatchetItemBuilder.class, HatchetItemBuilder::new);
    }

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        for (var createRecipeType : GarnishedRecipeTypes.values()) {
            if (createRecipeType.getSerializer() instanceof ProcessingRecipeSerializer<?>) {
                var schema = standardSchema.getOrDefault(createRecipeType, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING);
                var schema1 = additionalSchema.getOrDefault(createRecipeType, BasicFanRecipeSchema.DEFAULT_BULK_PROCESSING);
                event.register(createRecipeType.getId(), schema);
                event.register(createRecipeType.getId(), schema1);
            }
        }
    }
}
