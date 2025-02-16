package org.hi2mabu4.lifenaturalcraft.registry.event;

import org.hi2mabu4.lifenaturalcraft.Config;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.Event;

public class ModForgeEventSubscriber {
    public static void nonWaterInfinite(BlockEvent.CreateFluidSourceEvent e) {
        if (!Config.isFiniteWater)
            return;
        Fluid fluid = e.getState().getFluidState().getType();
        if (fluid == Fluids.WATER) {
            e.setResult(Event.Result.DENY);
        }
    }
}
