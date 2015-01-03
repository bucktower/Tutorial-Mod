package org.coderdojoia.tutorialmod;

// Make the needed the libraries accessible
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
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
    	ItemStack shapelessInput = new ItemStack(Blocks.cobblestone, 2);
    	ItemStack shapelessOutput = new ItemStack(concrete, 4);
        GameRegistry.addShapelessRecipe(shapelessOutput, shapelessInput);
        
        ItemStack shapedOutput = new ItemStack(concrete, 16);
        GameRegistry.addRecipe(shapedOutput,
        	"   ", 
        	" # ", 
        	"   ", 
        	'#', Blocks.cobblestone
        );
        GameRegistry.addRecipe(shapedOutput,
            	"A5*", 
            	" # ", 
            	"   ", 
            	'A', Items.apple, '5', Items.cake, '*', Blocks.grass, '#', Blocks.cobblestone
            );
        ItemStack shaped2x2Output = new ItemStack(concrete, 4);
        GameRegistry.addRecipe(shaped2x2Output,
            	"DD", 
            	'D', Blocks.cobblestone
            );
        ItemStack shapedOutput1 = new ItemStack(concrete, 1);
        GameRegistry.addRecipe(shapedOutput1,
        		"###",
        		"*U*",
        		"###",
        		'#', Blocks.cobblestone, '*', Items.nether_star, 'U', Items.bucket
        	);
        GameRegistry.addSmelting(Blocks.cobblestone, new ItemStack(concrete), 1F);
        ItemStack OPickaxe = new ItemStack(Items.iron_pickaxe);
        OPickaxe.addEnchantment(Enchantment.silkTouch, 1);    
        OPickaxe.addEnchantment(Enchantment.efficiency, 127);   
        GameRegistry.addShapelessRecipe(OPickaxe, Items.iron_pickaxe, Items.stick);
        }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	System.out.println("Tutorial postInit");
    }
}
