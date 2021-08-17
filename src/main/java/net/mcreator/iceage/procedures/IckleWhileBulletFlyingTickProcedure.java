package net.mcreator.iceage.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.particles.ParticleTypes;

import net.mcreator.iceage.IceAgeModElements;
import net.mcreator.iceage.IceAgeMod;

import java.util.Map;

@IceAgeModElements.ModElement.Tag
public class IckleWhileBulletFlyingTickProcedure extends IceAgeModElements.ModElement {
	public IckleWhileBulletFlyingTickProcedure(IceAgeModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				IceAgeMod.LOGGER.warn("Failed to load dependency x for procedure IckleWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				IceAgeMod.LOGGER.warn("Failed to load dependency y for procedure IckleWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				IceAgeMod.LOGGER.warn("Failed to load dependency z for procedure IckleWhileBulletFlyingTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				IceAgeMod.LOGGER.warn("Failed to load dependency world for procedure IckleWhileBulletFlyingTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		world.addParticle(ParticleTypes.ITEM_SNOWBALL, x, y, z, 0, 1, 0);
	}
}
