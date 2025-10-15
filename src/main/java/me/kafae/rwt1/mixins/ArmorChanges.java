package me.kafae.rwt1.mixins;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorMaterial.class)
public class ArmorChanges {

    @Inject(
            method = "createAttributeModifiers",
            at = @At("RETURN"),
            cancellable = true
    )
    private void changeDefense(EquipmentType equipmentType, CallbackInfoReturnable<AttributeModifiersComponent> cir) {
        ArmorMaterial self = (ArmorMaterial) (Object) this;

        int newDefense = getChangedDefense(self, equipmentType);
        float toughness = self.toughness();
        float knockbackRes = self.knockbackResistance();

        AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
        Identifier identifier = Identifier.ofVanilla("armor." + equipmentType.getName());
        AttributeModifierSlot slot = AttributeModifierSlot.forEquipmentSlot(equipmentType.getEquipmentSlot());

        builder.add(
                EntityAttributes.ARMOR,
                new EntityAttributeModifier(identifier, newDefense, EntityAttributeModifier.Operation.ADD_VALUE), // ← CHANGED: newDefense
                slot
        );

        builder.add(
                EntityAttributes.ARMOR_TOUGHNESS,
                new EntityAttributeModifier(identifier, toughness, EntityAttributeModifier.Operation.ADD_VALUE), // ← CHANGED: toughness
                slot
        );

        if (knockbackRes > 0.0F) {
            builder.add(
                    EntityAttributes.KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(identifier, knockbackRes, EntityAttributeModifier.Operation.ADD_VALUE),
                    slot
            );
        }

        cir.setReturnValue(builder.build());
    }

    @Unique
    int getChangedDefense(ArmorMaterial self, EquipmentType type) {
        if (self == ArmorMaterials.LEATHER) {
            return switch (type) {
                case HELMET, BOOTS -> 1;
                case CHESTPLATE, LEGGINGS -> 2;
                case BODY -> 3;
            };
        } else if (self == ArmorMaterials.CHAIN) {
            return switch (type) {
                case HELMET, BOOTS -> 1;
                case CHESTPLATE -> 3;
                case LEGGINGS -> 2;
                case BODY -> 4;
            };
        } else if (self == ArmorMaterials.IRON || self == ArmorMaterials.TURTLE_SCUTE) {
            return switch (type) {
                case HELMET, BOOTS -> 2;
                case CHESTPLATE -> 4;
                case LEGGINGS -> 3;
                case BODY -> 5;
            };
        } else if (self == ArmorMaterials.GOLD) {
            return switch (type) {
                case HELMET, BOOTS -> 3;
                case CHESTPLATE, LEGGINGS -> 4;
                case BODY -> 7;
            };
        } else if (self == ArmorMaterials.DIAMOND || self == ArmorMaterials.ARMADILLO_SCUTE) {
            return switch (type) {
                case HELMET, BOOTS -> 3;
                case CHESTPLATE, LEGGINGS -> 5;
                case BODY -> 11;
            };
        } else if (self == ArmorMaterials.NETHERITE) {
            return switch (type) {
                case HELMET, BOOTS -> 4;
                case CHESTPLATE, LEGGINGS -> 6;
                case BODY -> 11;
            };
        }

        return self.defense().getOrDefault(type, 0);
    }
}