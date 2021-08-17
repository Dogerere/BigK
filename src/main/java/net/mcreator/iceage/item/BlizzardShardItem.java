
package net.mcreator.iceage.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.iceage.itemgroup.IceAgeItemGroup;
import net.mcreator.iceage.IceAgeModElements;

@IceAgeModElements.ModElement.Tag
public class BlizzardShardItem extends IceAgeModElements.ModElement {
	@ObjectHolder("ice_age:blizzard_shard")
	public static final Item block = null;
	public BlizzardShardItem(IceAgeModElements instance) {
		super(instance, 5);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(IceAgeItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("blizzard_shard");
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
	}
}
