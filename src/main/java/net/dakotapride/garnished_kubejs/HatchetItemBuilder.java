package net.dakotapride.garnished_kubejs;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import dev.latvian.mods.kubejs.item.ItemBuilder;
import dev.latvian.mods.kubejs.item.custom.HandheldItemBuilder;
import dev.latvian.mods.kubejs.item.custom.SwordItemBuilder;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import net.dakotapride.garnished.item.hatchet.HatchetToolItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

public class HatchetItemBuilder extends HandheldItemBuilder {

    public HatchetItemBuilder(ResourceLocation i) {
        super(i, 5.0F, -2.6F);
    }

    @Override
    public Item createObject() {
        return new HatchetToolItem(this.toolTier, (int)this.attackDamageBaseline, this.speedBaseline, this.createItemProperties()) {
            private boolean modified = false;

            // {
            //                this.defaultModifiers = ArrayListMultimap.create(this.defaultModifiers);
            //            }

            public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
                if (!this.modified) {
                    this.modified = true;
                    HatchetItemBuilder.this.attributes.forEach((r, m) -> {
                        this.defaultModifiers.put(RegistryInfo.ATTRIBUTE.getValue(r), m);
                    });
                }

                return super.getDefaultAttributeModifiers(equipmentSlot);
            }
        };
    }

}
