package org.coderdojoia.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockLimestone extends Block {
	
	private static final String name = "limestone";
	
	public BlockLimestone()
	{
		super(Material.rock);
		this.setBlockName(TutorialMod.MODID + "_" + name);
		this.setBlockTextureName(TutorialMod.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(0.5F);  // stone is 1.5
		this.setResistance(1.0F);  // unbreakable to explosions
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 1);
	}
}
