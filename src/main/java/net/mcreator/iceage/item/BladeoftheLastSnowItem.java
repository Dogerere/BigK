
package net.mcreator.iceage.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.iceage.procedures.IckleBulletHitsBlockProcedure;
import net.mcreator.iceage.itemgroup.IceAgeItemGroup;
import net.mcreator.iceage.IceAgeModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@IceAgeModElements.ModElement.Tag
public class BladeoftheLastSnowItem extends IceAgeModElements.ModElement {
	@ObjectHolder("ice_age:bladeofthe_last_snow")
	public static final Item block = null;
	public BladeoftheLastSnowItem(IceAgeModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100001;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 12f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -1f, new Item.Properties().group(IceAgeItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("A blade that can kill everything"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					IckleBulletHitsBlockProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("bladeofthe_last_snow"));
	}
}
