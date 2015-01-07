package org.coderdojoia.tutorialmod;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.creativetab.CreativeTabs;

public class ItemCement_Bucket extends Item {
	private static final String name = "cement_bucket";
	
	public ItemCement_Bucket() {
		this.setMaxStackSize(1);
		// ** Set bucket as container?
		this.setContainerItem(Items.bucket);
		// *** Make cement harden if not used within X ticks
		// this.onUsingTick(stack, player, count)
		this.setCreativeTab(CreativeTabs.tabMisc);
	}
}
