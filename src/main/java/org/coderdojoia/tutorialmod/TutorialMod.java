package org.coderdojoia.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.coderdojoia.tutorialmod.BlockConcrete;
import org.coderdojoia.tutorialmod.Cement;

@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION, name="tutorialmod")
public class TutorialMod
{
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "1.0";
    public static Block concrete;
    public static Block limestone;
    public static MaterialLiquid cement;
    public static Item cement_bucket;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	concrete = new BlockConcrete();
    	GameRegistry.registerBlock(concrete, "Concrete");
    	limestone = new BlockLimestone();
    	GameRegistry.registerBlock(limestone, "Limestone");
    	cement_bucket = new ItemCement_Bucket();
    	GameRegistry.registerItem(cement_bucket, "Cement Bucket");
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	/*
    	 * Let's create some recipes for concrete:
    	 *   1) a 'shapeless' recipe of  
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
