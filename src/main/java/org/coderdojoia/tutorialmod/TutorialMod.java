package org.coderdojoia.tutorialmod;

// Make the needed the libraries accessible
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.coderdojoia.tutorialmod.BlockConcrete;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION, name="tutorialmod") // Forge annotation
public class TutorialMod  // <-- mod class
{
	/* 
	 * Make MODID and VERSION fields:
	 *  - usable everywhere (with 'public')
	 *  - usable without a specific TutorialMod() created (with 'static')
	 *  - unchangeable (with 'final')
	 *  - a String type (instead of an integer, float, char, etc.)
	 * 
	 *  *!*!* By convention, 'final' fields are in ALL CAPS *!*!*
	 */
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "1.0";
    
    public static Block concrete;
    /* Forge mods have 3-stages of initialization:
     * - preInit: register your mods basics
     * - init: mod-specific code
     * - postInit: how your mod works with other mods
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	concrete = new BlockConcrete();
    	GameRegistry.registerBlock(concrete, "Concrete");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	/*
		 * We can't test concrete's harvestLevel in Creative mode,
		 * so we need a temporary recipe to create concrete in Survival
		 *      2 cobblestone = 4 concrete
		 */
    	ItemStack myStack = new ItemStack(Blocks.dirt);
    	System.out.println("Created cobbleStack...");
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 4), 
        	myStack
        );
        
        GameRegistry.addRecipe(new ItemStack(Blocks.dirt),
        	"   ", 
        	" # ", 
        	"   ", 
        	'#', new ItemStack(Blocks.cobblestone)
        );
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	System.out.println("Tutorial postInit");
    }
}
