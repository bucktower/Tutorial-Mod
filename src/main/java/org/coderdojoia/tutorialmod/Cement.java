package org.coderdojoia.tutorialmod;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.MaterialLiquid;

public class Cement extends MaterialLiquid {
	private static final String name = "cement";
	
	public Cement()
	{
		super(MapColor.stoneColor);
	}
}
