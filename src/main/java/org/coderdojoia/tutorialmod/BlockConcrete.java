package org.coderdojoia.tutorialmod;

import net.minecraft.block.Block;  // Notice the difference in imports
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockConcrete extends Block
{
	private static final String name = "concrete";
	
	public BlockConcrete()
	{
		super(Material.rock);
		this.setBlockName(TutorialMod.MODID + "_" + name);
		this.setBlockTextureName(TutorialMod.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(2.5F);  // stone is 1.5
		this.setResistance(6000000.0F);  // unbreakable to explosions
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
	}
}
