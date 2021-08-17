package net.mcreator.iceage.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.iceage.potion.IceColdPotion;
import net.mcreator.iceage.IceAgeModElements;
import net.mcreator.iceage.IceAgeMod;

import java.util.Map;

@IceAgeModElements.ModElement.Tag
public class PureIceItemInHandTickProcedure extends IceAgeModElements.ModElement {
	public PureIceItemInHandTickProcedure(IceAgeModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				IceAgeMod.LOGGER.warn("Failed to load dependency entity for procedure PureIceItemInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(IceColdPotion.potion, (int) 4, (int) 1, (false), (true)));
	}
}
