
package net.mcreator.iceage.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.iceage.procedures.PureIceItemInHandTickProcedure;
import net.mcreator.iceage.itemgroup.IceAgeItemGroup;
import net.mcreator.iceage.IceAgeModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@IceAgeModElements.ModElement.Tag
public class BlizardCoreItem extends IceAgeModElements.ModElement {
	@ObjectHolder("ice_age:blizard_core")
	public static final Item block = null;
	public BlizardCoreItem(IceAgeModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(IceAgeItemGroup.tab).maxStackSize(64).rarity(Rarity.EPIC));
			setRegistryName("blizard_core");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("A pure energy of a blizzard"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (selected) {
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PureIceItemInHandTickProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
